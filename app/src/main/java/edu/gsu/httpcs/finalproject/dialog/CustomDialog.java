package edu.gsu.httpcs.finalproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpcs.finalproject.MainActivity;
import edu.gsu.httpcs.finalproject.R;
import edu.gsu.httpcs.finalproject.secondActivity;

import static edu.gsu.httpcs.finalproject.R.id.dialog_layout_btn;
import static edu.gsu.httpcs.finalproject.R.layout.dialog_layout;

/**
 * Created by supark on 7/12/17.
 */

public class CustomDialog extends Dialog {


private final ICustomDialogListener listener;

    public interface ICustomDialogListener {
        public void onCancelClicked(Dialog dialog);
    }

    @OnClick(R.id.activity_dialog_okay)
    public void ok (View view) {
        listener.onCancelClicked(this);
    }

    public CustomDialog(@NonNull Context context, ICustomDialogListener listener) {
        super(context, R.style.dialog);
        setContentView(R.layout.see_recipe_dialog);
        ButterKnife.bind(this);
        this.listener = listener;
    }

}
