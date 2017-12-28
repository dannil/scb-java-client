package com.github.dannil.scbjavaclient.test.extensions.allowfailure;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.dannil.scbjavaclient.test.extensions.NoticeStrategy;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Suite
public class AllowFailureExtensionTest {

    @Test
    @AllowFailure
    public void trueDefault() {
        assertTrue(true);
    }

    @Test
    @AllowFailure
    public void falseDefault() {
        assertTrue(false);
    }

    @Test
    @AllowFailure(notice = NoticeStrategy.ALWAYS)
    public void trueAlways() {
        assertTrue(true);
    }

    @Test
    @AllowFailure(notice = NoticeStrategy.NEVER)
    public void falseNever() {
        assertTrue(false);
    }

    @Test
    @AllowFailure(notice = NoticeStrategy.NEVER)
    public void trueNever() {
        assertTrue(true);
    }

    @Test
    @AllowFailure(notice = NoticeStrategy.ALWAYS)
    public void falseAlways() {
        assertTrue(false);
    }

    @Test
    @AllowFailure(notice = NoticeStrategy.ON_FAILURE)
    public void trueOnFailure() {
        assertTrue(true);
    }

    @Test
    public void testing() {
        Logger l = LoggerFactory.getLogger(this.getClass().getName());
        l.info("test");
    }

    @Test
    @AllowFailure(notice = NoticeStrategy.ON_FAILURE)
    public void falseOnFailure() {
        assertTrue(false);
    }

    @Test
    @AllowFailure(notice = NoticeStrategy.ON_SUCCESS)
    public void trueOnSuccess() {
        assertTrue(true);
    }

    @Test
    @AllowFailure(notice = NoticeStrategy.ON_SUCCESS)
    public void falseOnSuccess() {
        assertTrue(false);
    }

}
