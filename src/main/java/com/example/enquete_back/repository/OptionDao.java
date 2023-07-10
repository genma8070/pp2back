package com.example.enquete_back.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.enquete_back.entity.Option;

@Repository
public interface OptionDao extends JpaRepository<Option, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO options (question_id, option_text) VALUES (?1, ?2)", nativeQuery = true)
	public void addOption(Integer questionId, String optionText);

	@Query(value = "SELECT * FROM options WHERE question_id = :inputId", nativeQuery = true)
	public List<Map<String, Object>> findOptionByQuestionId(@Param("inputId") Integer questionId);

	@Transactional
	@Modifying
	@Query(value = "update options " + "set option_text = :inputQuestionText "
			+ "WHERE option_id = :inputId", nativeQuery = true)
	public void updateOptions(@Param("inputQuestionText") String text,
			@Param("inputId") Integer id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE o "
			+ "FROM options o "
			+ "WHERE option_id = :inputId", nativeQuery = true)
	public void deleteQuestionOptions(@Param("inputId") Integer id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE o FROM options o WHERE question_id = :inputId", nativeQuery = true)
	public void deleteOptionsByQuestionId(@Param("inputId") Integer id);


}
