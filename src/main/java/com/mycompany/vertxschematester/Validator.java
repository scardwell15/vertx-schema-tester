package com.mycompany.vertxschematester;

import io.vertx.json.schema.Schema;

public interface Validator {
    Schema getJsonSchema();
    
    void validate(String string) throws JsonValidationException;
}
