package com.app.server.remote;

import java.util.ArrayList;
import java.util.List;

import com.app.client.service.Service1;
import com.app.shared.exception.CoreServiceException;
import com.app.shared.transport.ResourceDto;
import com.app.shared.transport.common.DefServiceResponse;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RemoteServiceServlet1 extends RemoteServiceServlet implements Service1 {
    private static final long serialVersionUID = 1L;

    @Override
    public DefServiceResponse getString(String str) throws CoreServiceException {
        return new DefServiceResponse(str + " === RESPONSE");
    }

    @Override
    public DefServiceResponse submit(String str) throws CoreServiceException {
        return DefServiceResponse.stub();
    }

    @Override
    public DefServiceResponse getOneResource() throws CoreServiceException {
        return new DefServiceResponse(new ResourceDto(99, "name99"));
    }

    @Override
    public DefServiceResponse getMultipleResources() throws CoreServiceException {
        List<ResourceDto> list = new ArrayList<ResourceDto>();
        list.add(new ResourceDto(1, "name1"));
        list.add(new ResourceDto(2, "name2"));
        return new DefServiceResponse(list);
    }
}
