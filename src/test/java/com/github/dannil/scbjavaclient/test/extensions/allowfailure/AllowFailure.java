package com.github.dannil.scbjavaclient.test.extensions.allowfailure;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.github.dannil.scbjavaclient.test.extensions.NoticeStrategy;

import org.junit.jupiter.api.extension.ExtendWith;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ExtendWith(AllowFailureExtension.class)
public @interface AllowFailure {

    NoticeStrategy notice() default NoticeStrategy.ALWAYS;

}
