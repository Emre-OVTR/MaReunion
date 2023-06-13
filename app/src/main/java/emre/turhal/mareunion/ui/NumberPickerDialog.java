package emre.turhal.mareunion.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.NumberPicker;

public class NumberPickerDialog extends DialogFragment {
    private NumberPicker.OnValueChangeListener valueChangeListener;
    public static String[] pickerVals = new String[] {"Salle A", "Salle B", "Salle C", "Salle D", "Salle E", "Salle F", "Salle G", "Salle H", "Salle I", "Salle J"};




    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        NumberPicker numberPicker = new NumberPicker(getActivity());

        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(9);

        numberPicker.setDisplayedValues(pickerVals);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Sélectionnez une salle:");

        builder.setPositiveButton("OK", (dialog, which) -> valueChangeListener.onValueChange(numberPicker,
                numberPicker.getValue(), numberPicker.getValue()));
        builder.setView(numberPicker);
        return builder.create();
    }


    public void setValueChangeListener(NumberPicker.OnValueChangeListener valueChangeListener) {
        this.valueChangeListener = valueChangeListener;

    }
}
