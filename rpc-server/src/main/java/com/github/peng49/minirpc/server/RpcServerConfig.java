package com.github.peng49.minirpc.server;

import com.github.peng49.minirpc.codec.Decoder;
import com.github.peng49.minirpc.codec.Encoder;
import com.github.peng49.minirpc.codec.JSONDecoder;
import com.github.peng49.minirpc.codec.JSONEncoder;
import com.github.peng49.minirpc.transport.HttpTransportServer;
import com.github.peng49.minirpc.transport.TransportServer;
import lombok.Data;

@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportServerClass = HttpTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;

    private int port = 3000;
}
