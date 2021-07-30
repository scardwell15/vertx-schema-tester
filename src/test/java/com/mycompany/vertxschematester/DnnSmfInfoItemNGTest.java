package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonObject;
import utils.TestUtil;
import static com.mycompany.vertxschematester.Constants.TRACE;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;

public class DnnSmfInfoItemNGTest {

    private static final String DNN = "dnn-1";
    
    private JsonValidator validator = Ts3gppValidators.DNN_SMF_INFO_ITEM;
    
    @Test
    public void validate() {

        JsonObject json = createDnnSmfInfoItem();

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
    public void removeDnn() {

        JsonObject json = createDnnSmfInfoItem();
        json.remove("dnn");

        TestUtil.assertSchema(validator, json, false);
    }

    public static JsonObject createDnnSmfInfoItem() {
        return new JsonObject().put("dnn", DNN);
    }
}
