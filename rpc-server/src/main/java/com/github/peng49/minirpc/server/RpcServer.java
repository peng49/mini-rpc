package com.github.peng49.minirpc.server;

import com.github.peng49.minirpc.codec.Decoder;
import com.github.peng49.minirpc.codec.Encoder;
import com.github.peng49.minirpc.common.utils.ReflectionUtils;
import com.github.peng49.minirpc.proto.Request;
import com.github.peng49.minirpc.proto.Response;
import com.github.peng49.minirpc.transport.RequestHandler;
import com.github.peng49.minirpc.transport.TransportServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Slf4j
public class RpcServer {
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;

    public RpcServer(){

    }

    public RpcServer(RpcServerConfig config) {
        this.config = config;

        this.net = ReflectionUtils.newInstance(config.getTransportServerClass());

        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());

        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());

        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();

    }


    public <T> void register(Class<T> interfaceClass, T bean) {
        serviceManager.register(interfaceClass, bean);
    }

    public void start() {
        this.net.start();
    }

    public void stop() {
        this.net.stop();
    }

    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream revive, OutputStream toResp) {
            Response resp = new Response();
            try {
                byte[] bytes = IOUtils.readFully(revive, revive.available());
                Request request = decoder.decode(bytes, Request.class);
                log.info("handler get request: {}" ,request);

                ServiceInstance sis = serviceManager.lookup(request);
                Object ret = serviceInvoker.invoke(sis, request);

                resp.setData(ret);
            }catch (IOException e){
                log.warn(e.getMessage());
                resp.setCode(1);
                resp.setMessage(e.getMessage());
                e.printStackTrace();
            }


            byte[] out = encoder.encode(resp);
            try {
                toResp.write(out);
            } catch (IOException e) {
                e.printStackTrace();

                log.info("response exception: {}",e.getMessage());
            }
        }
    };
}
