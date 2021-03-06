package com.example.inq_proj.login;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    final static private String URL = "https://1af1-115-143-100-251.ngrok.io/members/join";
    private Map<String, String> map;

    public RegisterRequest(String loginId, String pw, String name, String position, String skills, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("loginId", loginId);
        map.put("pw", pw);
        map.put("name", name);
        map.put("position", position);
        map.put("skills", skills);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }

}
