package com.bawei.day_02.ui.user;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.day_02.R;
import com.bawei.day_02.mvp.user.UserContract;
import com.bawei.day_02.mvp.user.UserPresentImpl;
import com.bawei.day_02.ui.user.Main2Activity;

public class MainActivity extends AppCompatActivity implements UserContract.IUserView {

    private EditText ephone;
    private EditText epwd;
    private TextView login;
    private Button reigst;
    private UserPresentImpl userPresent;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ephone = findViewById(R.id.ephone);
        epwd = findViewById(R.id.epwd);
        login = findViewById(R.id.reigst);
        reigst = findViewById(R.id.login);
        //
        sp = getSharedPreferences("what", MODE_PRIVATE);
        //实例化
        userPresent = new UserPresentImpl();
        userPresent.attach(this);
        reigst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPresent.login(ephone.getText().toString(), epwd.getText().toString());
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPresent.regist(ephone.getText().toString(), epwd.getText().toString());

            }
        });
    }

    @Override
    public void onRegistSuccess(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        //记住
        String phone = sp.getString("phone", "");
        if (TextUtils.isEmpty(phone)) {
            sp.edit().putString("phone", ephone.getText().toString()).commit();
        }
        startActivity(new Intent(this, Main2Activity.class));
    }
}
