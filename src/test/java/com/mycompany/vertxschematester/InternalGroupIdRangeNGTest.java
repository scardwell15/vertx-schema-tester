package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonObject;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static com.mycompany.vertxschematester.Constants.TRACE;

public class InternalGroupIdRangeNGTest {

    private static final String START = "12345678-123-123-11";
    private static final String END = "12345678-123-123-22";
    private static final String PATTERN = "pattern-value";

    private JsonValidator validator = Ts3gppValidators.INTERNAL_GROUP_ID_RANGE;
    
    @Test
    public void validate() {

        JsonObject json = createInternalGroupIdRange();

        try {
            validator.validate(json.encode());
        } catch (Throwable th) {
            if (TRACE) {
                th.printStackTrace();
            }
            fail("invalid json", th);
        }
    }
    
    public static JsonObject createInternalGroupIdRange() {
        return createInternalGroupIdRange(START, END, PATTERN);
    }

    public static JsonObject createInternalGroupIdRange(String start, String end, String pattern) {
        return new JsonObject()
                .put("start", start)
                .put("end", end)
                .put("pattern", pattern);
    }

}
