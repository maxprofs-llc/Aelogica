package com.aelogica.signalvine.mytask.request;

import android.util.Log;

import com.aelogica.signalvine.mytask.Utility.DateHelper;
import com.aelogica.signalvine.mytask.Utility.StringHelper;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 24/08/2016.
 */

public class HandshakeRequest extends JsonObjectRequest {

    private static String TAG = "Logger";


    private static String BASE_URL = "https://theseus-api-integrations.signalvine.com";
    private static String ENDPOINT = "/v1/users/%s/accounts";

    private final String mEndPoint;
    private final String mToken;
    private final String mSecret;

    public HandshakeRequest(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener, String token, String secret) {
        super(Method.GET, BASE_URL + String.format(ENDPOINT, token), null, listener, errorListener);
        mToken = token;
        mSecret = secret;
        mEndPoint = String.format(ENDPOINT, token);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        HashMap<String, String> headers = new HashMap<>();
        try {
            String timestamp = DateHelper.getTimeStamp();
            StringBuilder sb = new StringBuilder();
            sb.append(mToken + "\n");
            sb.append("get\n");
            sb.append(mEndPoint + "\n");
            sb.append("\n");
            sb.append(timestamp);

            String unsignedData = sb.toString().toLowerCase();
            String signedData = StringHelper.encode(unsignedData, mSecret);

            headers.put("Authorization", "SignalVine " + mToken + ":" + signedData);
            headers.put("SignalVine-Date", timestamp);
            headers.put("Content-Type", "application/json");

            Log.d(TAG, "Authorization: " +  headers.get("Authorization"));
            Log.d(TAG, "SignalVine-Date: " +  headers.get("SignalVine-Date"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return headers;
    }
}
