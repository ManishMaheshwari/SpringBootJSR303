package manish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Order(value=2)
public class PrintVariables implements CommandLineRunner{
	
	@Autowired
	public Environment env;
	
	//program argument --argument=VAL
	@Value("${argument}")
	public String argument;
	
	//From application.properties
	@Value("${spring.datasource.password}")
	public String pass;
	
	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < args.length; i++) {
			System.out.println("Iterating: " + args[i]);
		}
		System.out.println(env.toString());
		
		//From program argument
		System.out.println(env.getProperty("argument"));
		
		//OS export 
		System.out.println(env.getProperty("PATH"));

		//From application.properties
		System.out.println( "spring.datasource.password : "+ env.getProperty("spring.datasource.password"));
		
		//From env
		System.out.println(env.getProperty("env"));
		
		System.out.println(argument);
		
	}

}
