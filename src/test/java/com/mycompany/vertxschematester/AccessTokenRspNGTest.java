package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonObject;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static com.mycompany.vertxschematester.Constants.TRACE;
import utils.TestUtil;

public class AccessTokenRspNGTest {

    private static final String ACCESS_TOKEN = "access-token-value";
    private static final String TOKEN_TYPE = "Bearer";
    private static final int EXPIRES_IN = 1;
    private static final String SCOPE = "scope-value";

    private JsonValidator validator = Ts3gppValidators.ACCESS_TOKEN_RSP;
    
    @Test
    public void validate() {

        JsonObject json = createAccessTokenRsp();

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
    public void removeAccessToken() {

        JsonObject accessTokenRsp = createAccessTokenRsp();
        accessTokenRsp.remove("access_token");
        
        TestUtil.assertSchema(validator, accessTokenRsp, false);
    }

    @Test
    public void removeTokenType() {

        JsonObject accessTokenRsp = createAccessTokenRsp();
        accessTokenRsp.remove("token_type");
        
        TestUtil.assertSchema(validator, accessTokenRsp, false);
    }

    public static JsonObject createAccessTokenRsp() {
        return createAccessTokenRsp(ACCESS_TOKEN, TOKEN_TYPE, EXPIRES_IN, SCOPE);
    }

    public static JsonObject createAccessTokenRsp(String accessToken,
            String tokenType, int expiresIn, String scope) {

        return new JsonObject()
                .put("access_token", accessToken)
                .put("token_type", tokenType)
                .put("expires_in", expiresIn)
                .put("scope", scope);
    }

}
