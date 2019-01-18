package reflectionw9;

import javax.swing.*;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StudentSummarizer {


    private List<Student> students = readStudents();

    private static List<Student> readStudents() {
        return new StudentReader().getStudents("reflectionw9/students-performance.csv");
    }
    public Long getNumberOfFemaleStudents(){
        return students.stream()
                .filter(student -> student.getGender().equals("female"))
                .count();
    }
    public Long getNumberOfMaleStudents(){
        return students.stream()
                .filter(student -> student.getGender().equals("male"))
                .count();
    }
    public Set getParentalEducationLevelsSortedAlphabetically(){
        return students.stream()
                .map(student->student.getLevelOfEducation())
                .sorted()
                .collect(Collectors.toSet());
    }
    public Long getStudentsWithScoresHigherThan90(){
        return students.stream()
                .filter(student -> student.getMathScore()>90)
                .filter(student -> student.getReadingScore()>90)
                .filter(student -> student.getWritingScore()>90)
                .count();
    }
    public Long getStudentsWithScoresEqualTo100(){
        return students.stream()
                .filter(student -> student.getMathScore()==100)
                .filter(student -> student.getReadingScore()==100)
                .filter(student -> student.getWritingScore()==100)
                .count();
    }


}
