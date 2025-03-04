import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 85),
            new Student("Bob", 70),
            new Student("Charlie", 90),
            new Student("David", 60),
            new Student("Eve", 78)
        );

        
        List<String> topStudents = students.stream()
            .filter(s -> s.getMarks() > 75) 
            .sorted(Comparator.comparingDouble(Student::getMarks).reversed()) 
            .map(Student::getName) 
            .collect(Collectors.toList()); 

        System.out.println("Students scoring above 75%, sorted by marks:");
        topStudents.forEach(System.out::println);
    }
}
