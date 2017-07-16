package edu.gsu.httpcs.finalproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpcs.finalproject.R;

/**
 * Created by supark on 7/15/17.
 */

public class CustomeDialog2 extends Dialog {
    private final ICustomDialogListener listener;

    public interface ICustomDialogListener {
        public void onCancelClicked(Dialog dialog);
    }

    @OnClick(R.id.activity_dialog_okay)
    public void ok (View view) {
        listener.onCancelClicked(this);
    }

    public CustomeDialog2(@NonNull Context context, ICustomDialogListener listener) {
        super(context, R.style.dialog);
        setContentView(R.layout.see_recipe_salad);
        ButterKnife.bind(this);
        this.listener = listener;
    }
}
