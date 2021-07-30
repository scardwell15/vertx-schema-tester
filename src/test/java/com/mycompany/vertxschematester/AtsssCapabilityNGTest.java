package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonObject;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static com.mycompany.vertxschematester.Constants.TRACE;

public class AtsssCapabilityNGTest {

    private static final boolean ATSSSLL = true;
    private static final boolean MPTCP = true;
    private static final boolean RTT_WITHOUT_PMF = true;

    private JsonValidator validator = Ts3gppValidators.ATSSS_CAPABILITY;
    
    @Test
    public void validate() {

        JsonObject json = createAtsssCapability();

        try {
            validator.validate(json.encode());
        } catch (Throwable th) {
            if (TRACE) {
                th.printStackTrace();
            }
            fail("invalid json", th);
        }
    }
    
    public static JsonObject createAtsssCapability() {
        return createAtsssCapability(ATSSSLL, MPTCP, RTT_WITHOUT_PMF);
    }

    public static JsonObject createAtsssCapability(boolean atsssLL, boolean mptcp, boolean rttWithoutPmf) {
        return new JsonObject()
                .put("atsssLL", atsssLL)
                .put("mptcp", mptcp)
                .put("rttWithoutPmf", rttWithoutPmf);
    }

}
