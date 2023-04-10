package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/*
 * The UserDAO will used to create the table in the database.
 * The table will be created according to the UserDTO structure and the primary key of type Integer.
 * */
public interface UserDAO extends JpaRepository<UserDTO, Integer> {
	/*
	 * @param int creditID, int debitID This method will run according to the query
	 * given using above the method declaration using @Query annotation.
	 * 
	 * @return int
	 */
	@Query("select COUNT(*) from UserDTO where id In(?1,?2)")
	public int findByExists(int creditID, int debitID);

	/*
	 * @param int id, int amount This method will update the user balance in the
	 * userDTO object.
	 */
	@Modifying
	@Query("update UserDTO u set u.balance=?2 where u.id=?1")
	public void updateAmount(int id, int amount);
}
