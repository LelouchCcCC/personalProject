package com.example.demo.utils;

import java.util.HashMap;
import java.util.Map;

public class ApiResponseCodeUtils {
    // success
    public static final int SUCCESS = 20000;

    // Error codes
    public static final int USER_AUTHENTICATION_FAILURE  = 20001;
    public static final int RESOURCE_NOT_FOUND = 20002;
    public static final int DATA_VALIDATION_ERROR = 20003;
    public static final int ACCESS_FORBIDDEN = 20004;
    public static final int SERVER_ERROR = 20005;
    public static final int RATE_LIMITED_EXCEEDED = 20006;
    public static final int ERROR_IN_BUSINESS_LOGIC = 20006;
    // ... add more error codes as needed

    // Utility method to generate a standard response
    public static Map<String, Object> generateResponse(int code, String message, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", code);
        response.put("message", message);
        response.put("data", data);
        return response;
    }
}
