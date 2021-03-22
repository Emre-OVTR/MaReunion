package emre.turhal.mareunion.model;

import java.util.List;

public class Meeting {


    private long id;

    private String date;

    private String hour;

    private String place;

    private String object;

    private String participant1;

    private String participant2;

    private String participant3;

    private String participant4;

    private List<String> particpants;


    public Meeting(long id, String date, String hour, String place, String object, String participant1,
                   String participant2, String participant3, String participant4) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.place = place;
        this.object = object;
        this.participant1 = participant1;
        this.participant2 = participant2;
        this.participant3 = participant3;
        this.participant4 = participant4;
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

    public String getParticipant1() {
        return participant1;
    }

    public void setParticipant1(String participant1) {
        this.participant1 = participant1;
    }

    public String getParticipant2() {
        return participant2;
    }

    public void setParticipant2(String participant2) {
        this.participant2 = participant2;
    }

    public String getParticipant3() {
        return participant3;
    }

    public void setParticipant3(String participant3) {
        this.participant3 = participant3;
    }

    public String getParticipant4() {
        return participant4;
    }

    public void setParticipant4(String participant4) {
        this.participant4 = participant4;
    }

}
