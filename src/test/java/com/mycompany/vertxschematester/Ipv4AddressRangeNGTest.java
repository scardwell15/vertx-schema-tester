package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonObject;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static com.mycompany.vertxschematester.Constants.*;
import utils.TestUtil;

public class Ipv4AddressRangeNGTest {

    private static final String START = IPV4_1;
    private static final String END = IPV4_2;

    private JsonValidator validator = Ts3gppValidators.IPV4_ADDRESS_RANGE;
    
    @Test
    public void validate() {

        JsonObject json = createIpv4AddressRange();

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
    public void removeStart() {

        JsonObject json = createIpv4AddressRange();
        json.remove("start");

        TestUtil.assertSchema(validator, json, false);
    }

    @Test
    public void removeEnd() {

        JsonObject json = createIpv4AddressRange();
        json.remove("end");

        TestUtil.assertSchema(validator, json, false);
    }
    
    public static JsonObject createIpv4AddressRange() {
        return createIpv4AddressRange(START, END);
    }

    public static JsonObject createIpv4AddressRange(String start, String end) {
        return new JsonObject()
                .put("start", start)
                .put("end", end);
    }

}
