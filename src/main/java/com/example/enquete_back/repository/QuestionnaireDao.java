package com.example.enquete_back.repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.enquete_back.entity.Questionnaire;

@Repository
public interface QuestionnaireDao extends JpaRepository<Questionnaire, Integer> {

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO questionnaire(title, description, start_time, end_time, status)"
			+ " VALUES(?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
	public void addEnquete(String title, String description, LocalDate startTime, LocalDate endTime, Boolean status);

	@Query(value ="select * from questionnaire",nativeQuery =true)
	public List<Map<String, Object>> findAllQuestionnaire();
	
	@Query(value ="select * from questionnaire q WHERE q.questionnaire_id = :inputId",nativeQuery =true)
	public List<Map<String, Object>> findByQuestionnaireId(@Param("inputId")Integer id);
	
	@Query(value ="select * from questionnaire LIMIT :inputIndex, 10",nativeQuery =true)
	public List<Map<String, Object>> findAllQuestionnairePaging(@Param("inputIndex") Integer index);
	
	
	@Query(value = "SELECT * "
			+ "FROM questionnaire "
			+ "WHERE (title LIKE %:inputTitle%) "
			+ "AND (start_time >= :inputStartTime OR :inputStartTime IS NULL) "
			+ "AND (end_time <= :inputEndTime OR :inputEndTime IS NULL) "
			+ "LIMIT :inputIndex, 10", nativeQuery = true)
	public List<Map<String, Object>> findQuestionnaireByTitleOrDate(@Param("inputTitle") String title,@Param("inputStartTime") LocalDate startTime, @Param("inputEndTime") LocalDate endTime, @Param("inputIndex") Integer index);

	
	@Transactional
	@Modifying
	@Query(value = "update questionnaire "
			+ "set title = :inputTilte, description = :inputDescription, "
			+ "start_time = :inputStartTime, end_time = :inputEndTime, status = :inputStatus "
			+ "WHERE questionnaire_id = :inputId", nativeQuery = true)
	public void updateEnquete(@Param("inputTilte") String title,@Param("inputDescription") String description,@Param("inputStartTime") LocalDate startTime,
			@Param("inputEndTime") LocalDate endTime,@Param("inputStatus") Boolean status,@Param("inputId") Integer id);
	
	
	@Transactional
	@Modifying
	@Query(value = "DELETE op "
			+ "FROM questionnaire qe "
			+ "LEFT JOIN question qn ON qn.questionnaire_id = qe.questionnaire_id "
			+ "LEFT JOIN options op ON op.question_id = qn.question_id "
			+ "LEFT JOIN answer an ON an.questionnaire_id = qe.questionnaire_id "
			+ "WHERE qe.questionnaire_id = :inputId", nativeQuery = true)
	public void deleteEnqueteOptions(@Param("inputId") Integer id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE an "
			+ "FROM questionnaire qe "
			+ "LEFT JOIN question qn ON qn.questionnaire_id = qe.questionnaire_id "
			+ "LEFT JOIN options op ON op.question_id = qn.question_id "
			+ "LEFT JOIN answer an ON an.questionnaire_id = qe.questionnaire_id "
			+ "WHERE qe.questionnaire_id = :inputId", nativeQuery = true)
	public void deleteEnqueteAnswer(@Param("inputId")Integer id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE qn "
			+ "FROM questionnaire qe "
			+ "LEFT JOIN question qn ON qn.questionnaire_id = qe.questionnaire_id "
			+ "LEFT JOIN options op ON op.question_id = qn.question_id "
			+ "LEFT JOIN answer an ON an.questionnaire_id = qe.questionnaire_id "
			+ "WHERE qe.questionnaire_id = :inputId", nativeQuery = true)
	public void deleteEnqueteQuestion(@Param("inputId")Integer id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE qe "
			+ "FROM questionnaire qe "
			+ "LEFT JOIN question qn ON qn.questionnaire_id = qe.questionnaire_id "
			+ "LEFT JOIN options op ON op.question_id = qn.question_id "
			+ "LEFT JOIN answer an ON an.questionnaire_id = qe.questionnaire_id "
			+ "WHERE qe.questionnaire_id = :inputId", nativeQuery = true)
	public void deleteEnqueteEnquete(@Param("inputId")Integer id);

	@Query(value = "SELECT * FROM questionnaire ORDER BY questionnaire_id DESC LIMIT 1", nativeQuery = true)
	public Questionnaire findNewstEnquete();



}
