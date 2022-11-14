package com.example.demo;

import com.example.demo.service.CoreConfigEditorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(DemoApplication.class, args);
		CoreConfigEditorService c = new CoreConfigEditorService();
//		c.testEdit();
//		c.testReplaceLine();
	}
}
