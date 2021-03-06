package emre.turhal.mareunion.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import emre.turhal.mareunion.model.Meeting;

public abstract class DummyMeetingGenerator {

    public static List<String> participants = Arrays.asList(
            "merkel@president.de, macron@president.fr, elizabeth@queen.en , carlos@roi.es");

    public static List<String> participants02 = Arrays.asList(
            "elonMusk04@paypal.com", "zuckerberg@facebook.com", "jeffbezos@amazon.com", "billgates@google.com");

    public static List<String> participants03 =  Arrays.asList(
            "jayz@tidal.com", "bieber@youtube.com", "drake@views.com", "cardib@redbottoms.com"
    );

    public static List<Meeting> DUMMY_MEETINGS = Arrays.asList(
            new Meeting(1, "14:00", "11/05/2021", "Salle D", "Crise sanitaire", participants),
            new Meeting(2,"15:00", "14/05/2021", "Salle A", "Cryptomonnaie", participants02),
            new Meeting(3,"17:30", "17/05/2021","Salle H","Album commun", participants03));

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETINGS);
    }
}
