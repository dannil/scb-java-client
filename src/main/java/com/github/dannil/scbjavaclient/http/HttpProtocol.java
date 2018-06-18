package com.github.dannil.scbjavaclient.http;

public enum HttpProtocol {

    HTTP("http"), HTTPS("https");

    private String protocol;
    
    private HttpProtocol(String protocol) {
        this.protocol = protocol;
    }
    
    public String getProtocol() {
        return this.protocol;
    }
    
}
