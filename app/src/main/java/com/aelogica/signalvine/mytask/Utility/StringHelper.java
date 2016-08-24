package com.aelogica.signalvine.mytask.Utility;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by user on 24/08/2016.
 */

public class StringHelper {

    private static final String HASH_ALGORITHM = "HmacSHA256";

    public static String encode(String data, String key) throws Exception {
        Mac sha256_HMAC = Mac.getInstance(HASH_ALGORITHM);
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), HASH_ALGORITHM);
        sha256_HMAC.init(secret_key);
        return toHexString(sha256_HMAC.doFinal(data.toLowerCase().getBytes("UTF-8")));
    }

    private static String toHexString(byte[] bytes) throws UnsupportedEncodingException {
        return Base64.encodeToString(bytes, Base64.URL_SAFE);
    }


}
