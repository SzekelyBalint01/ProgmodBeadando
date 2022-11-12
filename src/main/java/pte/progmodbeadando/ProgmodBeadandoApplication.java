package pte.progmodbeadando;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ProgmodBeadandoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProgmodBeadandoApplication.class, args);
    }

}
