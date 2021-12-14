package com.example.demo.repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.AuthorityDto;
import com.example.demo.entity.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>
{
	
	@Query(value = "SELECT u FROM Authority u where name IN (:roles)", nativeQuery = true)
    List<Authority> find(@Param("roles") Collection<String> collection);

}
