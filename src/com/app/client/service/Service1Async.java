package com.app.client.service;

import com.app.shared.transport.common.DefServiceResponse;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Service1Async {
    void getMultipleResources(AsyncCallback<DefServiceResponse> callback);
    void getOneResource(AsyncCallback<DefServiceResponse> callback);
    void getString(String str, AsyncCallback<DefServiceResponse> callback);
    void submit(String str, AsyncCallback<DefServiceResponse> callback);
}
