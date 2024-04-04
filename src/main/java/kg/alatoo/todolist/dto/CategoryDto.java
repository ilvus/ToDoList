package kg.alatoo.todolist.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryDto {


    @Size(min = 3, max = 20, message = "Name should be between 3 and 20 characters")
    @NotNull(message = "Name is required")
    String name;
}
