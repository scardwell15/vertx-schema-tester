package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static com.mycompany.vertxschematester.Constants.TRACE;

public class N2InterfaceAmfInfoNGTest {

    private static final JsonArray IPV4_ENDPOINT_ADDRESSES = new JsonArray().add("1.1.1.1");
    private static final JsonArray IPV6_ENDPOINT_ADDRESSES = new JsonArray().add("2001:0db8:85a3:0000:0000:8a2e:0370:7334");
    private static final String AMF_NAME = "amf-name";

    private JsonValidator validator = Ts3gppValidators.N2_INTERFACE_AMF_INFO;
    
    @Test
    public void validate() {

        JsonObject json = createN2InterfaceAmfInfo();

        try {
            validator.validate(json.encode());
        } catch (Throwable th) {
            if (TRACE) {
                th.printStackTrace();
            }
            fail("invalid json", th);
        }
    }
    
    public static JsonObject createN2InterfaceAmfInfo() {
        return createN2InterfaceAmfInfo(IPV4_ENDPOINT_ADDRESSES, IPV6_ENDPOINT_ADDRESSES, AMF_NAME);
    }

    public static JsonObject createN2InterfaceAmfInfo(JsonArray ipv4EndpointAddress, JsonArray ipv6EndpointAddress, String amfName) {
        return new JsonObject()
                .put("ipv4EndpointAddress", ipv4EndpointAddress)
                .put("ipv6EndpointAddress", ipv6EndpointAddress)
                .put("amfName", amfName);
    }
}
