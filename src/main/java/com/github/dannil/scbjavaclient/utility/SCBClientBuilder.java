package com.github.dannil.scbjavaclient.utility;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.SCBClient;

public class SCBClientBuilder {

    private SCBClient client;

    public SCBClientBuilder() {
        this.client = new SCBClient();
    }

    public SCBClientBuilder setLocale(Locale locale) {
        this.client.setLocale(locale);
        return this;
    }

    public SCBClientBuilder enableHttps() {
        // TODO do some fine logic here which sets HTTPS
        return this;
    }

    public SCBClient build() {
        return this.client;
    }

}
