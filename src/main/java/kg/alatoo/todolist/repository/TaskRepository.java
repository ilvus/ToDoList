package kg.alatoo.todolist.repository;

import jakarta.persistence.Id;
import kg.alatoo.todolist.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Id> {

    Optional<Task> findById(long id);
}
