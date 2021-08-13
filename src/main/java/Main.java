import org.flywaydb.core.Flyway;
import view.MainMenu;

public class Main {
    public static void main(String[] args) {

        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres").load();
        flyway.repair();
        flyway.clean();
        flyway.migrate();


        MainMenu menu = new MainMenu();
        menu.getMainMenu();
    }
}


