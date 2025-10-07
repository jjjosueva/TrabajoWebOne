package com.example.mvccrudlogin.config;

import com.example.mvccrudlogin.model.Book;
import com.example.mvccrudlogin.model.User;
import com.example.mvccrudlogin.repository.BookRepository;
import com.example.mvccrudlogin.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(UserRepository users, BookRepository books, PasswordEncoder enc) {
        return args -> {
            if (users.findByUsername("admin").isEmpty()) {
                users.save(new User("admin", enc.encode("admin123"), "ROLE_USER"));
            }
            if (books.count() == 0) {
                Book b1 = new Book();
                b1.setTitle("Clean Code");
                b1.setAuthor("Robert C. Martin");
                books.save(b1);

                Book b2 = new Book();
                b2.setTitle("Design Patterns");
                b2.setAuthor("GoF");
                books.save(b2);
            }
        };
    }
}
