package com.example.everytime_mock.src.Boards.interfaces;

import com.example.everytime_mock.src.Boards.models.FreeBoardResponse;

public interface FreeBoardActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void freeBoardSuccess(FreeBoardResponse freeBoardResponse);
}