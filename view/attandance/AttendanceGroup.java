package view.attandance;

import java.util.ArrayList;
import java.util.List;

public class AttendanceGroup {

    private List<AttendanceVisit> attendanceVisit = new ArrayList<>();

    public List<AttendanceVisit> getAttendanceView() {
        return attendanceVisit;
    }

    public void addAttendanceVisit(AttendanceVisit attendanceStudent) {
        attendanceVisit.add(attendanceStudent);
    }

    @Override
    public String toString() {
        return "AttendanceGroup [attendanceView=" + attendanceVisit + "]";
    }

}