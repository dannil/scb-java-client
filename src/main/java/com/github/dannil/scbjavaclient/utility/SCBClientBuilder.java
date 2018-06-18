package com.github.dannil.scbjavaclient.utility;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.http.HttpProtocol;

public class SCBClientBuilder {

    private SCBClient client;

    public SCBClientBuilder() {
        this.client = new SCBClient();
    }

    public SCBClientBuilder setLocale(Locale locale) {
        this.client.setLocale(locale);
        return this;
    }

    public SCBClientBuilder setHttpProtocol(HttpProtocol httpProtocol) {
        this.client.setHttpProtocol(httpProtocol);
        return this;
    }

    public SCBClient build() {
        return this.client;
    }

}
