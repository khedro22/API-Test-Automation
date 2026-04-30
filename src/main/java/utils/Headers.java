package utils;
import java.util.HashMap;
import java.util.Map;

public class Headers {
    public static Map<String, String> getHeadersWithToken(String token){
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        headers.put("Content-Type", "application/json");
        return headers;
    }
}
