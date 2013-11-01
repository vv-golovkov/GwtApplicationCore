package com.app.shared.transport.common;

import java.util.List;

import com.app.shared.transport.ResourceDto;
import com.google.gwt.user.client.rpc.IsSerializable;

public class DefServiceResponse implements IsSerializable {
    private String stringResponse;
    private ResourceDto resourceDtoResponse;
    private List<ResourceDto> resourceDtoListResponse;
    
    /************************************** CONSTRUCTORS **************************************/
    private DefServiceResponse() {}
    
    public DefServiceResponse(String stringResponse) {
        this.stringResponse = stringResponse;
    }
    
    public DefServiceResponse(ResourceDto resourceDtoResponse) {
        this.resourceDtoResponse = resourceDtoResponse;
    }
    
    public DefServiceResponse(List<ResourceDto> resourceDtoListResponse) {
        this.resourceDtoListResponse = resourceDtoListResponse;
    }
    /************************************** GETTERS **************************************/
    public String getStringResponse() {
        return stringResponse;
    }
    
    public ResourceDto getResourceDtoResponse() {
        return resourceDtoResponse;
    }
    
    public List<ResourceDto> getResourceDtoListResponse() {
        return resourceDtoListResponse;
    }
    
    /************************************** METHODS **************************************/
    public static DefServiceResponse stub() {
        return new DefServiceResponse();
    }
}
