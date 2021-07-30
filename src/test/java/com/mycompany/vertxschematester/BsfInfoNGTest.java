package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.util.Arrays;
import java.util.List;
import static com.mycompany.vertxschematester.Constants.IPV4_1;
import static com.mycompany.vertxschematester.Constants.IPV4_2;
import static com.mycompany.vertxschematester.Constants.IPV6_PREFIX_1;
import static com.mycompany.vertxschematester.Constants.IPV6_PREFIX_2;
import static com.mycompany.vertxschematester.Constants.TRACE;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;

public class BsfInfoNGTest {
    
    private static final JsonArray IPV4_ADDRESS_RANGES = new JsonArray()
            .add(Ipv4AddressRangeNGTest.createIpv4AddressRange(IPV4_1, IPV4_2));
    private static final List<String> DNN_LIST = Arrays.asList("dnn-1"); 
    private static final List<String> IP_DOMAIN_LIST = Arrays.asList("ip-domain-1"); 
    private static final JsonArray IPV6_PREFIX_RANGES = new JsonArray()
            .add(Ipv6PrefixRangeNGTest.createIpv6PrefixRange(IPV6_PREFIX_1, IPV6_PREFIX_2));
    
    private JsonValidator validator = Ts3gppValidators.BSF_INFO;
    
    @Test 
    public void validate() {
        
        JsonObject json = createBsfInfo();

        try {
            validator.validate(json.encode());
        } catch (Throwable th) {
            if (TRACE) {
                th.printStackTrace();
            }
            fail("invalid json", th);
        }
    }
    
    public static JsonObject createBsfInfo() {
        return new JsonObject()
                .put("ipv4AddressRanges", IPV4_ADDRESS_RANGES)
                .put("dnnList", new JsonArray(DNN_LIST))
                .put("ipDomainList", new JsonArray(IP_DOMAIN_LIST))
                .put("ipv6PrefixRanges", IPV6_PREFIX_RANGES);
    }
    
}
