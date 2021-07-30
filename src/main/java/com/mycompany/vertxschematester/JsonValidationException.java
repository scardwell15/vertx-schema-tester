package com.mycompany.vertxschematester;

public class JsonValidationException extends Exception {

    public JsonValidationException(String message) {
        super(message);
    }

    public JsonValidationException(Throwable cause) {
        super(cause);
    }

    public JsonValidationException(String message, Throwable cause) {
        super(message, cause);
    }

}
