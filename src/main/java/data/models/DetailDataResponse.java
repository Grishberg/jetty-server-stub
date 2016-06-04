package data.models;

/**
 * Created by grishberg on 04.06.16.
 */
public class DetailDataResponse {
    private int id;
    private String name;
    private String imageUrl;

    public DetailDataResponse(int id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }
}
