// Student.java
public class Student extends Person {
    private String rollNumber;
    private ClassRoom enrolledClass;

    public Student(String name, int age, String rollNumber) {
        super(name, age);
        this.rollNumber = rollNumber;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public ClassRoom getEnrolledClass() {
        return enrolledClass;
    }

    public void setEnrolledClass(ClassRoom enrolledClass) {
        this.enrolledClass = enrolledClass;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Student student = (Student) obj;
        return rollNumber != null && rollNumber.equals(student.rollNumber);
    }

    @Override
    public String toString() {
        return "Student [" + super.toString() +
                ", Roll Number: " + rollNumber +
                ", Class: " + (enrolledClass != null ? enrolledClass.getClassCode() : "None") + "]";
    }
}
