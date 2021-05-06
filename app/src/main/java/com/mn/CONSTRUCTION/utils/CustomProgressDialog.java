package com.mn.CONSTRUCTION.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;

import com.mn.CONSTRUCTION.R;


public class CustomProgressDialog {

    //TODO : VAriable Declaration
    public Context context;
    ImageView iv1;
    public Dialog dialogView;
    public static CustomProgressDialog customProgressDialog;
    AnimationDrawable Anim;



    public void showCustomDialog(Context context) {

        dialogView = new Dialog(context);
        dialogView.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogView.setContentView(R.layout.layout_progress_dialog);
        dialogView.setCancelable(false);
//        dialogView.setTitle("HHH");

        iv1 = (ImageView) dialogView.findViewById(R.id.iv1);
        dialogView.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogView.setCancelable(false);
        dialogView.show();
    }

    public Boolean isShowing() {

        try {
            if (dialogView.isShowing()) {
                return true;
            }
        } catch (Exception e) {
            Log.e("Exception is ", e.getMessage());
            return false;
        }
        return false;
    }


    //TODO : Dissmiss Dialog
    public void dissmissDialog() {
        try {
            if (dialogView.isShowing()) {
                dialogView.dismiss();
            }
        } catch (Exception e) {
            Log.e("Exception is ", e.getMessage());
        }
    }
}
