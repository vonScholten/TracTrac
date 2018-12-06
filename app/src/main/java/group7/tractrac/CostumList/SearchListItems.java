package group7.tractrac.CostumList;

import java.util.Comparator;

public class SearchListItems  {

    public int imageView;
    public String eventName;
    public String event;

    public void setImageView(int imageView) {
        this.imageView = imageView;

    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public SearchListItems (int imageView, String eventName, String event) {
        this.imageView = imageView;
        this.eventName = eventName;
        this.event = event;

    }

    /*
    * Crap.....
    * */

    public static Comparator<SearchListItems> COMPARE_BY_EVENT = new Comparator<SearchListItems>() {
        @Override
        public int compare(SearchListItems one, SearchListItems other) {
            return one.event.compareTo(other.event);
        }
    };

    public static Comparator<SearchListItems> COMPARE_BY_NAME = new Comparator<SearchListItems>() {
        @Override
        public int compare(SearchListItems one, SearchListItems other) {
            return one.eventName.compareTo(other.eventName);
        }
    };
}
