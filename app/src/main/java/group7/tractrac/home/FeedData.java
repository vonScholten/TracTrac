package group7.tractrac.home;

public class FeedData {
    private String name;
    private String imageUrl;
    private String timestap;

    public FeedData(){}

    public FeedData(String name, String imageUrl, String data) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.timestap = timestap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTimestap() {
        return timestap;
    }

    public void setTimestap(String timestap) {
        this.timestap = timestap;
    }
}
