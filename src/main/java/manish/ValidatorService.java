package manish;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Component
public class ValidatorService {

	@Autowired
	public Validator validator;
	
	@Bean
	//Validator instances are thread-safe and may be reused multiple times.
	public javax.validation.Validator localValidatorFactoryBean() {
	   return new LocalValidatorFactoryBean();
	}
	
	public <T> void validate(T bean){
	   	 Set<ConstraintViolation<T>> constraintViolations = validator.validate(bean);
	   	 for (ConstraintViolation<T> constraintViolation : constraintViolations) {
				System.out.println(constraintViolation);
			//	System.out.println(constraintViolation.getClass().getCanonicalName());
			}    	 
	   }
}
