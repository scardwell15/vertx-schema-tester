package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonObject;
import static com.mycompany.vertxschematester.Constants.TRACE;
import utils.TestUtil;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class AccessTokenErrNGTest {
    
    private static final String ERROR = "invalid_request";
    private static final String ERROR_DESCRIPTION = "error description of the error";
    private static final String ERROR_URI = "http://error.com";
    
    private JsonValidator validator = Ts3gppValidators.ACCESS_TOKEN_ERR;

    @Test
    public void validate() {
    
        JsonObject json = createAccessTokenErr();

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
    public void removeError() {
        
        JsonObject accessTokenErr = createAccessTokenErr();
        accessTokenErr.remove("error");
        
        TestUtil.assertSchema(validator, accessTokenErr, false);
    }

    public static JsonObject createAccessTokenErr() {
        return createAccessTokenErr(ERROR, ERROR_DESCRIPTION, ERROR_URI);
    }
    
    public static JsonObject createAccessTokenErr(String error, 
            String errorDescription, String errorUri) {
        
        return new JsonObject()
                .put("error", error)
                .put("error_description", errorDescription)
                .put("error_uri", errorUri);
    }
    
}
