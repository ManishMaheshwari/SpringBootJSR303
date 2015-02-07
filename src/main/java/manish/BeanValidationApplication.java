package manish;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BeanValidationApplication {

	public static void main(String[] args) {
		System.out.println("Starting...");
		SpringApplication app = new SpringApplication(BeanValidationApplication.class);
		//Customize..
		ApplicationContext context = app.run(args);
		
		//Look for a shutdownSignal.
		SpringApplication.exit(context, new ExitCodeGenerator() {
			
			@Override
			public int getExitCode() {
				System.out.println("Stopping..");
				return 0;
			}
		});
		
	}

}
