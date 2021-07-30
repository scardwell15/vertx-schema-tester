package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonObject;
import java.util.Arrays;
import java.util.List;
import utils.TestUtil;
import static com.mycompany.vertxschematester.Constants.TRACE;
import io.vertx.core.json.JsonArray;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;

public class LmfInfoNGTest {

    private static final List<String> EXTERNAL_CLIENT_TYPE = Arrays.asList("EMERGENCY_SERVICES");
    private static final String LMF_ID = "lmf-id-1";
    private static final List<String> SERVING_ACCESS_TYPES = Arrays.asList("NON_3GPP_ACCESS");
    private static final List<String> SERVING_ANNODE_TYPES = Arrays.asList("GNB");
    private static final List<String> SERVING_RAT_TYPES = Arrays.asList("EUTRA");

    private JsonValidator validator = Ts3gppValidators.LMF_INFO;
    

    @Test
    public void validate() {

        JsonObject json = createLmfInfo();

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
    public void ClearArraysRequiredToHaveEntries() {
        for(int i = 0; i < 10; i++) {
            JsonObject json = createLmfInfo();

            // Clear externalClientType
            JsonObject copy = json.copy();
            copy.getJsonArray("externalClientType").remove(0);

            TestUtil.assertSchema(validator, copy, false);

            // Clear servingAccessTypes
            copy = json.copy();
            copy.getJsonArray("servingAccessTypes").remove(0);

            TestUtil.assertSchema(validator, copy, false);

            // Clear servingAnNodeTypes
            copy = json.copy();
            copy.getJsonArray("servingAnNodeTypes").remove(0);

            TestUtil.assertSchema(validator, copy, false);

            // Clear servingRatTypes
            copy = json.copy();
            copy.getJsonArray("servingRatTypes").remove(0);

            TestUtil.assertSchema(validator, copy, false);
        }
    }

    public static JsonObject createLmfInfo() {

        JsonObject lmfInfo = new JsonObject();
        lmfInfo.put("externalClientType", new JsonArray(EXTERNAL_CLIENT_TYPE));
        lmfInfo.put("lmfId", LMF_ID);
        lmfInfo.put("servingAccessTypes", new JsonArray(SERVING_ACCESS_TYPES));
        lmfInfo.put("servingAnNodeTypes", new JsonArray(SERVING_ANNODE_TYPES));
        lmfInfo.put("servingRatTypes", new JsonArray(SERVING_RAT_TYPES));

        return lmfInfo;
    }
}
