package data.models;

import java.util.List;

/**
 * Created by g on 03.06.16.
 */
public class PageResponse {
    public static final int INVALID_ACCESS_TOKEN = -1;
    private Integer errorCode;
    private List<DataModel> data;

    public PageResponse(List<DataModel> data) {
        this.data = data;
    }

    public PageResponse(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
