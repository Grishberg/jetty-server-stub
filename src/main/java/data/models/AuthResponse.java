package data.models;

/**
 * Created by g on 03.06.16.
 */
public class AuthResponse {
    private boolean success;
    private String accessToken;

    public AuthResponse(boolean success, String accessToken){
        this.success = success;
        this.accessToken = accessToken;
    }
}
