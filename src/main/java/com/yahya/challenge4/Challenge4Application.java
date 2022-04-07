package com.yahya.challenge4;

import java.io.Console;
import com.yahya.challenge4.view.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Challenge4Application {

	public static void main(String[] args) {
		SpringApplication.run(Challenge4Application.class, args);
		Menu menu = new Menu();
		menu.Menu();

	}

}
