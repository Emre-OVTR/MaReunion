package emre.turhal.mareunion.Utils;

public class TimeUtils {

    public static String timePickerToString(int hour, int minute) {
        String hourformated;
        if (hour <= 9){
            hourformated = "0" + hour;
        }
        else hourformated = String.valueOf(hour);

        String minuteformated;
        if (minute<=9){
            minuteformated ="0" + minute;
        }
        else minuteformated = String.valueOf(minute);
        return hourformated + ":" + minuteformated;
    }
}
