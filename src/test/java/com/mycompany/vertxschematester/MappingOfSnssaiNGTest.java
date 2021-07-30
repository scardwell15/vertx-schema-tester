package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonObject;
import static com.mycompany.vertxschematester.Constants.TRACE;
import utils.TestUtil;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;

public class MappingOfSnssaiNGTest {

    private static JsonObject SERVING_SNSSAI = new JsonObject().put("sst", 1).put("sd", "bE1Ba7");
    private static JsonObject HOME_SNSSAI = new JsonObject().put("sst", 2).put("sd", "E2DeEc");

    private JsonValidator validator = Ts3gppValidators.MAPPING_OF_SNSSAI;
    
    @Test
    public void validate() {

        JsonObject json = createMappingOfSnssai();

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
    public void removeRequiredFields() {

        JsonObject json = createMappingOfSnssai();

        // remove servingSnssai
        JsonObject copy = json.copy();
        copy.remove("servingSnssai");

        TestUtil.assertSchema(validator, copy, false);

        // remove homeSnssai
        copy = json.copy();
        copy.remove("homeSnssai");

        TestUtil.assertSchema(validator, copy, false);
    }

    public static JsonObject createMappingOfSnssai() {
        JsonObject snssai = new JsonObject();
        snssai.put("servingSnssai", SERVING_SNSSAI);
        snssai.put("homeSnssai", HOME_SNSSAI);
        return snssai;
    }
}
