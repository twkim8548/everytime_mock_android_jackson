package com.example.everytime_mock.src.boards.in_post.interfaces;

import com.example.everytime_mock.src.boards.in_post.models.CommentAddResponse;
import com.example.everytime_mock.src.boards.in_post.models.CommentResponse;
import com.example.everytime_mock.src.boards.models.common_board.CommonBoardResponse;
import com.example.everytime_mock.src.main.frag_home.models.RealTimeHotPostResponse;
import com.example.everytime_mock.src.main.frag_home.models.RecentLectureReviewResponse;

import org.w3c.dom.Comment;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface InPostRetrofitInterface {

    // 실시간 인기글 조회
    @GET("/popular-content")
    Call<RealTimeHotPostResponse> getRealTimeHotPost(@Header("x-access-token")String accessToken);

//    // HOT 게시물 조회
//    @GET("notice/contents?")
//    Call<BoardResponse> getHotPost(@Header("x-access-token")String accessToken);

    // HOT 게시물 게시판 조회
    @GET("/notice/contents?")
    Call<CommonBoardResponse> getHotBoard(
            @Header("x-access-token") String accessToken,
            @Query("choice") String choice);

    // 최근 강의평 조회
    @GET("/new-class-comment")
    Call<RecentLectureReviewResponse> getRecentLectureReview(@Header("x-access-token")String accessToken);

    // 자유게시판 게시글의 댓글 조회
    @GET("/notice/content/{contentIdx}/comments")
    Call<CommentResponse> getFreeComment(@Header("x-access-token") String accessToken,
                                         @Path("contentIdx") int contentIdx);

    // 비밀게시판 게시글의 댓글 조회
    @GET("/notice/content/{contentIdx}/comments")
    Call<CommentResponse> getSecretComment(@Header("x-access-token") String accessToken,
                                           @Path("contentIdx") int contentIdx);

    // 졸업생게시판 게시글의 댓글 조회
    @GET("/notice/content/{contentIdx}/comments")
    Call<CommentResponse> getAlumniComment(@Header("x-access-token") String accessToken,
                                           @Path("contentIdx") int contentIdx);

    // 신입생게시판 게시글의 댓글 조회
    @GET("/notice/content/{contentIdx}/comments")
    Call<CommentResponse> getFreshmenComment(@Header("x-access-token") String accessToken,
                                           @Path("contentIdx") int contentIdx);

    // 댓글 추가
    @POST("/notice/content/{contentIdx}/comment")
    Call<CommentAddResponse> postNewComment(@Header("x-access-token") String accessToken,
                                            @Path("contentIdx") int contentIdx,
                                            @Body HashMap<String, Object> params);


}
