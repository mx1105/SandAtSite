package com.mn.CONSTRUCTION.Activity;;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.mn.CONSTRUCTION.R;
import com.mn.CONSTRUCTION.utils.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.edit_username)
    TextInputEditText edit_username;

    @BindView(R.id.edit_password)
    TextInputEditText edit_password;

    @BindView(R.id.btn_login)
    MaterialButton btn_login;

    @BindView(R.id.tv_signup)
    TextView tv_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_signup,R.id.btn_login})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_signup:{
                startActivity(new Intent(this, SignUpActivity.class));
            }break;
            case R.id.btn_login:{
                startActivity(new Intent(this, HomeActivity.class));
            }break;
        }
    }

}