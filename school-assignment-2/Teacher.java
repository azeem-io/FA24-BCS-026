public class Teacher extends Person {
    private String subject;
    private String teacherId;
    private ClassRoom assignedClass;

    public Teacher(String name, int age, String subject, String teacherId) {
        super(name, age);
        this.subject = subject;
        this.teacherId = teacherId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public ClassRoom getAssignedClass() {
        return assignedClass;
    }

    public void setAssignedClass(ClassRoom assignedClass) {
        this.assignedClass = assignedClass;
    }


}
