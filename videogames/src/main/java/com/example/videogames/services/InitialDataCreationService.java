package com.example.videogames.services;

import com.example.videogames.models.Category;
import com.example.videogames.models.user.User;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InitialDataCreationService {
    private final CategoryService categoryService;
    private final ProductService productService;
    private final UserDetailsServiceImpl userDetailsService;
    private final Faker faker = new Faker(new Locale("en-US"));

    public void createDefaultAdminUser() {
        User user = new User("user", "$2a$12$K4tojeaYWMK55KzWzDWtLOuuUjRTkycWhSGHYWA2LXMZqmZUtuXPO"); // Esto es "password" codificado con bcrypt)
        userDetailsService.save(user);
    }

    public void createFakeCategories(int number) {
        if(number <= 0) return;
        for (int i = 0; i < number; i++) {
            Category category = new Category(
                    null,
                    UUID.randomUUID(),
                    faker.commerce().department(),
                    Math.random() <0.50 ? faker.lorem().sentence(10) : null,
                    faker.color().hex(),
                    null,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
            categoryService.save(category);
        }
    }
}
