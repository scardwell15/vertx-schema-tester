package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonObject;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static com.mycompany.vertxschematester.Constants.*;
import utils.TestUtil;

public class Ipv6PrefixRangeNGTest {

    private static final String START = IPV6_PREFIX_1;
    private static final String END = IPV6_PREFIX_2;

    private JsonValidator validator = Ts3gppValidators.IPV6_PREFIX_RANGE;
    
    @Test
    public void validate() {

        JsonObject json = createIpv6PrefixRange();

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

        JsonObject json = createIpv6PrefixRange();
        json.remove("start");

        TestUtil.assertSchema(validator, json, false);
    }

    @Test
    public void removeEnd() {

        JsonObject json = createIpv6PrefixRange();
        json.remove("end");

        TestUtil.assertSchema(validator, json, false);
    }
    
    public static JsonObject createIpv6PrefixRange() {
        return createIpv6PrefixRange(START, END);
    }

    public static JsonObject createIpv6PrefixRange(String start, String end) {
        return new JsonObject()
                .put("start", start)
                .put("end", end);
    }

}
