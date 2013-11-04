package com.app.client.engine.util;

import com.app.client.service.Service1;
import com.app.client.service.Service1Async;

public final class AsyncRpcFactory {

    public Service1Async getService1Async() {
        return Service1.Util.getInstance();
    }
}
