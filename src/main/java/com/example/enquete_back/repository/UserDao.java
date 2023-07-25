package com.example.enquete_back.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.enquete_back.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String>{
	
//	取出該分頁的回答者資料
	@Query(value ="select * from user LIMIT :inputIndex, 10",nativeQuery =true)
	public List<Map<String, Object>> findAllUserPaging(@Param("inputIndex") Integer index);
	
//	取得所有回答者資料
	@Query(value ="select * from user",nativeQuery =true)
	public List<Map<String, Object>> findAllUser();
	

}
