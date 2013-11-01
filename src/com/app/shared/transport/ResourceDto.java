package com.app.shared.transport;

public class ResourceDto extends DtoBase {
    private String name;
    
    private ResourceDto() {}
    
    public ResourceDto(long instId, String name) {
        setInstId(instId);
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return getInstId() + " == " + name;
    }
}
