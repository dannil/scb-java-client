package com.github.dannil.scbjavaclient.client;

import java.util.Locale;

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
