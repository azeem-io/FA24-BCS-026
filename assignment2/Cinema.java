public class Cinema {
    private String name;
    private String location;
    private Screen[] screens;
    private int screenCount;

    public Cinema(String name, String location, int totalScreens) {
        this.name = name;
        this.location = location;
        this.screens = new Screen[totalScreens];
        this.screenCount = 0;
    }

    public void addScreen(int index, Screen screen) {
        if (index >= 0 && index < screens.length && screenCount < screens.length) {
            screens[index] = screen;
            screenCount++;
        }
    }

    public void displayCinema() {
        System.out.println("Cinema: " + name);
        System.out.println("Location: " + location);
        System.out.println("Total Screens: " + screens.length);
        System.out.println("\nScreen Details:");

        for (int i = 0; i < screenCount; i++) {
            if (screens[i] != null) {
                System.out.println("\nScreen #" + (i + 1) + ":");
                screens[i].displayScreen();
            }
        }
    }
}
