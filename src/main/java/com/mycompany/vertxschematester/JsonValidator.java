package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public interface JsonValidator extends Validator {
    public static JsonValidator createValidator(String path) {
        return new JsonValidatorImpl(path);
    }
    
    /**
     * Checks that the passed in json string matches the correct Schema.
     *
     * @param json the json string to validate
     * @throws JsonValidationException If validation fails
     */
    @Override
    void validate(String json) throws JsonValidationException;
    
    /**
     * Checks that the passed in vertx JSON object matches the correct Schema.
     *
     * @param json the json string to validate
     * @throws JsonValidationException If validation fails
     */
    void validate(JsonObject json) throws JsonValidationException;
    
    /**
     * Checks that the passed in vertx JSON array matches the correct Schema.
     *
     * @param json the json string to validate
     * @throws JsonValidationException If validation fails
     */
    void validate(JsonArray json) throws JsonValidationException;

}