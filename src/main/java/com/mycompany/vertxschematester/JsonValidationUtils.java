package com.mycompany.vertxschematester;

import io.vertx.core.Vertx;
import io.vertx.core.json.pointer.JsonPointer;
import io.vertx.json.schema.Schema;
import io.vertx.json.schema.SchemaParser;
import io.vertx.json.schema.SchemaRouter;
import io.vertx.json.schema.SchemaRouterOptions;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class JsonValidationUtils {
    private static final SchemaRouter ROUTER = SchemaRouter.create(Vertx.vertx(), new SchemaRouterOptions());
    public static final SchemaParser PARSER = SchemaParser.createDraft201909SchemaParser(ROUTER);
    
    public static Schema loadSchemaFromFile(String schemaDefName) {
        try {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(schemaDefName);
            if(is == null) {
                System.out.printf("File [%s] does not exist\n", schemaDefName);
                return null;
            }
            
            JsonPointer pointer = getRefPointer(schemaDefName);
            Schema schema = PARSER.parseFromString(new String(is.readAllBytes()), pointer);
            return schema;
        } catch (Exception e) {
            // without this any parsing errors are ignored for some reason
            // TODO: Figure out what to do with this:
            // Events.raise("Unexpected error while loading Schema from file", e);
            //throw new RuntimeException(e);
            System.out.printf("Unexpected error while loading schema from file %s\n%s\n", schemaDefName, getStackTrace(e));
            return null;
        }
    }
    
    public static String getStackTrace(Throwable throwable, String linePrefix) {
        return String.format("%s%s\n%sCaused by..\n%s",
                linePrefix, throwable.getMessage(),
                String.format("%s%s", linePrefix, Arrays.stream(throwable.getStackTrace()).map(ste -> ste.toString()).collect(Collectors.joining("\n"))),
                getStackTrace(throwable.getCause(), linePrefix + "\t"));
    }
    
    public static String getStackTrace(Throwable throwable) {
        return getStackTrace(throwable, "");
    }
    
    private static JsonPointer getRefPointer(String schemaDefName) throws URISyntaxException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return JsonPointer.fromURI(classloader.getResource(schemaDefName).toURI());
    }
}
