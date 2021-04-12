package emre.turhal.mareunion.service;

import java.util.List;

import emre.turhal.mareunion.model.Meeting;

public interface MeetingApiService {

    List<Meeting> getMeetings();
    List<Meeting> filterMeetingsByTime (String time);
    List<Meeting> filterMeetingsByPlace (String place);



    void deleteMeeting (Meeting meeting);

    void createMeeting (Meeting meeting);






}
