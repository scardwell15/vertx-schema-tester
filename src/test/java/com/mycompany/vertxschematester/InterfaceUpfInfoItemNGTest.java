package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.util.Arrays;
import java.util.List;
import static com.mycompany.vertxschematester.Constants.FQDN;
import static com.mycompany.vertxschematester.Constants.IPV4_1;
import static com.mycompany.vertxschematester.Constants.IPV6_1;
import static com.mycompany.vertxschematester.Constants.TRACE;
import utils.TestUtil;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;

public class InterfaceUpfInfoItemNGTest {
    
    private static final String INTERFACE_TYPE = "N3";
    private static final List<String> IPV4_ENDPOINT_ADDRESSES = Arrays.asList(IPV4_1);
    private static final List<String> IPV6_ENDPOINT_ADDRESSES = Arrays.asList(IPV6_1);
    private static final String ENDPOINT_FQDN = FQDN;
    private static final String NETWORK_INSTANCE = "network instance"; 
    
    private JsonValidator validator = Ts3gppValidators.INTERFACE_UPF_INFO_ITEM;
    
    @Test 
    public void validate() {
        
        JsonObject json = createInterfaceUpfInfoItem();

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
    public void removeInterfaceType() {
        JsonObject json = createInterfaceUpfInfoItem();
        json.remove("interfaceType"); 
        
        TestUtil.assertSchema(validator, json, false);
    }
    
    public static JsonObject createInterfaceUpfInfoItem() {
        return new JsonObject()
                .put("interfaceType", INTERFACE_TYPE)
                .put("ipv4EndpointAddresses", new JsonArray(IPV4_ENDPOINT_ADDRESSES))
                .put("ipv6EndpointAddresses", new JsonArray(IPV6_ENDPOINT_ADDRESSES))
                .put("endpointFqdn", ENDPOINT_FQDN)
                .put("networkInstance", NETWORK_INSTANCE); 
    }
}
