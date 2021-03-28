package emre.turhal.mareunion.controller;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.NumberPicker;

public class NumberPickerDialog extends DialogFragment {
    private NumberPicker.OnValueChangeListener valueChangeListener;
    public static String[] pickerVals = new String[] {"Salle A", "Salle B", "Sale C", "Salle D", "Salle E", "Salle F", "Salle G", "Salle H", "Salle I", "Salle J"};




    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        NumberPicker numberPicker = new NumberPicker(getActivity());

        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(9);

        numberPicker.setDisplayedValues(pickerVals);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose Room");
        builder.setMessage("Choose a number :");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                valueChangeListener.onValueChange(numberPicker,
                        numberPicker.getValue(), numberPicker.getValue());

            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                valueChangeListener.onValueChange(numberPicker,
                        numberPicker.getValue(), numberPicker.getValue());
            }
        });

        builder.setView(numberPicker);
        return builder.create();
    }

    public NumberPicker.OnValueChangeListener getValueChangeListener() {
        return valueChangeListener;
    }

    public void setValueChangeListener(NumberPicker.OnValueChangeListener valueChangeListener) {
        this.valueChangeListener = valueChangeListener;

    }
}
