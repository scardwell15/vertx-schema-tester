package com.mycompany.vertxschematester;

public class Constants {
    public static final Boolean TRACE = false;
    private static final String SCHEMA = "schema";
    private static final String NN = "nn";
    private static final String TS3GPP = "ts3gpp";

    public static String getNnDefaultsPath(String fileName) {
        return String.format("%s/%s/%s/%s", SCHEMA, NN, "defaults", fileName);
    }

    public static String getNnNfcaPath(String fileName) {
        return String.format("%s/%s/%s/%s", SCHEMA, NN, "nfca", fileName);
    }
    
    public static String getNnNrfPath(String fileName) {
        return String.format("%s/%s/%s/%s", SCHEMA, NN, "nrf", fileName);
    }
    
    public static String get3gppPath(String fileName) {
        return String.format("%s/%s/%s", SCHEMA, TS3GPP, fileName);
    }

    public static String get3gppEnumsPath(String fileName) {
        return String.format("%s/%s/%s/%s", SCHEMA, TS3GPP, "enums", fileName);
    }

    public static String get3gppExtensionsPath(String fileName) {
        return String.format("%s/%s/%s/%s", SCHEMA, TS3GPP, "extensions", fileName);
    }

    public static final String FQDN = "www.netnumber.com";
    public static final String IPV4_1 = "1.1.1.1";
    public static final String IPV4_2 = "2.2.2.2";
    public static final String IPV6_1 = "1000:0db8:85a3:0000:0000:8a2e:0370:7334";
    public static final String IPV6_2 = "2000:0db8:85a3:0000:0000:8a2e:0370:7334";
    public static final String IPV6_PREFIX_1 = "1000:db8:abcd:12::0/64";
    public static final String IPV6_PREFIX_2 = "2000:db8:abcd:12::0/64";
    public static final String ADDITIONAL_PROPERTIES = "additionalProperties";

}
