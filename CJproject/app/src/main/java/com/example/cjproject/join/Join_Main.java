package com.example.cjproject.join;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cjproject.R;
import com.example.cjproject.retrofit.RetrofitAPI;
import com.example.cjproject.retrofit.User_Request;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Join_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_main);
        EditText et_join_name = findViewById(R.id.et_join_name);
        EditText et_join_id = findViewById(R.id.et_join_id);
        EditText et_join_pw = findViewById(R.id.et_join_pw);
        EditText et_join_phonenum = findViewById(R.id.et_join_phonenum);
        Button button = findViewById(R.id.btn_next1);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Join_account.class);

                String user_name = et_join_name.getText().toString();
                String user_id = et_join_id.getText().toString();
                String user_pw = et_join_pw.getText().toString();
                String user_phonenum = et_join_phonenum.getText().toString();
                Log.i("text",user_id);
                intent.putExtra("USER_NAME",user_name);
                intent.putExtra("USER_ID", user_id);
                intent.putExtra("USER_PW", user_pw);
                intent.putExtra("USER_PHONENUM", user_phonenum);
                Log.i("text2",user_id);
                startActivity(intent);
            }
        });
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.254.2.21:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private void registerUser(User_Request data) {
        RetrofitAPI serviceApi = retrofit.create(RetrofitAPI.class);
        serviceApi.registerUser(data).enqueue(new Callback<User_Request>() {
            @Override
            public void onResponse(Call<User_Request> call, Response<User_Request> response) {
                User_Request request = response.body();
                Log.i("success", String.valueOf(data));
                //서버로부터의 응답을 위에서 정의한 JoinResponse객체에 담는다.
                // getMessage를 통해 성공시 서버로부터 회원가입 성공이라는 메시지를 받음
            }
            @Override
            public void onFailure(Call<User_Request> call, Throwable t) {
                Log.e("get user up Error", t.getMessage());
                t.printStackTrace();
            }
        });
    }
}