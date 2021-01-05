package com.github.peng49.minirpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

public interface RequestHandler {
    void onRequest(InputStream revive, OutputStream toResp);
}
