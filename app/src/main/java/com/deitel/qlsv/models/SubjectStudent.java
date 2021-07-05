package com.deitel.qlsv.models;

public class SubjectStudent {
    private int id_student;
    //    Tên môn học
    private int id_subject;
    //    Số tín chỉ
    private float studentscore;

    public SubjectStudent(int id_student, int id_subject, float studentscore) {
        this.id_student = id_student;
        this.id_subject = id_subject;
        this.studentscore = studentscore;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public float getStudentscore() {
        return studentscore;
    }

    public void setStudentscore(float studentscore) {
        this.studentscore = studentscore;
    }
}
