package com.example.everytime_mock.src.boards.models.recent_lecture_review_board;

public class RecentLectureReviewBoardResult {

    int classCommentIdx;
    String className;
    String professor;
    String classCommentInf;
    String classStudent;
    double classStar;
    int classCommentLike;

    public RecentLectureReviewBoardResult(int classCommentIdx, String className, String professor, String classCommentInf, String classStudent, double classStar, int classCommentLike) {
        this.classCommentIdx = classCommentIdx;
        this.className = className;
        this.professor = professor;
        this.classCommentInf = classCommentInf;
        this.classStudent = classStudent;
        this.classStar = classStar;
        this.classCommentLike = classCommentLike;
    }

    public int getClassCommentIdx() {
        return classCommentIdx;
    }

    public String getClassName() {
        return className;
    }

    public String getProfessor() {
        return professor;
    }

    public String getClassCommentInf() {
        return classCommentInf;
    }

    public String getClassStudent() {
        return classStudent;
    }

    public double getClassStar() {
        return classStar;
    }

    public int getClassCommentLike() {
        return classCommentLike;
    }
}
