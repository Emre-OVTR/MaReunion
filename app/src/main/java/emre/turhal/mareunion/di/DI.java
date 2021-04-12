package emre.turhal.mareunion.di;

import emre.turhal.mareunion.service.DummyMeetingApiService;
import emre.turhal.mareunion.service.MeetingApiService;

public class DI {


    private static final MeetingApiService service = new DummyMeetingApiService();


    public static MeetingApiService getMeetingApiService() {
        return service;
    }


    public static MeetingApiService getNewInstanceApiService() {
        return new DummyMeetingApiService();
    }
}
