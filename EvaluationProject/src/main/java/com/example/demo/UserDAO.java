package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserDAO extends JpaRepository<UserDTO, Integer>{
	@Query("select COUNT(*) from UserDTO where id In(?1,?2)")
	public int findByExists(int crid,int dbid);
	@Modifying
	@Query("update UserDTO u set u.balance=?2 where u.id=?1")
	public void updateAmount(int id,int amount);
}
