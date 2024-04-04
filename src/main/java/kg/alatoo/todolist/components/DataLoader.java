package kg.alatoo.todolist.components;


import kg.alatoo.todolist.entity.Category;
import kg.alatoo.todolist.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ResourceLoader resourceLoader;
    private final Environment env;

    @Override
    public void run(String... args) throws Exception {

        boolean runOnStartup = Boolean.parseBoolean(env.getProperty("app.dataloader.run-on-startup", "false"));
        if (!runOnStartup) {
            return;
        }

        Resource resource = resourceLoader.getResource("classpath:data/category.csv");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                boolean categoryExists = categoryRepository.findByName(data[0]).isPresent();
                if (categoryExists) {
                    continue;
                }
                Category category = new Category();
                category.setName(data[0]);
                categoryRepository.save(category);
            }
        }
    }
}
