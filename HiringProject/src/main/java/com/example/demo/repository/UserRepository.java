package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("SELECT DISTINCT user FROM User user " +
            "INNER JOIN FETCH user.authorities AS authorities " +
            "WHERE user.username = :username")
   public User findByUsername(@Param("username") String username);
	
    @Query("delete from User where id=:id")
	public void delete(@Param("id")Long id);

	

}