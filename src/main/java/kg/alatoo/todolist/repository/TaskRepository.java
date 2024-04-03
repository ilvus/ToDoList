package kg.alatoo.todolist.repository;

import jakarta.persistence.Id;
import kg.alatoo.todolist.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Id> {

    Optional<Task> findById(long id);
}
