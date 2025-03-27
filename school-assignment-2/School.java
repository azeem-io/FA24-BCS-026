public class School {
    private String name;
    private String address;
    private Principal principal;
    private ClassRoom[] classes;
    private int classCount;
    private static final int MAX_CLASSES = 10;

    public School(String name, String address, Principal principal) {
        this.name = name;
        this.address = address;
        this.principal = principal;
        this.classes = new ClassRoom[MAX_CLASSES];
        this.classCount = 0;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public boolean addClass(ClassRoom classroom) {
        if (classCount >= MAX_CLASSES) {
            System.out.println("Cannot add more classes to the school!");
            return false;
        }

        classes[classCount] = classroom;
        classCount++;
        return true;
    }

    public ClassRoom[] getClasses() {
        return classes;
    }

    public int getClassCount() {
        return classCount;
    }

    @Override
    public String toString() {
        String result = "School Information: \nName: " + name +
                " \nAddress: " + address +
                " \nPrincipal: " + principal +
                " \nClasses (" + classCount + ")";

        if (classCount > 0) {
            result += "\nClass List:";
            result += "\n-----------------------------";
            for (int i = 0; i < classCount; i++) {
                result += "\n=>" + (i + 1) + ". " + classes[i];
                result += "\n-----------------------------";

            }
        }

        return result;
    }
}