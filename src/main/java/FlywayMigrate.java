import org.flywaydb.core.Flyway;

public class FlywayMigrate {
    public static void startMigrateDB(){
        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres").load();
        flyway.repair();
        flyway.clean();
        flyway.migrate();
    }
}
