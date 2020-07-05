package com.example.everytime_mock.src.Main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.Main.interfaces.MyPageActivityView;
import com.example.everytime_mock.src.Main.models.MyPageResponse;

import java.util.HashMap;

import static com.example.everytime_mock.src.ApplicationClass.sSharedPreferences;


public class MyPageActivity extends BaseActivity implements MyPageActivityView {

    TextView tv_my_page_user_nickname;
    TextView tv_my_page_user_id;
    TextView tv_my_page_univ_name;
    TextView tv_my_page_univ_year;

    TextView tv_my_page_change_nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        tv_my_page_user_nickname = findViewById(R.id.tv_my_page_user_nickname);
        tv_my_page_user_id = findViewById(R.id.tv_my_page_user_id);
        tv_my_page_univ_name = findViewById(R.id.et_signup2_univName);
        tv_my_page_univ_year = findViewById(R.id.et_signup2_univYear);

        tv_my_page_change_nickname = findViewById(R.id.tv_my_page_change_nickname);

        tryGetMyPage();
    }

    private void tryGetMyPage() {
        showProgressDialog();

        final MyPageService myPageService = new MyPageService(this);
        myPageService.getMyPage();
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void myPageSuccess(MyPageResponse myPageResponse) {
        hideProgressDialog();

        switch (myPageResponse.getCode()){
            case 100:
                tv_my_page_user_nickname.setText(myPageResponse.getMyPageResult().getUserNickname());
                tv_my_page_user_id.setText(myPageResponse.getMyPageResult().getUserID());
                tv_my_page_univ_name.setText(myPageResponse.getMyPageResult().getUnivName());
                tv_my_page_univ_year.setText(myPageResponse.getMyPageResult().getUnivYear());
                break;
            default:
                System.out.println(myPageResponse.getCode());
                System.out.println(myPageResponse.getMessage());
                break;
        }
    }

    public void customOnClick(View view) {
        switch (view.getId()){
            case R.id.tv_my_page_change_nickname:
                AlertDialog.Builder builder = new AlertDialog.Builder(MyPageActivity.this);
                builder.setTitle("닉네임 변경").setCancelable(true);

                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // todo
                        // 닉네임 변경 API를 통해 닉네임 바꿔주기
                    }
                }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.create().show();
                break;

        }
    }


}
