package com.example.quizapp;

public class LessonLibary {
    private String nameLesson;
    private String amount;
    private int picture;

    public LessonLibary() {

    }

    public LessonLibary(String nameLesson, String amount, int picture) {
        this.nameLesson = nameLesson;
        this.amount = amount;
        this.picture = picture;
    }

    public String getNameLesson() {
        return nameLesson;
    }

    public void setNameLesson(String nameLesson) {
        this.nameLesson = nameLesson;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
