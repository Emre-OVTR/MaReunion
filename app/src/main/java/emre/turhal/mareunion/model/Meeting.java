package emre.turhal.mareunion.model;

import java.util.ArrayList;
import java.util.List;

public class Meeting {


    private long id;

    private String hour;

    private String place;

    private String object;

    //private List<String> participants = new ArrayList<>();


    public Meeting(long id, String hour, String place, String object) {
        this.id = id;
        this.hour = hour;
        this.place = place;
        this.object = object;


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }


}
