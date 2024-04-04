package kg.alatoo.todolist.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Azamat Ibragimov",
                        email = "azamat.ibragimov3102@gmail.com"
                ),
                description = "OpenApi documentation for Todo List Application",
                title = "TODOLIST SWAGGER DOCUMENTATION",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "LOCAL SERVER",
                        url = "http://localhost:8080"
                )
        }
)
public class OpenApiConfig {
}
