package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonObject;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static com.mycompany.vertxschematester.Constants.TRACE;

public class IpEndPointNGTest {

    private static final String IPV4_ADDRESS = "1.1.1.1";
    private static final String IPV6_ADDRESS = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
    private static final String TRANSPORT = "TCP";
    private static final int PORT = 80;

    private JsonValidator validator = Ts3gppValidators.IP_ENDPOINT;
    
    @Test
    public void validate() {

        JsonObject json = createIpEndPoint(IPV4_ADDRESS, IPV6_ADDRESS, TRANSPORT, PORT);

        try {
            validator.validate(json.encode());
        } catch (Throwable th) {
            if (TRACE) {
                th.printStackTrace();
            }
            fail("invalid json", th);
        }
    }
    
    public static JsonObject createIpEndPoint() {
        return createIpEndPoint(IPV4_ADDRESS, IPV6_ADDRESS, TRANSPORT, PORT);
    }

    public static JsonObject createIpEndPoint(String ipv4Address, 
            String ipv6Address, String transport, int port) {
        
        return new JsonObject()
                .put("ipv4Address", ipv4Address)
                .put("ipv6Address", ipv6Address)
                .put("transport", transport)
                .put("port", port);
    }

}
