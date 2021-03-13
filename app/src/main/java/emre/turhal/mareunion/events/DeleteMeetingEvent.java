package emre.turhal.mareunion.events;

import emre.turhal.mareunion.model.Meeting;

public class DeleteMeetingEvent {

    public Meeting meeting;

    public DeleteMeetingEvent(Meeting meeting){
        this.meeting = meeting;
    }
}
