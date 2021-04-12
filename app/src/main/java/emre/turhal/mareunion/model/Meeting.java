package emre.turhal.mareunion.model;

import java.util.List;


public class Meeting {


    private long id;

    private final String hour;

    private final String place;

    private final String object;

    private final List<String> participants;




    public Meeting(long id, String hour, String place, String object, List<String> participants) {
        this.id = id;
        this.hour = hour;
        this.place = place;
        this.object = object;
        this.participants = participants;
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

    public String getPlace() {
        return place;
    }

    public String getObject() {
        return object;
    }

    public List<String> getParticipants() {
        return participants;
    }


}












