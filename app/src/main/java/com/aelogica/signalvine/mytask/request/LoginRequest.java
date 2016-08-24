package com.aelogica.signalvine.mytask.request;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Created by user on 24/08/2016.
 */

public class LoginRequest extends JsonObjectRequest {

    private static String URL = "https://v3-integrations.signalvine.com/auth/app_login";

    public LoginRequest(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener, String username, String password) {
        super(Method.POST, String.format("%s?username=%s&password=%s", URL, username, password), null, listener, errorListener);
    }
}
