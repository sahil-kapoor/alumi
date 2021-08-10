import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"nz.co.alumi.*"})
@EnableMongoRepositories
@EnableMongoAuditing
public class AlumiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlumiApplication.class, args);
	}

}
