package kz.kbtu.demotest.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloMessageGenerator {

    private String message;

    public HelloMessageGenerator() {
        log.info("HelloMessageGenerator");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

}
