package jpa.com.jpa_pjt;


import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//(exclude = DataSourceAutoConfiguration.class)
public class JpaPjtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaPjtApplication.class, args);
	}

}
