package cretioproject.try1.Repository;

import cretioproject.try1.Entity.BookEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Transactional
public interface BookRepo extends JpaRepository<BookEntity,Long> {
    BookEntity findByIsbn(long isbn);

    void deleteByIsbn(long isbn);
}
