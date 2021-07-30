package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static com.mycompany.vertxschematester.Constants.*;

public class BindingRespNGTest {

    private static final String PCF_SM_FQDN = FQDN;
    private static final JsonArray PCF_SM_IP_END_POINTS = new JsonArray()
            .add(IpEndPointNGTest.createIpEndPoint(IPV4_1, IPV6_1, "TCP", 0));

    private JsonValidator validator = Ts3gppValidators.BINDING_RESP;

    @Test
    public void validate() {

        JsonObject json = createBindingResp();

        try {
            validator.validate(json.encode());
        } catch (Throwable th) {
            if (TRACE) {
                th.printStackTrace();
            }
            fail("invalid json", th);
        }
    }
    
    public static JsonObject createBindingResp() {
        return createBindingResp(PCF_SM_FQDN, PCF_SM_IP_END_POINTS);
    }

    public static JsonObject createBindingResp(String pcfSmFqdn, JsonArray pcfSmIpEndPoints) {
        return new JsonObject()
                .put("pcfSmFqdn", pcfSmFqdn)
                .put("pcfSmIpEndPoints", pcfSmIpEndPoints);
    }

}
