package de.cronos.test.javanineteen.records;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootApp.class, args);
        ServiceRecord serviceRecord = ctx.getBean(ServiceRecord.class);
        serviceRecord.log();
    }
}
