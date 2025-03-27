public class ClassRoom {
    private String className;
    private String classCode;
    private Teacher teacher;
    private Student[] students;
    private int studentCount;
    private static int maxStudents = 5;

    public ClassRoom(String className, String classCode) {
        this.className = className;
        this.classCode = classCode;
        this.students = new Student[maxStudents];
        this.studentCount = 0;
    }

    public String getClassName() {
        return className;
    }

    public String getClassCode() {
        return classCode;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        if (this.teacher != null) {
            this.teacher.setAssignedClass(null);
        }

        this.teacher = teacher;

        if (teacher != null) {
            teacher.setAssignedClass(this);
        }
    }

    public boolean addStudent(Student student) {
        if (studentCount >= maxStudents) {
            System.out.println("Cannot add student. The class is full!");
            return false;
        }

        students[studentCount] = student;
        studentCount++;
        student.setEnrolledClass(this);
        return true;
    }

    public Student[] getStudents() {
        return students;
    }

    public int getStudentCount() {
        return studentCount;
    }

    @Override
    public String toString() {
        String result = "Class Room Info: \nName: " + className +
                " \nCode: " + classCode +
                " \nTeacher: " + teacher.getName() +
                " \nNo. of Students: " + studentCount;

        if (studentCount > 0) {
            result += "\nEnrolled Students:";
            for (int i = 0; i < studentCount; i++) {
                result += "\n    " + (i + 1) + ". " + students[i];
            }
        }

        return result;
    }
}