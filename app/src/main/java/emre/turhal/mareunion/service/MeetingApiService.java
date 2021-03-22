package emre.turhal.mareunion.service;

import java.util.List;

import emre.turhal.mareunion.model.Meeting;

public interface MeetingApiService {

    List<Meeting> getMeetings();

    void deleteMeeting (Meeting meeting);

    void createMeeting (Meeting meeting);

    List<Meeting> filterMeetings(String filter, String type);


}
