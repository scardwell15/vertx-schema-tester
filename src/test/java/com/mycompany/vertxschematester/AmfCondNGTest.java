package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonObject;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static com.mycompany.vertxschematester.Constants.TRACE;

public class AmfCondNGTest {

    private static final String AMF_SET_ID = "0A1";
    private static final String AMF_REGION_ID = "B2";

    private JsonValidator validator = Ts3gppValidators.AMF_COND;
    
    @Test
    public void validate() {

        JsonObject json = createAmfCond();

        try {
            validator.validate(json.encode());
        } catch (Throwable th) {
            if (TRACE) {
                th.printStackTrace();
            }
            fail("invalid json", th);
        }
    }
    
    public static JsonObject createAmfCond() {
        return createAmfCond(AMF_SET_ID, AMF_REGION_ID);
    }

    public static JsonObject createAmfCond(String amfSetId, String amfRegionId) {
        return new JsonObject()
                .put("amfSetId", amfSetId)
                .put("amfRegionId", amfRegionId);
    }

}
