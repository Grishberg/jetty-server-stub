package data.models;

import java.util.List;

/**
 * Created by g on 03.06.16.
 */
public class PageResponse {
    private List<DataModel> data;

    public PageResponse(List<DataModel> data) {
        this.data = data;
    }

}
