package com.example.enquete_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.enquete_back.entity.Question;
import com.example.enquete_back.entity.Questionnaire;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO question(question_type, questionnaire_id, question_text, is_required)"
			+ " VALUES(?1, ?2, ?3, ?4)", nativeQuery = true)
	public void addQuestion(Boolean questionType, Integer questionnaireId, String questionText, Boolean isRequired);

	@Query(value = "SELECT * FROM question ORDER BY question_id DESC LIMIT 1", nativeQuery = true)
	public Question findNewstQuestion();

//	public void addOption(Integer questionId, String optionText);

}
