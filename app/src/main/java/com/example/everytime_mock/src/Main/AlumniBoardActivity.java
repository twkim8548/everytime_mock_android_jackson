package com.example.everytime_mock.src.Main;

import android.os.Bundle;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.Main.interfaces.AlumniBoardActivityView;
import com.example.everytime_mock.src.Main.interfaces.SecretBoardActivityView;


public class AlumniBoardActivity extends BaseActivity implements AlumniBoardActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumni_board);
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
