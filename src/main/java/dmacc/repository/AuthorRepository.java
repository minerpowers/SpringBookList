package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dmacc.beans.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	@Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Author a where a.firstName=:fName and a.lastName=:lName")
	boolean existsByFirstNameAndLastName(@Param("fName")String firstName, @Param("lName") String lastName);
	
	@Query("select a from Author a where a.firstName=:fName and a.lastName=:lName")
	Author findByFirstNameAndLastName(@Param("fName")String firstName, @Param("lName") String lastName);

}
