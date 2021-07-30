package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.util.UUID;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static com.mycompany.vertxschematester.Constants.TRACE;

public class AudienceNGTest {

    private static final String NF_TYPE = "AF";
    private static final JsonArray NF_INSTANCE_ID_LIST = new JsonArray()
            .add(UUID.randomUUID().toString())
            .add(UUID.randomUUID().toString());


    private JsonValidator validator = Ts3gppValidators.AUDIENCE;
    
    @Test
    public void validate() {

        JsonObject json = createAudience();

        try {
            validator.validate(json.encode());
        } catch (Throwable th) {
            if (TRACE) {
                th.printStackTrace();
            }
            fail("invalid json", th);
        }
    }
    
    public static JsonObject createAudience() {
        return createAudience(NF_TYPE, NF_INSTANCE_ID_LIST);
    }

    public static JsonObject createAudience(String nfType, JsonArray nfInstanceIdList) {
        return new JsonObject()
                .put("nfType", nfType)
                .put("nfInstanceIdList", nfInstanceIdList);
    }

}
