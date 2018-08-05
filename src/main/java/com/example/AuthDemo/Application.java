package com.example.AuthDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(com.example.AuthDemo.Application.class, args);
        System.out.println("http://localhost:8080/");
	}


	@GetMapping("/")
	public String homepage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		System.out.println(session.getId() + " " + username);
	    return "index";
	}


}
