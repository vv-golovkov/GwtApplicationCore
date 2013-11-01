package com.app.client.service;

import com.app.shared.exception.CoreServiceException;
import com.app.shared.transport.common.DefServiceResponse;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("rpcServices/Service1.rpc")
public interface Service1 extends RemoteService {

    public static final class Util {
        private static final Service1Async INSTANCE = GWT.create(Service1.class);
        private Util() {}
        public static Service1Async getInstance() {
            return INSTANCE;
        }
    }

    DefServiceResponse getString(String str) throws CoreServiceException;
    DefServiceResponse submit(String str) throws CoreServiceException;
    DefServiceResponse getOneResource() throws CoreServiceException;
    DefServiceResponse getMultipleResources() throws CoreServiceException;
}
