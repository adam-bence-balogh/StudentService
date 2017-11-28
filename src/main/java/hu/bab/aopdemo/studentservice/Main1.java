package hu.bab.aopdemo.studentservice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hu.bab.aopdemo.entity.Student;

public class Main1 {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("hu.bab");
		Student steve = applicationContext.getBean("getSteve", Student.class);
		Student john = applicationContext.getBean("getJohn", Student.class);

		printOutStudentInformations(steve, john);
		ageModifier(steve);
		nameModifier(steve);
		ageModifier(john);
		nameModifier(john);
		printOutStudentInformations(steve, john);

		Student tony = new Student();
		tony.setName("Tony");
		tony.setAge(32);
	}

	public static void printOutStudentInformations(Student... students){
		Arrays.stream(students)
				.forEach(System.out::println);
	}

	public static void ageModifier(Student student){
		int modifiedAge = ThreadLocalRandom.current().nextInt(20,40);
		student.setAge(modifiedAge);
	}

	public static void nameModifier(Student student){
		List<String> names = Arrays.asList("Nick", "Larry", "Pete");
		int randomNameIndex = ThreadLocalRandom.current().nextInt(names.size());
		student.setName(names.get(randomNameIndex));
	}
}
