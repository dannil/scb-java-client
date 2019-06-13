module com.github.dannil.scbjavaclient {
    requires java.base;

    requires org.apache.commons.io;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    requires org.slf4j;

    exports com.github.dannil.scbjavaclient.client;
    exports com.github.dannil.scbjavaclient.constants;
    exports com.github.dannil.scbjavaclient.format;
    exports com.github.dannil.scbjavaclient.http;
    exports com.github.dannil.scbjavaclient.model;
    exports com.github.dannil.scbjavaclient.utility;
}