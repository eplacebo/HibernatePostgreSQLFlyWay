import view.MainMenu;

public class Main {
    public static void main(String[] args) {

        FlywayMigrate.startMigrateDB();

        MainMenu menu = new MainMenu();
        menu.getMainMenu();
    }
}


