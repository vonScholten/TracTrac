package group7.tractrac;

public class EventsData {
    private String title = "";
    private String imageUrl = "";
    private String category = "";
    private String date = "";
    private String races = "";
    private String participants = "";


    public EventsData(){}

    public EventsData(String title, String imageUrl, String category, String date, String races, String participants) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.category = category;
        this.date = date;
        this.races = races;
        this.participants = participants;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getRaces() {
        return races;
    }
    public void setRaces(String races) {
        this.races = races;
    }

    public String getCategory() { return category; }
    public void setCategory(String category) {
        this.category = category;
    }


    public String getParticipants() {
        return participants;
    }
    public void setParticipants(String participants) {
        this.participants = participants;
    }
}
