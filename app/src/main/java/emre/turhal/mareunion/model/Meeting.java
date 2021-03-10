package emre.turhal.mareunion.model;

public class Meeting {


    private long id;

    private String hour;

    private String place;

    private String object;


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
