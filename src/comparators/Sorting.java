package comparators;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<StudentClass> studentClasses = new ArrayList<>();
//        studentClasses.add(new StudentClass(1,"rahu1",3.45f));
//        studentClasses.add(new StudentClass(3,"rahu3",3.15f));
//        studentClasses.add(new StudentClass(2,"rahu2",3.35f));
//        studentClasses.add(new StudentClass(5,"rahu5",3.65f));
//        studentClasses.add(new StudentClass(4,"rahu4",3.85f));
        while (n-->0){
            int id = scan.nextInt();
            String name = scan.next();
            float cgpa = scan.nextFloat();
            studentClasses.add(new StudentClass(id,name,cgpa));
            studentClasses.sort(StudentClass::compareTo);
        }

        for(StudentClass s:studentClasses)
            System.out.println(s.getName());
    }
}
class StudentClass implements Comparable<StudentClass>{
    private final int id;
    private final String name;
    private final float cgpa;

    public StudentClass(int id, String name, float cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(@NotNull StudentClass o) {
       if (Float.compare(this.cgpa,o.cgpa) == 0){
           if (this.name.compareTo(o.name) == 0)
               return Integer.compare(o.id,this.id);
           else return this.name.compareTo(o.name);
       }
       return Float.compare(o.cgpa,this.cgpa);
    }
}