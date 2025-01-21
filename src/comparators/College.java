package comparators;

import java.util.ArrayList;
import java.util.List;

public class College {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Student s1 = new Student("helo",10,"bye");
        Student s2 = new Student("fsd",11,"hef");
        Student s3 = new Student("gsfsd",12,"dfss");
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.sort(Student::compareTo);
        System.out.println(studentList);

    }
}