package hu.abb.aopdemo.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	@Before("execution(public void hu.abb.aopdemo.entity.Student.set*(String))")
	public void logStudentSetter(JoinPoint joinPoint){
		System.out.println("*** " + joinPoint.getSignature().getName() + " has been called, with:");
		Object[] objects = joinPoint.getArgs();
		Arrays.stream(objects).forEach(System.out::println);
	}
}
