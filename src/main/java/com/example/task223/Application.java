package com.example.task223;


import com.example.task223.configuration.AppConfig;
import com.example.task223.entities.User;
import com.example.task223.repositories.UserRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserRepository userRepository = context.getBean(UserRepository.class);

		userRepository.addUser(new User("Ivan", "Ivanov"));
		userRepository.addUser(new User("Sergey", "Sergeev"));
		userRepository.addUser(new User("Andrey", "Andreev"));
		userRepository.addUser(new User("Egor", "Egorov"));

		userRepository.getAllUsers().forEach(System.out :: println);

		userRepository.deleteUser(3L);
		System.out.println(userRepository.getUserById(2L));
		userRepository.updateUser(new User("Vasiliy", "Vasiliev"));
		context.close();
	}

}
