package emre.turhal.mareunion.model;

import java.util.List;

public class Meeting {


    private long id;

    private String date;

    private String hour;

    private String place;

    private String object;

    private String participant;

    private String participant2;





    public Meeting(long id, String date, String hour, String place, String object, String participant, String participant2) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.place = place;
        this.object = object;
        this.participant = participant;
        this.participant2 = participant2;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participants) {
        this.participant = participants;
    }

    public String getParticipant2() {
        return participant2;
    }

    public void setParticipant2(String participant2) {
        this.participant2 = participant2;
    }
}
