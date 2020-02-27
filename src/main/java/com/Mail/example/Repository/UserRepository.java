package com.Mail.example.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.Mail.example.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>,PagingAndSortingRepository<User, Long>{
 Page<User> findAll(Pageable page) ;
@Query("from User where name=?1 order by name")
List<User> findbyNameSorted(String name);
}
		