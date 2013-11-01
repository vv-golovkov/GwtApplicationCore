package com.app.shared.transport;

import com.google.gwt.user.client.rpc.IsSerializable;

public class DtoBase implements IsSerializable {
    private long instId;

    public final long getInstId() {
        return instId;
    }

    public final void setInstId(long instId) {
        this.instId = instId;
    }
}
