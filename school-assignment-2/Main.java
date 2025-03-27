public class Main {
    public static void main(String[] args) {
        Principal principal = new Principal("Dr. Smith", 45, 15);

        School school = new School("Comsats", "Defence rd, Lahore", principal);

        Teacher mathTeacher = new Teacher("John", 35, "Mathematics", "01");
        Teacher scienceTeacher = new Teacher("Bob", 32, "Science", "02");

        ClassRoom n15 = new ClassRoom("Semester 1", "N15");
        ClassRoom n16 = new ClassRoom("Semester 2", "N16");

        n15.setTeacher(mathTeacher);
        n16.setTeacher(scienceTeacher);

        school.addClass(n15);
        school.addClass(n16);

        Student student1 = new Student("Hadi", 15, "01");
        Student student2 = new Student("Ahmed", 15, "02");

        Student student3 = new Student("Haris", 16, "03");



        n15.addStudent(student1);
        n15.addStudent(student2);

        n16.addStudent(student3);

        System.out.println(school.toString());

        System.out.println("Student equality test (should be true): " + student1.equals(student1));
        System.out.println("Student equality test (should be true): " + student1.equals(student2));
    }
}
