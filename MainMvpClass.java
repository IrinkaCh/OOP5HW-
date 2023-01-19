import model.Student;
import model.StudentGroup;
import view.attandance.AttendanceGroup;
import view.attandance.AttendanceVisit;
import view.controller.*;

public class MainMvpClass {

    public static void main(String[] args) {
        // Создание объектов студентов
        Student Ирина = new Student("Ирина", 1);
        Student Егор = new Student("Егор", 1);
        Student Ксения = new Student("Ксения", 1);
        
        // Создание объекта группы студентов
        StudentGroup studentGroupOneCourse = new StudentGroup();
        // Добавление студентов в группу студентов
        studentGroupOneCourse.addStudentInGroup(Ирина);
        studentGroupOneCourse.addStudentInGroup(Егор);
        studentGroupOneCourse.addStudentInGroup(Ксения);
        
        // Создание объекта о посещении студентов
        AttendanceVisit attendanceVisitingИрина = new AttendanceVisit(Ирина);
        AttendanceVisit attendanceVisitingЕгор = new AttendanceVisit(Егор);
        AttendanceVisit attendanceVisitingКсения = new AttendanceVisit(Ксения);
        
        // список посещений студентов
        attendanceVisitingИрина.addVisiting("01-09-2022", true);
        attendanceVisitingИрина.addVisiting("02-09-2022", false);
        attendanceVisitingИрина.addVisiting("03-09-2022", true);
        attendanceVisitingИрина.addVisiting("04-09-2022", true);
        attendanceVisitingИрина.addVisiting("05-09-2022", true);

        attendanceVisitingЕгор.addVisiting("01-09-2022", true);
        attendanceVisitingЕгор.addVisiting("02-09-2022", false);
        attendanceVisitingЕгор.addVisiting("03-09-2022", true);
        attendanceVisitingЕгор.addVisiting("04-09-2022", true);
        attendanceVisitingЕгор.addVisiting("05-09-2022", false);

        attendanceVisitingКсения.addVisiting("01-09-2022", true);
        attendanceVisitingКсения.addVisiting("02-09-2022", false);
        attendanceVisitingКсения.addVisiting("03-09-2022", false);
        attendanceVisitingКсения.addVisiting("04-09-2022", false);
        attendanceVisitingКсения.addVisiting("05-09-2022", false);

        // Спсиок группы студентов и их посещаемость
        AttendanceGroup attendanceGroupOneCourse = new AttendanceGroup();
        attendanceGroupOneCourse.addAttendanceVisit(attendanceVisitingИрина);
        attendanceGroupOneCourse.addAttendanceVisit(attendanceVisitingЕгор);
        attendanceGroupOneCourse.addAttendanceVisit(attendanceVisitingКсения);
        
        // Создание объекта контроллера посещения группы
        ControllerAttendanceGroup controllerGroup = new ControllerAttendanceGroup(attendanceGroupOneCourse);

        controllerGroup.PrintStudentsVisitingPercent(studentGroupOneCourse);
        controllerGroup.PrintStudentsVisitingLess25Persent(studentGroupOneCourse);
        controllerGroup.PrintSortStudentsVisiting(studentGroupOneCourse);
    }
}