package com.example.enquete_back_test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.enquete_back.repository.QuestionDao;
import com.example.enquete_back.vo.response.QuestionResponse;
import com.example.enquete_back.vo.response.SessionAddVo;

@SpringBootTest
class RemsApplicationTests {

	@Autowired
	QuestionDao questionDao;

	// 搜索全部物件
	@Test
	public QuestionResponse addSessionQuestion(SessionAddVo sessionReq, HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<SessionAddVo> questions = (List<SessionAddVo>) session.getAttribute("questions");
		if (questions == null) {
			questions = new ArrayList<>();
		}
		Integer questionnaireId = 1;

		Boolean questionType = false;

		String questionText = "1";

		Boolean isRequired = false;

		String options = "1";

		SessionAddVo add = new SessionAddVo(questionnaireId, questionType, questionText, isRequired, options);
		questions.add(add);

		session.setAttribute("questions", questions);
		System.out.println(session.getAttribute("questions"));
		return new QuestionResponse();
	}
}