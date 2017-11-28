package hu.bab.aopdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import hu.bab.aopdemo.entity.Student;

@Configuration
@EnableAspectJAutoProxy
public class StudentConfiguration {
	@Bean
	public Student getSteve(){
		Student student = new Student("Steve", 20);
		return student;
	}

	@Bean
	public Student getJohn(){
		Student student = new Student("John", 22);
		return student;
	}
}
