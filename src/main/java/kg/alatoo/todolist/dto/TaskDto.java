package kg.alatoo.todolist.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TaskDto {

    @Size(min = 3, max = 20, message = "Title should be between 3 and 20 characters")
    @NotNull(message = "Title is required")
    private String title;
    @Size(min = 3, max = 100, message = "Description should be between 3 and 100 characters")
    @NotNull(message = "Description is required")
    private String description;
    @NotNull(message = "Category is required")
    private Long categoryId;

}
