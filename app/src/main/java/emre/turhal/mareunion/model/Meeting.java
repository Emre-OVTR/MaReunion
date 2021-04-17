package emre.turhal.mareunion.model;

import java.util.List;


public class Meeting {


    private long id;

    private final String time;

    private final String room;

    private final String subject;

    private final List<String> participants;




    public Meeting(long id, String time, String room, String subject, List<String> participants) {
        this.id = id;
        this.time = time;
        this.room = room;
        this.subject = subject;
        this.participants = participants;
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public String getRoom() {
        return room;
    }

    public String getSubject() {
        return subject;
    }

    public List<String> getParticipants() {
        return participants;
    }


}












