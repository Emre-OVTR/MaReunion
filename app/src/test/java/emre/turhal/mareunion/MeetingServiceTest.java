package emre.turhal.mareunion;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import emre.turhal.mareunion.di.DI;
import emre.turhal.mareunion.model.Meeting;
import emre.turhal.mareunion.service.DummyMeetingGenerator;
import emre.turhal.mareunion.service.MeetingApiService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(JUnit4.class)
public class MeetingServiceTest {

    private MeetingApiService service;


    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getMeetings(){

        List<Meeting> meetings= service.getMeetings();
        List<Meeting> expectedMeetings = DummyMeetingGenerator.DUMMY_MEETINGS;
        assertThat(meetings, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedMeetings.toArray()));
    }

    @Test
    public void deleteMeeting(){

        Meeting meetingToDelete = service.getMeetings().get(0);
        service.deleteMeeting(meetingToDelete);
        assertFalse(service.getMeetings().contains(meetingToDelete));
    }

    @Test
    public void addMeeting() {
        Meeting meetingToAdded = new Meeting(7, "12:00","25/04/2021", "Salle F",
                "TEST", DummyMeetingGenerator.participants);
        service.createMeeting(meetingToAdded);
        assertTrue(service.getMeetings().contains(meetingToAdded));
    }


    @Test
    public void filterMeetingsByPlace() {
        String expectedMeetings = service.getMeetings().get(2).getRoom();
        assertEquals(service.filterMeetingsByPlace("Salle H").get(0).getRoom(), expectedMeetings);
    }


    @Test
    public void filterMeetingsByDate(){
        String expectedMeetings = service.getMeetings().get(1).getTime();
        assertEquals(service.filterMeetingsByDate("14/05/2021").get(0).getTime(), expectedMeetings);
    }


}