package com.example.enquete_back.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.enquete_back.entity.Answer;

@Repository
public interface AnswerDao extends JpaRepository<Answer, Integer>{
	
//	新增回答
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO answer (questionnaire_id, selected_options, answer_name, answer_phone"
			+ ", answer_email, answer_age, answer_time) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
	public void addAnswer(Integer questionnaireId, String selectedOptions, String answerName, String answerPhone
			, String answerEmail, Integer answerAge, String answerTime);
	
//	取得該分頁的回答者資料
	@Query(value ="select * from answer",nativeQuery =true)
	public List<Map<String, Object>> findAllAnswer();
	
//	取得所有回答者資料
	@Query(value = "select * from answer where questionnaire_id = :inputId", nativeQuery = true)
	public List<Map<String, Object>> getAnswerDataByEnqueteId(@Param("inputId") Integer questionnaireId);

//	取得該分頁的回答者資料
	@Query(value ="select * from answer ORDER BY answer_time DESC LIMIT :inputIndex, 10",nativeQuery =true)
	public List<Map<String, Object>> findAllAnswerPaging(@Param("inputIndex") Integer index);
	
//	用id找尋該回答者資料
	@Query(value ="select * from answer WHERE answer_id = :inputId",nativeQuery =true)
	public List<Map<String, Object>> findAnswerById(@Param("inputId") Integer Id);
	



}
