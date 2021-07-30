package com.mycompany.vertxschematester;

import io.vertx.core.json.JsonObject;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static com.mycompany.vertxschematester.Constants.TRACE;

public class AfEventExposureDataNGTest {
    
    private static final List<String> AF_EVENTS = List.of("EXCEPTIONS", "SVC_EXPERIENCE");
    private static final List<String> AF_ID = List.of("af-id-1", "af-id-2");
    private static final List<String> APP_IDS = List.of("app-id-1", "app-id-2");

    private JsonValidator validator = Ts3gppValidators.AF_EVENT_EXPOSURE_DATA;
    
    @Test
    public void validate() {

        JsonObject json = createAfEventExposureData();

        try {
            validator.validate(json.encode());
        } catch (Throwable th) {
            if (TRACE) {
                th.printStackTrace();
            }
            fail("invalid json", th);
        }
    }
    
    public static JsonObject createAfEventExposureData() {
        return createAfEventExposureData(AF_EVENTS, AF_ID, APP_IDS);
    }

    public static JsonObject createAfEventExposureData(List<String> afEvents, 
            List<String> afId, List<String> appIds) {
        
        return new JsonObject()
                .put("afEvents", afEvents)
                .put("afId", afId)
                .put("appIds", appIds);
    }

}
