package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonObject;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;

public class InvalidParamNGTest {

    private static final String PARAM = "Test-param";
    private static final String REASON = "Test-reason";

    private JsonValidator validator = Ts3gppValidators.INVALID_PARAM;
    
    @Test
    public void TestValidJson() {

        JsonObject json = createJson();

        try {
            validator.validate(json.toString());
        } catch (JsonValidationException ex) {
            fail("validation exception thrown", ex);
        }
    }

    public static JsonObject createJson() {
        return createJson(PARAM, REASON);
    }

    public static JsonObject createJson(String param, String reason) {
        JsonObject json = new JsonObject();
        json.put("param", param);
        json.put("reason", reason);
        return json;
    }
}
