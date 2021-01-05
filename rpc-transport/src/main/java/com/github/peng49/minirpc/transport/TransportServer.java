package com.github.peng49.minirpc.transport;

/**
 *
 */
public interface TransportServer {
    void init(int port, RequestHandler handler);

    void start();

    void stop();
}
