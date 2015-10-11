package $

{ group }

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        println 'Starting'.center(100, '=')
        SpringApplication.run Application, args
        println 'Stopped'.center(100, '=')
    }
}