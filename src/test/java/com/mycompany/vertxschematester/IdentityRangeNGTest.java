package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonObject;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static com.mycompany.vertxschematester.Constants.TRACE;

public class IdentityRangeNGTest {

    private static final String START = "123";
    private static final String END = "789";
    private static final String PATTERN = "pattern-value";

    private JsonValidator validator = Ts3gppValidators.IDENTITY_RANGE;
    
    @Test
    public void validate() {

        JsonObject json = createIdentityRange();

        try {
            validator.validate(json.encode());
        } catch (Throwable th) {
            if (TRACE) {
                th.printStackTrace();
            }
            fail("invalid json", th);
        }
    }
    
    public static JsonObject createIdentityRange() {
        return createIdentityRange(START, END, PATTERN);
    }

    public static JsonObject createIdentityRange(String start, String end, String pattern) {
        return new JsonObject()
                .put("start", start)
                .put("end", end)
                .put("pattern", pattern);
    }

}
