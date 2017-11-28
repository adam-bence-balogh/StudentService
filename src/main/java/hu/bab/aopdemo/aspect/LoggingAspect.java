package hu.bab.aopdemo.aspect;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	@Before("execution(public void hu.bab.aopdemo.entity.Student.set*(..))")
	public void logStudentSetters(){
		System.out.println("*** Student setter has been called " + LocalTime.now());
	}

	@Before("execution(public void hu.bab.aopdemo.entity.*.set*(..))")
	public void logEveryEntitySetters(){
		System.out.println("*** setter has been called " + LocalTime.now());
	}
}
