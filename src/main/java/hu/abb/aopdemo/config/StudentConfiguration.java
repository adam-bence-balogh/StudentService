package hu.abb.aopdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import hu.abb.aopdemo.entity.Person;
import hu.abb.aopdemo.entity.Student;

@Configuration
@EnableAspectJAutoProxy
public class StudentConfiguration {
	@Bean
	public Person getSteve(){
		Student student = new Student("Steve", 20);
		return student;
	}

	@Bean
	public Person getJohn(){
		Student student = new Student("John", 22);
		return student;
	}
}
