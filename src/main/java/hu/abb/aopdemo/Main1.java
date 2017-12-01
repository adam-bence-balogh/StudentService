package hu.abb.aopdemo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hu.abb.aopdemo.entity.Person;
import hu.abb.aopdemo.entity.Student;
import hu.abb.aopdemo.service.PersonDataSenderService;

public class Main1 {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("hu.abb");
		Person steve = applicationContext.getBean("getSteve", Person.class);
		Person john = applicationContext.getBean("getJohn", Person.class);

		printOutStudentInformation(steve, john);
		ageModifier(steve);
		nameModifier(steve);
		ageModifier(john);
		nameModifier(john);
		printOutStudentInformation(steve, john);

		sendData(applicationContext, steve);
		sendData(applicationContext, john);
	}

	public static void printOutStudentInformation(Person... students){
		Arrays.stream(students)
				.forEach(System.out::println);
	}

	public static void ageModifier(Person student){
		int modifiedAge = ThreadLocalRandom.current().nextInt(20,40);
		student.setAge(modifiedAge);
	}

	public static void nameModifier(Person student){
		List<String> names = Arrays.asList("Nick", "Larry", "Pete");
		int randomNameIndex = ThreadLocalRandom.current().nextInt(names.size());
		student.setName(names.get(randomNameIndex));
	}

	public static void sendData(ApplicationContext applicationContext, Person student){
		PersonDataSenderService personDataSenderService = applicationContext.getBean(PersonDataSenderService.class);
		try {
			personDataSenderService.send(student);
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
}
