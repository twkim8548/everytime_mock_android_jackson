package com.example.everytime_mock.src.Main.frag_board;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.everytime_mock.R;

public class FragBoardAll extends Fragment {

    private View view;

    public static FragBoard newInstance() {
        FragBoard fragBoard = new FragBoard();
        return fragBoard;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_board, container, false);

        return view;
    }
}