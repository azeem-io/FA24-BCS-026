public class Supervisor extends Person {
    private int experience;

    Supervisor(String name, int exp) {
        super(name);
        this.experience = exp;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Experience: " + experience + " years";
    }
}