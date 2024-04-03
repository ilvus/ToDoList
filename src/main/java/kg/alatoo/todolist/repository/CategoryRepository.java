package kg.alatoo.todolist.repository;

import jakarta.persistence.Id;
import kg.alatoo.todolist.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Id> {
    Optional<Category> findById(long id);
}
