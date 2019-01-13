package group7.tractrac;

public class ClubsData {
    String name;
    String url;
    String country;
    String sport;

    public ClubsData() {
    }


    public ClubsData(String name, String url, String country, String sport) {
        this.name = name;
        this.url = url;
        this.country = country;
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}
