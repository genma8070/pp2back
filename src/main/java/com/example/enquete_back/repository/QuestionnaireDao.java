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

//	新增問卷
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO questionnaire(title, description, start_time, end_time, status)"
			+ " VALUES(?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
	public void addEnquete(String title, String description, LocalDate startTime, LocalDate endTime, Boolean status);

	
//	找出所有問券
	@Query(value ="select * from questionnaire",nativeQuery =true)
	public List<Map<String, Object>> findAllQuestionnaire();
	
//	用ID找出問卷
	@Query(value ="select * from questionnaire q WHERE q.questionnaire_id = :inputId",nativeQuery =true)
	public List<Map<String, Object>> findByQuestionnaireId(@Param("inputId")Integer id);
	
//	找出該分頁的問券
	@Query(value ="select * from questionnaire LIMIT :inputIndex, 10",nativeQuery =true)
	public List<Map<String, Object>> findAllQuestionnairePaging(@Param("inputIndex") Integer index);
	
	
//	標題或日期模糊搜尋+分頁
	@Query(value = "SELECT * "
			+ "FROM questionnaire "
			+ "WHERE (title LIKE %:inputTitle%) "
			+ "AND (start_time >= :inputStartTime OR :inputStartTime IS NULL) "
			+ "AND (end_time <= :inputEndTime OR :inputEndTime IS NULL) "
			+ "LIMIT :inputIndex, 10", nativeQuery = true)
	public List<Map<String, Object>> findQuestionnaireByTitleOrDate(@Param("inputTitle") String title,@Param("inputStartTime") LocalDate startTime, @Param("inputEndTime") LocalDate endTime, @Param("inputIndex") Integer index);

//	更新問卷
	@Transactional
	@Modifying
	@Query(value = "update questionnaire "
			+ "set title = :inputTilte, description = :inputDescription, "
			+ "start_time = :inputStartTime, end_time = :inputEndTime, status = :inputStatus "
			+ "WHERE questionnaire_id = :inputId", nativeQuery = true)
	public void updateEnquete(@Param("inputTilte") String title,@Param("inputDescription") String description,@Param("inputStartTime") LocalDate startTime,
			@Param("inputEndTime") LocalDate endTime,@Param("inputStatus") Boolean status,@Param("inputId") Integer id);
	
//	更新問卷
	@Transactional
	@Modifying
	@Query(value = "update questionnaire "
			+ "set"
			+ " status = :inputStatus "
			+ "WHERE questionnaire_id = :inputId", nativeQuery = true)
	public void updateEnqueteStatus(@Param("inputStatus") Boolean status,@Param("inputId") Integer id);
	
//	刪除問券選項
	@Transactional
	@Modifying
	@Query(value = "DELETE op "
			+ "FROM questionnaire qe "
			+ "LEFT JOIN question qn ON qn.questionnaire_id = qe.questionnaire_id "
			+ "LEFT JOIN options op ON op.question_id = qn.question_id "
			+ "LEFT JOIN answer an ON an.questionnaire_id = qe.questionnaire_id "
			+ "WHERE qe.questionnaire_id = :inputId", nativeQuery = true)
	public void deleteEnqueteOptions(@Param("inputId") Integer id);
	
//	刪除問券作答紀錄
	@Transactional
	@Modifying
	@Query(value = "DELETE an "
			+ "FROM questionnaire qe "
			+ "LEFT JOIN question qn ON qn.questionnaire_id = qe.questionnaire_id "
			+ "LEFT JOIN options op ON op.question_id = qn.question_id "
			+ "LEFT JOIN answer an ON an.questionnaire_id = qe.questionnaire_id "
			+ "WHERE qe.questionnaire_id = :inputId", nativeQuery = true)
	public void deleteEnqueteAnswer(@Param("inputId")Integer id);
	
//	刪除問券問題
	@Transactional
	@Modifying
	@Query(value = "DELETE qn "
			+ "FROM questionnaire qe "
			+ "LEFT JOIN question qn ON qn.questionnaire_id = qe.questionnaire_id "
			+ "LEFT JOIN options op ON op.question_id = qn.question_id "
			+ "LEFT JOIN answer an ON an.questionnaire_id = qe.questionnaire_id "
			+ "WHERE qe.questionnaire_id = :inputId", nativeQuery = true)
	public void deleteEnqueteQuestion(@Param("inputId")Integer id);
	
//	刪除問卷
	@Transactional
	@Modifying
	@Query(value = "DELETE qe "
			+ "FROM questionnaire qe "
			+ "LEFT JOIN question qn ON qn.questionnaire_id = qe.questionnaire_id "
			+ "LEFT JOIN options op ON op.question_id = qn.question_id "
			+ "LEFT JOIN answer an ON an.questionnaire_id = qe.questionnaire_id "
			+ "WHERE qe.questionnaire_id = :inputId", nativeQuery = true)
	public void deleteEnqueteEnquete(@Param("inputId")Integer id);

//	找出最新的問卷
	@Query(value = "SELECT * FROM questionnaire ORDER BY questionnaire_id DESC LIMIT 1", nativeQuery = true)
	public Questionnaire findNewstEnquete();



}
