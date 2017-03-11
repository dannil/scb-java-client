package com.github.dannil.scbjavaclient.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.input.BOMInputStream;

public class Response {

    private HttpStatusCode status;
    private InputStream stream;

    public Response(HttpStatusCode status, InputStream stream) {
        this.status = status;
        this.stream = stream;
    }

    public HttpStatusCode getStatus() {
        return status;
    }

    public void setStatus(HttpStatusCode status) {
        this.status = status;
    }

    public InputStream getStream() {
        return stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }

    public String getBody() {
        try (BOMInputStream bis = new BOMInputStream(this.stream)) {
            try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
                for (int result = bis.read(); result != -1; result = bis.read()) {
                    bos.write((byte) result);
                }
                return bos.toString();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
