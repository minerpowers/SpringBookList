package dmacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

		List<Book> findBygenre(String genre);
}
