package data.models;

/**
 * Created by grishberg on 04.06.16.
 */
public class BaseResponse {
    public static final int INVALID_ACCESS_TOKEN = -1;
    private Integer errorCode;

    public BaseResponse(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
