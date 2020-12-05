package team.dotspace.radiobots4j.auth;

import kong.unirest.JsonObjectMapper;
import kong.unirest.json.JSONObject;

import java.util.Objects;

public class AuthCredentials {

    private final String privatekey;
    private final String token;

    private AuthCredentials(String KEY, String TOKEN) {
        this.privatekey = KEY;
        this.token = TOKEN;
    }

    public static AuthCredentials of(String key, String token) {
        return new AuthCredentials(key, token);
    }

    public static AuthCredentials fromEnv(String keyEnv, String tokenEnv) {
        return new AuthCredentials(System.getenv(keyEnv), System.getenv(tokenEnv));
    }

    public static AuthCredentials fromJson(JSONObject credentialsFile) {
        return new AuthCredentials(
                Objects.requireNonNull(credentialsFile.getString("key"), "Invalid JSONObject. Can not find 'key'"),
                Objects.requireNonNull(credentialsFile.getString("token"), "Invalid JSONObject. Can not find 'token'")
        );
    }

    public String getKey() {
        return privatekey;
    }

    public String getToken() {
        return token;
    }

    public String getAsHeader() {
        return new JsonObjectMapper().writeValue(this);
    }
}
