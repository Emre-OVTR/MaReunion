package emre.turhal.mareunion.Utils;

import android.content.Context;
import android.widget.Toast;


    public class ToastUtils {

        public static void showToastLong(String string, Context mContext) {
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(mContext, string, duration);
            toast.show();
        }

        public static void showToastShort(String string, Context mContext) {
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(mContext, string, duration);
            toast.show();
        }
    }

