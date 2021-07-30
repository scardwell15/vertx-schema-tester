package com.mycompany.vertxschematester;

import io.vertx.core.json.DecodeException;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.json.schema.Schema;
import io.vertx.json.schema.ValidationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JsonValidatorImpl implements JsonValidator {
    final String schemaName;
    final Schema schema;
    
    public JsonValidatorImpl(String schemaPath) {
        schemaName = schemaPath;
        schema = JsonValidationUtils.loadSchemaFromFile(schemaPath);
    }
    
    /**
     * Checks that the passed in json string matches the correct Schema.
     * Note that the given string must be a JSON object or JSON array.
     *
     * @param json the json string to validate
     * @throws JsonValidationException If validation fails
     */
    @Override
    public void validate(String json) throws JsonValidationException {
        try {
            Object jsonClass = Json.decodeValue(json);
            if(jsonClass instanceof JsonObject) {
                validate((JsonObject) jsonClass);
            } else if(jsonClass instanceof JsonArray) {
                validate((JsonArray) jsonClass);
            }
        } catch (DecodeException ex) {
            throw new JsonValidationException(ex);
        }
    }
    
    /**
     * Checks that the passed in vertx JSON object matches the correct Schema.
     *
     * @param json the json string to validate
     * @throws JsonValidationException If validation fails
     */
    @Override
    public void validate(JsonObject json) throws JsonValidationException {
        validate((Object) json);
    }
    
    /**
     * Checks that the passed in vertx JSON object matches the correct Schema.
     *
     * @param json the json string to validate
     * @throws JsonValidationException If validation fails
     */
    @Override
    public void validate(JsonArray json) throws JsonValidationException {
        validate((Object) json);
    }
    
    /**
     * validate an object. not meant for use outside of the class as the schema
     * first validates against the type of object passed in, whether its an array,
     * object, string, etc.
     * @param object object to validate
     * @throws JsonValidationException 
     */
    private void validate(Object object) throws JsonValidationException {
        try {
            CompletableFuture<Void> future = new CompletableFuture<>();
            
            schema.validateAsync(object).onSuccess(future::complete).onFailure(future::completeExceptionally);
            
            future.get(250, TimeUnit.MILLISECONDS);
        } catch (ValidationException ex) {
            throw new JsonValidationException(ex);
        } catch (ExecutionException ex) {
            if(ex.getCause() instanceof ValidationException) {
                throw new JsonValidationException(ex.getCause());
            } else {
                throw new RuntimeException(ex.getCause());
            }
        } catch (InterruptedException | TimeoutException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Returns the schema for this validator.
     * @return the json schema
     */
    @Override
    public Schema getJsonSchema() {
        return this.schema;
    }
}