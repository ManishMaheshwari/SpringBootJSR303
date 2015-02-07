package manish;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 3)
public class Jsr303 implements CommandLineRunner {

	@Autowired
	private ValidatorService validatorService;

	@Value("${manish.processors}")
	@Min(4)
	@Max(8)
	private int processors;

	@Value("${manish.debug}")
	private boolean debug;

	@Value("${manish.country}")
	@NotNull
	@Size(min = 4, max = 8)
	private String country;

	@Value("${manish.friends}")
	@Min(2)
	private int friends;
	
	@Value("${manish.email}")
	@Pattern(regexp="[1-9]{6}dotCOM")
	public String email;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("JSR-303 >>>>>>>>>>>>>>");
		System.out.println(processors);
		System.out.println(debug);
		System.out.println("JSR-303 >>>>>>>>>>>>>>");
		
	}
	
	@PostConstruct
	public void validate(){
		validatorService.validate(this);
	}
	

}
