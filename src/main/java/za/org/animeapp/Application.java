package za.org.animeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        try {
            SpringApplication.run(Application.class, args);
        }
        catch (Exception e) {
            System.out.println("\n\nAn error has occurred: " + "\n" + e);
        }
        finally {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//            System.out.println("Ensure workbench is installed and connected via application.properties");
            System.out.println("Connected to database...");
        }
    }
}