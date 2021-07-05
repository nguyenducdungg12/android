package com.deitel.qlsv.models;

public class Subject {
//    Mã môn học
    private int id;
//    Tên môn học
    private String subject_title;
//    Số tín chỉ
    private int number_of_credit;
//    Thời gian học
    private String time;
//    Địa điểm
    private String place;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject_title() {
        return subject_title;
    }

    public void setSubject_title(String subject_title) {
        this.subject_title = subject_title;
    }

    public int getNumber_of_credit() {
        return number_of_credit;
    }

    public void setNumber_of_credit(int number_of_credit) {
        this.number_of_credit = number_of_credit;
    }

    public String getTime() {
        return time;
    }

    public Subject(String subject_title, String day,String time) {
        this.subject_title = subject_title;
        this.day = day;
        this.time = time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Subject(String subject_title, int number_of_credit, String time, String place, String day) {
        this.subject_title = subject_title;
        this.number_of_credit = number_of_credit;
        this.time = time;
        this.place = place;
        this.day = day;
    }

    // Thứ
    private String day;

    public Subject(int id, String subject_title, int number_of_credit, String time, String place, String day) {
        this.id = id;
        this.subject_title = subject_title;
        this.number_of_credit = number_of_credit;
        this.time = time;
        this.place = place;
        this.day = day;
    }
}
