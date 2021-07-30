package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import static com.mycompany.vertxschematester.Constants.TRACE;
import utils.TestUtil;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;

public class DefaultNotificationSubscriptionNGTest {

    private static final String NOTIFICATION_TYPE = "DATA_CHANGE_NOTIFICATION";
    private static final String CALLBACK_URI = "https://netnumber.com";
    private static final String N1MESSAGE_CLASS = "LCS";
    private static final String N2INFORMATION_CLASS = "NRPPa";
    private static final JsonArray VERSIONS = new JsonArray().add("v1");
    private static final String BINDING = "binding-1";

    private JsonValidator validator = Ts3gppValidators.DEFAULT_NOTIFICATION_SUBSCRIPTION;
    
    @Test
    public void validate() {

        JsonObject json = createDefaultNotificationSubscription();

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
    public void removeRequiredFields() {

        JsonObject json = createDefaultNotificationSubscription();

        // remove notificationType
        JsonObject copy = json.copy();
        copy.remove("notificationType");

        TestUtil.assertSchema(validator, copy, false);

        // remove callbackUri
        copy = json.copy();
        copy.remove("callbackUri");

        TestUtil.assertSchema(validator, copy, false);
    }

    @Test
    public void clearVersions() {

        JsonObject json = createDefaultNotificationSubscription();
        json.getJsonArray("versions").remove(0);

        TestUtil.assertSchema(validator, json, false);
    }

    public static JsonObject createDefaultNotificationSubscription() {

        JsonObject defaultNotificationSubscription = new JsonObject();
        defaultNotificationSubscription.put("notificationType", NOTIFICATION_TYPE);
        defaultNotificationSubscription.put("callbackUri", CALLBACK_URI);
        defaultNotificationSubscription.put("n1MessageClass", N1MESSAGE_CLASS);
        defaultNotificationSubscription.put("n2InformationClass", N2INFORMATION_CLASS);
        defaultNotificationSubscription.put("versions", VERSIONS.copy());
        defaultNotificationSubscription.put("binding", BINDING);

        return defaultNotificationSubscription;
    }
}
