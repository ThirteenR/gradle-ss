import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.chris.project.*", exclude = DataSourceAutoConfiguration.class)
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class);
    }
}
