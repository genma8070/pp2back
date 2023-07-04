	package com.example.enquete_back.repository;
	
	import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.enquete_back.entity.Option;
	
	@Repository
	public interface OptionDao extends JpaRepository<Option, Integer> {
		@Transactional
		@Modifying
		@Query(value = "INSERT INTO options (question_id, option_text) VALUES (?1, ?2)", nativeQuery = true)
		public void addOption(Integer questionId, String optionText);
	
//		public List<Option> findAllByQuestionId(Integer questionId);
	
	}
