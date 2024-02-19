package com.example.videogames.services;

import com.example.videogames.models.Category;
import com.example.videogames.models.Product;
import com.example.videogames.models.user.User;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
        if (number <= 0) return;
        List<Product> listaProducts = createFakeProducts(number);
        for (int i = 0; i < number; i++) {
            Category category = new Category(
                    null,
                    UUID.randomUUID(),
                    faker.commerce().department(),
                    faker.bool().bool(),
                    listaProducts
            );

        }
        productService.saveAll(listaProducts);
        categoryService.save(category);
    }

    public List<Product> createFakeProducts(int number) {
        if (number <= 0) return null;

        List<Product> listaProducts = new ArrayList<>();
        List<Category> categories = categoryService.findAll();

        for (int i = 0; i < number; i++) {
            int categoryIndex = faker.number().numberBetween(0, categories.size());
            Category category = categories.get(categoryIndex);
            Product product = new Product(
                    null,
                    UUID.randomUUID(),
                    faker.commerce().productName(),
                    faker.lorem().sentence(10),
                    LocalDateTime.now(),
                    faker.number().randomDigitNotZero(),
                    faker.lorem().sentence(10),
                    faker.number().randomDouble(1, 0, 2),
                    category
            );
            listaProducts.add(product);
        }

        return listaProducts;
    }
}
