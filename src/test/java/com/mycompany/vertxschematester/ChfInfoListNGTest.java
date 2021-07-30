/*
 * ChfInfoListNGTest.java
 *
 * Copyright (c) 2021 NetNumber, Inc. All Rights Reserved
 *
 * This software is the proprietary information of NetNumber, Inc. Use is subject
 * to license terms
 *
 * @author NetNumber Inc.
 */
package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonObject;
import static com.mycompany.vertxschematester.Constants.ADDITIONAL_PROPERTIES;
import static com.mycompany.vertxschematester.Constants.TRACE;
import io.vertx.core.json.JsonArray;
import java.util.UUID;
import utils.TestUtil;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;

/**
 *
 * @author ttaybah
 */
public class ChfInfoListNGTest {
        
    private static final JsonArray SUPI_RANGE_LIST = new JsonArray()
            .add(new JsonObject()
                .put("start", "111")
                .put("end", "999")
                .put("pattern", "pattern"));
    
    private static final JsonArray GPSI_RANGE_LIST = new JsonArray()
            .add(new JsonObject()
                .put("start", "123")
                .put("end", "789")
                .put("pattern", "pattern-value"));
    private static final JsonArray PLMN_RANGE_LIST = new JsonArray()
            .add(new JsonObject()
                .put("start", "11122")
                .put("end", "11133")
                .put("pattern", "pattern-value"));
    
    private static final String GROUP_ID = "123456789"; 
    private static final String PRIMARY_CHF_INSTANCE = UUID.randomUUID().toString();
    private static final String SECONDARY_CHF_INSTANCE = UUID.randomUUID().toString();
    
    private static final JsonObject CHF_INFO = new JsonObject()
                .put("supiRangeList", SUPI_RANGE_LIST)
                .put("gpsiRangeList", GPSI_RANGE_LIST)
                .put("plmnRangeList", PLMN_RANGE_LIST)
                .put("groupId", GROUP_ID)
                .put("primaryChfInstance", PRIMARY_CHF_INSTANCE)
                .put("secondaryChfInstance", SECONDARY_CHF_INSTANCE);
    
    private JsonValidator validator = ExtensionsValidators.CHF_INFO_LIST;
    
    @Test 
    public void validate() {
        for(int i = 0; i < 10; i++) {
            JsonObject json = getChfInfoList();

            try {
                validator.validate(json.encode());
            } catch (Throwable th) {
                if (TRACE) {
                    th.printStackTrace();
                }
                fail("invalid json");
            }
        }
    }
    
    @Test 
    public void InvalidAdditionalProperties() {
        JsonObject json = getChfInfoList();
        json.put(ADDITIONAL_PROPERTIES, new JsonObject().put("someKindOfKey", "someKindOfValue")); 

        TestUtil.assertSchema(validator, json, false);
    }
    
    @Test
    public void validateMinItems() {

        JsonObject json = getChfInfoList();
        json.remove(ADDITIONAL_PROPERTIES);

        TestUtil.assertSchema(validator, json, false);
    }
    
    public static JsonObject getChfInfoList() {
        JsonObject chfInfo = new JsonObject();
        chfInfo.put(ADDITIONAL_PROPERTIES, CHF_INFO);
        
        return chfInfo;
    }
}
