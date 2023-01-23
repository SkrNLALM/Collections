import java.util.*;

public class ArraylistReview {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Jose"));
        students.add(new Student(2, "Sayed"));
        students.add(new Student(3, "Nick"));
        students.add(new Student(4, "Ronnie"));
        System.out.println(students);
        //Iteration on ArrayLists
        //1. For loop with get(index)
        for (int i = 0; i < students.size(); i++) System.out.println(students.get(i));

        //2. Forward Iterator
        System.out.println("Printing with Iterator Forward...............");
        Iterator iter = students.listIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
            //2. Backward Iterator
        }
            System.out.println("Printing with Iterator Backwards...............");

            while (((ListIterator<?>) iter).hasPrevious()) {
                System.out.println(((ListIterator<?>) iter).previous());
            }

        System.out.println("Printing For each loop ...............");
            // For each loop
            for(Student student:students) System.out.println(student);

            //Lambda
        System.out.println("Printing with Lambda ...............");
            students.forEach(student -> System.out.println(student.name) );   //it can be also student or id

        //Sorting Elements in List
        System.out.println("Printing with sorted List by comp .................");
        Collections.sort(students, new sortByIdDesc());
        System.out.println(students);
        
        System.out.println("Printing with sorted List by name Desc .................");
        Collections.sort(students, new sortByNameDesc());
        System.out.println(students);

        }

        static class sortByIdDesc implements Comparator<Student>{
            @Override
            public int compare(Student o1, Student o2) {
                return o2.id-o1.id;
            }
        }
    static class sortByNameDesc implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o2.name.compareToIgnoreCase(o1.name);
        }
    }
}
