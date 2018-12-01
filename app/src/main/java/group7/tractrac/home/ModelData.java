package group7.tractrac.home;

public class ModelData {
    private String mName;
    private String mImageUrl;

    public ModelData(){}

    public ModelData(String name, String imageUrl) {
        if(name.trim().equals("")){
            name = "No name";
        }

        this.mName = name;
        this.mImageUrl = imageUrl;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
