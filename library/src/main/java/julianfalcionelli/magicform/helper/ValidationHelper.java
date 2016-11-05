package julianfalcionelli.magicform.helper;

import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import julianfalcionelli.magicform.R;

public class ValidationHelper {
    public static final String TAG = ValidationHelper.class.getSimpleName();

    public static void wrapIfNeeded(View viewToWrap){

    }

    public static void cleanError(View view) {
        if (view instanceof EditText) {
            cleanError((EditText) view);
            return;
        }

        if (view instanceof TextView) {
            ((TextView) view).setError(null);
            return;
        }

    }

    private static void cleanError(EditText editText) {
        try {
            ((TextInputLayout) editText.getParent()).setError(null);
            ((TextInputLayout) editText.getParent()).setErrorEnabled(false);
        } catch (ClassCastException e) {
            editText.setError(null);
        }
    }

    public static void setError(View view, String error) {
        if (view instanceof EditText) {
            setError((EditText) view, error);
            return;
        }

        if (view instanceof TextView) {
            ((TextView) view).setError(error);
            return;
        }
    }

    private static void setError(EditText editText, String error) {
        try {
            TextInputLayout til = ((TextInputLayout) editText.getParent());
            til.setHintTextAppearance(R.style.TILInput);
            til.setErrorEnabled(true);
            til.setError(error);
        } catch (ClassCastException e) {
            editText.setError(error);
        }
    }
}
