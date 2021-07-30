package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonObject;
import utils.TestUtil;
import static com.mycompany.vertxschematester.Constants.TRACE;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;

public class LinkNGTest {

    private static final String URI = "https://netnumber.com";

    private JsonValidator validator = Ts3gppValidators.LINK;
    
    @Test
    public void validate() {

        JsonObject json = createLink();

        try {
            validator.validate(json.encode());
        } catch (Throwable th) {
            if (TRACE) {
                th.printStackTrace();
            }
            fail("invalid json", th);
        }
    }

    @Test
    public void removeHref() {

        JsonObject json = createLink();
        json.remove("href");

        TestUtil.assertSchema(validator, json, false);
    }

    public static JsonObject createLink() {
        return new JsonObject().put("href", URI);
    }
}
