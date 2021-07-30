package com.mycompany.vertxschematester;

import static com.mycompany.vertxschematester.Constants.get3gppPath;

public class Ts3gppValidators {
    public static JsonValidator ACCESS_TOKEN_CLAIMS = createValidator("access-token-claims.json");
    public static JsonValidator ACCESS_TOKEN_ERR = createValidator("access-token-err.json");
    public static JsonValidator ACCESS_TOKEN_REQ = createValidator("access-token-req.json");
    public static JsonValidator ACCESS_TOKEN_RSP = createValidator("access-token-rsp.json");
    public static JsonValidator AF_EVENT_EXPOSURE_DATA = createValidator("af-event-exposure-data.json");
    public static JsonValidator ALLOWED_NSSAI = createValidator("allowed-nssai.json");
    public static JsonValidator ALLOWED_SNSSAI = createValidator("allowed-snssai.json");
    public static JsonValidator AMF_COND = createValidator("amf-cond.json");
    public static JsonValidator AMF_INFO = createValidator("amf-info.json");
    public static JsonValidator ATSSS_CAPABILITY = createValidator("atsss-capability.json");
    public static JsonValidator AUDIENCE = createValidator("audience.json");
    public static JsonValidator AUSF_INFO = createValidator("ausf-info.json");
    public static JsonValidator AUTHORIZED_NETWORK_SLICE_INFO = createValidator("authorized-network-slice-info.json");
    public static JsonValidator BINDING_RESP = createValidator("binding-resp.json");
    public static JsonValidator BSF_INFO = createValidator("bsf-info.json");
    public static JsonValidator CHANGE_ITEM = createValidator("change-item.json");
    public static JsonValidator CHF_INFO = createValidator("chf-info.json");
    public static JsonValidator CONFIGURED_SNSSAI = createValidator("configured-snssai.json");
    public static JsonValidator DEFAULT_NOTIFICATION_SUBSCRIPTION = createValidator("default-notification-subscription.json");
    public static JsonValidator DNN_SMF_INFO_ITEM = createValidator("dnn-smf-info-item.json");
    public static JsonValidator DNN_UPF_INFO_ITEM = createValidator("dnn-upf-info-item.json");
    public static JsonValidator GMLC_INFO = createValidator("gmlc-info.json");
    public static JsonValidator GUAMI_LIST_COND = createValidator("guami-list-cond.json");
    public static JsonValidator GUAMI = createValidator("guami.json");
    public static JsonValidator HSS_INFO = createValidator("hss-info.json");
    public static JsonValidator IDENTITY_RANGE = createValidator("identity-range.json");
    public static JsonValidator IMSI_RANGE = createValidator("imsi-range.json");
    public static JsonValidator INTERFACE_UPF_INFO_ITEM = createValidator("interface-upf-info-item.json");
    public static JsonValidator INTERNAL_GROUP_ID_RANGE = createValidator("internal-group-id-range.json");
    public static JsonValidator INVALID_PARAM = createValidator("invalid-param.json");
    public static JsonValidator IP_ENDPOINT = createValidator("ip-end-point.json");
    public static JsonValidator IPV4_ADDRESS_RANGE = createValidator("ipv4-address-range.json");
    public static JsonValidator IPV6_PREFIX_RANGE = createValidator("ipv6-prefix-range.json");
    public static JsonValidator LINK = createValidator("link.json");
    public static JsonValidator LMF_INFO = createValidator("lmf-info.json");
    public static JsonValidator MAPPING_OF_SNSSAI = createValidator("mapping-of-snssai.json");
    public static JsonValidator N2_INTERFACE_AMF_INFO = createValidator("n2-interface-amf-info.json");
    public static JsonValidator NEF_COND = createValidator("nef-cond.json");
    public static JsonValidator NEF_INFO = createValidator("nef-info.json");
    public static JsonValidator NETWORK_SLICE_COND = createValidator("network-slice-cond.json");
    public static JsonValidator NF_GROUP_COND = createValidator("nf-group-cond.json");
    public static JsonValidator NF_INFO = createValidator("nf-info.json");
    public static JsonValidator NF_INSTANCE_ID_COND = createValidator("nf-instance-id-cond.json");
    public static JsonValidator NF_INSTANCE_ID_LIST_COND = createValidator("nf-instance-id-list-cond.json");
    public static JsonValidator NF_PROFILE_DISCOVERY = createValidator("nf-profile-discovery.json");
    public static JsonValidator NF_PROFILE_MANAGEMENT = createValidator("nf-profile-management.json");
    public static JsonValidator NF_PROFILE_SUBSCRIPTION = createValidator("nf-profile-subscription.json");
    public static JsonValidator NF_SERVICE_DISCOVERY = createValidator("nf-service-discovery.json");
    public static JsonValidator NF_SERVICE_MANAGEMENT = createValidator("nf-service-management.json");
    public static JsonValidator NF_SERVICE_SET_COND = createValidator("nf-service-set-cond.json");
    public static JsonValidator NF_SERVICE_SUBSCRIPTION = createValidator("nf-service-subscription.json");
    public static JsonValidator NF_SERVICE_VERSION = createValidator("nf-service-version.json");
    public static JsonValidator NF_SET_COND = createValidator("nf-set-cond.json");
    public static JsonValidator NF_TYPE_COND = createValidator("nf-type-cond.json");
    public static JsonValidator NOTIF_CONDITION = createValidator("notif-condition.json");
    public static JsonValidator NOTIFICATION_DATA = createValidator("notification-data.json");
    public static JsonValidator NRF_INFO = createValidator("nrf-info.json");
    public static JsonValidator NSI_INFORMATION = createValidator("nsi-information.json");
    public static JsonValidator NWDAF_COND = createValidator("nwdaf-cond.json");
    public static JsonValidator NWDAF_INFO = createValidator("nwdaf-info.json");
    public static JsonValidator PARAMETER_COMBINATION = createValidator("parameter-combination.json");
    public static JsonValidator PATCH_DATA = createValidator("patch-data.json");
    public static JsonValidator PCF_BINDING_PATCH = createValidator("pcf-binding-patch.json");
    public static JsonValidator PCF_BINDING = createValidator("pcf-binding.json");
    public static JsonValidator PCF_INFO = createValidator("pcf-info.json");
    public static JsonValidator PCSCF_INFO = createValidator("pcscf-info.json");
    public static JsonValidator PFD_DATA = createValidator("pfd-data.json");
    public static JsonValidator PLMN_ID_NID = createValidator("plmn-id-nid.json");
    public static JsonValidator PLMN_ID = createValidator("plmn-id.json");
    public static JsonValidator PLMN_RANGE = createValidator("plmn-range.json");
    public static JsonValidator PLMN_SNSSAI = createValidator("plmn-snssai.json");
    public static JsonValidator PREFERRED_SEARCH = createValidator("preferred-search.json");
    public static JsonValidator PROBLEM_DETAILS = createValidator("problem-details.json");
    public static JsonValidator SCP_DOMAIN_COND = createValidator("scp-domain-cond.json");
    public static JsonValidator SCP_DOMAIN_INFO = createValidator("scp-domain-info.json");
    public static JsonValidator SCP_INFO = createValidator("scp-info.json");
    public static JsonValidator SD_RANGE = createValidator("sd-range.json");
    public static JsonValidator SEARCH_RESULT = createValidator("search-result.json");
    public static JsonValidator SEC_NEGOTIATE_REQ_DATA = createValidator("sec-negotiate-req-data.json");
    public static JsonValidator SEC_NEGOTIATE_RSP_DATA = createValidator("sec-negotiate-rsp-data.json");
    public static JsonValidator SERVICE_NAME_COND = createValidator("service-name-cond.json");
    public static JsonValidator SLICE_INFO_FOR_PDU_SESSION = createValidator("slice-info-for-pdu-session.json");
    public static JsonValidator SLICE_INFO_FOR_REGISTRATION = createValidator("slice-info-for-registration.json");
    public static JsonValidator SLICE_INFO_FOR_UE_CONFIGURATION_UPDATE = createValidator("slice-info-for-ue-configuration-update.json");
    public static JsonValidator SMF_INFO = createValidator("smf-info.json");
    public static JsonValidator SNSSAI_EXTENSION = createValidator("snssai-extension.json");
    public static JsonValidator SNSSAI_SMF_INFO_ITEM = createValidator("snssai-smf-info-item.json");
    public static JsonValidator SNSSAI_UPF_INFO_ITEM = createValidator("snssai-upf-info-item.json");
    public static JsonValidator SNSSAI = createValidator("snssai.json");
    public static JsonValidator SUBSCRIBED_SNSSAI = createValidator("subscribed-snssai.json");
    public static JsonValidator SUBSCRIPTION_DATA = createValidator("subscription-data.json");
    public static JsonValidator SUPI_RANGE = createValidator("supi-range.json");
    public static JsonValidator TAC_RANGE = createValidator("tac-range.json");
    public static JsonValidator TAI_RANGE = createValidator("tai-range.json");
    public static JsonValidator TAI = createValidator("tai.json");
    public static JsonValidator TNGF_INFO = createValidator("tngf-info.json");
    public static JsonValidator TWIF_INFO = createValidator("twif-info.json");
    public static JsonValidator UDM_INFO = createValidator("udm-info.json");
    public static JsonValidator UDR_INFO = createValidator("udr-info.json");
    public static JsonValidator UDSF_INFO = createValidator("udsf-info.json");
    public static JsonValidator UPF_COND = createValidator("upf-cond.json");
    public static JsonValidator UPF_INFO = createValidator("upf-info.json");
    public static JsonValidator URI_LIST = createValidator("uri-list.json");
    public static JsonValidator VENDOR_SPECIFIC_FEATURE = createValidator("vendor-specific-feature.json");
    public static JsonValidator WAGF_INFO = createValidator("wagf-info.json");
    
    public static JsonValidator createValidator(String path) {
        return JsonValidator.createValidator(get3gppPath(path));
    }
    
    private Ts3gppValidators() {
        
    }
}
