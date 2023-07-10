package com.example.enquete_back.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.enquete_back.entity.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO question(question_type, questionnaire_id, question_text, is_required)"
			+ " VALUES(?1, ?2, ?3, ?4)", nativeQuery = true)
	public void addQuestion(Boolean questionType, Integer questionnaireId, String questionText, Boolean isRequired);

	@Query(value = "SELECT * FROM question ORDER BY question_id DESC LIMIT 1", nativeQuery = true)
	public Question findNewstQuestion();

	@Query(value = "SELECT * FROM question WHERE questionnaire_id = :inputId", nativeQuery = true)
	public List<Map<String, Object>> findQuestionByQuestionnaireId(@Param("inputId") Integer questionnaireId);

	
	@Transactional
	@Modifying
	@Query(value = "update question "
			+ "set question_type = :inputQuestionType, question_text = :inputQuestionText, "
			+ "is_required = :inputIsRequired "
			+ "WHERE question_id = :inputId", nativeQuery = true)
	public void updateQuestion(@Param("inputQuestionType") Boolean type,@Param("inputQuestionText") String text,
			@Param("inputIsRequired") Boolean is,@Param("inputId") Integer id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE q FROM question q WHERE question_id = :inputId", nativeQuery = true)
	public void deleteQuestionOptions(@Param("inputId") Integer id);



}
