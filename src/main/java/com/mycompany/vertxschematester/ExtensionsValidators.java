package com.mycompany.vertxschematester;

import static com.mycompany.vertxschematester.Constants.get3gppExtensionsPath;

public class ExtensionsValidators {
    public static JsonValidator ALLOWED_OPERATIONS = createValidator("allowed-operations.json");
    public static JsonValidator AMF_INFO_LIST = createValidator("amf-info-list.json");
    public static JsonValidator AUSF_INFO_LIST = createValidator("ausf-info-list.json");
    public static JsonValidator BSF_INFO_LIST = createValidator("bsf-info-list.json");
    public static JsonValidator CHF_INFO_LIST = createValidator("chf-info-list.json");
    public static JsonValidator CUSTOM_INFO = createValidator("custom-info.json");
    public static JsonValidator HSS_INFO = createValidator("hss-info-list.json");
    public static JsonValidator NF_SERVICE_DISCOVERY_LIST = createValidator("nf-service-discovery-list.json");
    public static JsonValidator NF_SERVICE_MANAGEMENT_LIST = createValidator("nf-service-management-list.json");
    public static JsonValidator NF_SERVICE_SUBSCRIPTION_LIST = createValidator("nf-service-subscription-list.json");
    public static JsonValidator PCF_INFO_LIST = createValidator("pcf-info-list.json");
    public static JsonValidator PCSCF_INFO_LIST = createValidator("pcscf-info-list.json");
    public static JsonValidator RECOVERY_TIME_LIST = createValidator("recovery-time-list.json");
    public static JsonValidator SCP_PORTS = createValidator("scp-ports.json");
    public static JsonValidator SMF_INFO_LIST = createValidator("smf-info-list.json");
    public static JsonValidator SUPPORTED_VENDOR_SPECIFIC_FEATURES = createValidator("supported-vendor-specific-features.json");
    public static JsonValidator UDM_INFO_LIST = createValidator("udm-info-list.json");
    public static JsonValidator UDR_INFO_LIST = createValidator("udr-info-list.json");
    public static JsonValidator UDSF_INFO_LIST = createValidator("udsf-info-list.json");
    public static JsonValidator UPF_INFO_LIST = createValidator("upf-info-list.json");
    
    public static JsonValidator createValidator(String path) {
        return JsonValidator.createValidator(get3gppExtensionsPath(path));
    }
    
    private ExtensionsValidators() {
        
    }
}
