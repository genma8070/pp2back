package com.example.enquete_back_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.enquete_back.repository.QuestionDao;

@SpringBootTest
class RemsApplicationTests {

	@Autowired
	QuestionDao questionDao;


	
}