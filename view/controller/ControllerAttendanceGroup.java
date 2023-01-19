package view.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Student;
import model.StudentGroup;
import view.attandance.AttendanceGroup;
import view.attandance.AttendanceVisit;

public class ControllerAttendanceGroup extends ControllerAbstract {

    AttendanceGroup attendanceGroup;
    Student student;
    AttendanceVisit attendanceVisit;
    Map<String, Integer> sortedStudentVisit;

    public ControllerAttendanceGroup(AttendanceGroup attendanceGroup) {
        this.attendanceGroup = attendanceGroup;
        this.sortedStudentVisit = new HashMap<>();
    }

    public AttendanceGroup getAttendanceGroup() {
        return attendanceGroup;
    }

    public Student getStudent() {
        return student;
    }

    public AttendanceVisit getAttendanceVisit() {
        return attendanceVisit;
    }

    public void PrintSortStudentsVisiting(StudentGroup studentGroup) {
        List<String> sortListStudent = new ArrayList<>();
        for (AttendanceVisit attendanceVisit : attendanceGroup.getAttendanceView()) {
            int countTrue = 0;
            for (Boolean boolean1 : attendanceVisit.getVisit().values()) {
                if (boolean1 == true) {
                    countTrue++;
                }
            }
            sortedStudentVisit.put(attendanceVisit.getStudent().getName(), countTrue);
        }
        for (String iterable : sortedStudentVisit.keySet()) {
            sortListStudent.add(iterable);
        }
        System.out.println("-------------------------------------");
        System.out.println("Список посещаемости студентов по убыванию:");
        for (int i = sortListStudent.size() - 1; i >= 0; i--) {
            System.out.println(sortListStudent.get(i));
        }
    }

    public void PrintStudentsVisitingLess25Persent(StudentGroup studentGroup) {
        for (AttendanceVisit attendanceVisit : attendanceGroup.getAttendanceView()) {
            int count = 0;
            int countTrue = 0;
            for (Boolean boolean1 : attendanceVisit.getVisit().values()) {
                if (boolean1 == true) {
                    countTrue++;
                }
                count++;
            }
            if ((float) count / 100 * 25 > countTrue) {
                System.out.println("-------------------------------------");
                System.out.println(attendanceVisit.getStudent().getName() + " - процент посещения ниже 25%");
            }
        }
    }

    public void PrintStudentsVisitingPercent(StudentGroup studentGroup) {
        for (AttendanceVisit attendanceVisit : attendanceGroup.getAttendanceView()) {
            int count = 0;
            int countTrue = 0;
            for (Boolean boolean1 : attendanceVisit.getVisit().values()) {
                if (boolean1 == true) {
                    countTrue++;
                }
                count++;
            }
            System.out.println(attendanceVisit.getStudent().getName() + " - процент посещения = "
                    + (float) countTrue * 100 / count + "\n");
        }
    }

}