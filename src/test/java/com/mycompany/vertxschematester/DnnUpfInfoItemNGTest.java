package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.util.List;
import utils.TestUtil;
import static com.mycompany.vertxschematester.Constants.TRACE;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;

public class DnnUpfInfoItemNGTest {

    private static final String DNN = "dnn-0";
    private static final List<String> DNAI_LIST = List.of(DNN);
    private static final List<String> PDU_SESSION_TYPES = List.of("IPV4");
    private static final List<JsonObject> IPV6_PREFIX_RANGES = List.of(new JsonObject().put("start", Constants.IPV6_PREFIX_1).put("end", Constants.IPV6_PREFIX_2));
    private static final List<JsonObject> IPV4_ADDRESS_RANGES = List.of(new JsonObject().put("start", Constants.IPV4_1).put("end", Constants.IPV4_2));

    private JsonValidator validator = Ts3gppValidators.DNN_UPF_INFO_ITEM;
    

    @Test
    public void validate() {

        JsonObject json = createDnnUpfInfoItem();

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
    public void removeServiceName() {

        JsonObject json = createDnnUpfInfoItem();
        json.remove("dnn");

        TestUtil.assertSchema(validator, json, false);
    }

    @Test
    public void ClearArraysRequiredToHaveEntries() {

        JsonObject json = createDnnUpfInfoItem();

        // Clear dnaiList
        JsonObject copy = json.copy();
        copy.getJsonArray("dnaiList").remove(0);

        TestUtil.assertSchema(validator, copy, false);

        // Clear pduSessionTypes
        copy = json.copy();
        copy.getJsonArray("pduSessionTypes").remove(0);

        TestUtil.assertSchema(validator, copy, false);

        // Clear ipv4AddressRanges
        copy = json.copy();
        copy.getJsonArray("ipv4AddressRanges").remove(0);

        TestUtil.assertSchema(validator, copy, false);

        // Clear ipv6PrefixRanges
        copy = json.copy();
        copy.getJsonArray("ipv6PrefixRanges").remove(0);

        TestUtil.assertSchema(validator, copy, false);
    }

    public static JsonObject createDnnUpfInfoItem() {

        JsonObject dnnUpfInfoItem = new JsonObject();
        dnnUpfInfoItem.put("dnn", DNN);
        dnnUpfInfoItem.put("dnaiList", new JsonArray(DNAI_LIST));
        dnnUpfInfoItem.put("pduSessionTypes", new JsonArray(PDU_SESSION_TYPES));
        
        dnnUpfInfoItem.put("ipv4AddressRanges", new JsonArray(IPV4_ADDRESS_RANGES));
        
        dnnUpfInfoItem.put("ipv6PrefixRanges", new JsonArray(IPV6_PREFIX_RANGES));
        return dnnUpfInfoItem;
    }
}
