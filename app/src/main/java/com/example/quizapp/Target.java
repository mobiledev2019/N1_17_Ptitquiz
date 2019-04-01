package com.example.quizapp;

public class Target {
    private String date;
    private String lesson;
    private int soccer;
    private final int imageResource;

    public Target(String date, String lesson, int soccer, int imageResource) {
        this.date = date;
        this.lesson = lesson;
        this.soccer = soccer;
        this.imageResource = imageResource;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public int getSoccer() {
        return soccer;
    }

    public void setSoccer(int soccer) {
        this.soccer = soccer;
    }

    public int getImageResource() {
        return imageResource;
    }
}
