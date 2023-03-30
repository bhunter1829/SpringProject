package Inventory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Application {
    /**
     * Logger setup
     */
    public static Logger log = LogManager.getLogger(Application.class);

    /**
     * SpringApplication.run will set up the Spring ArtApplication Context for us and start up all controllers
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
