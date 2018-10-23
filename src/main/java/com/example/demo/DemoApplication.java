package com.example.demo;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(MemberRepo memberRepo) {
        return args -> {
            final List<String> members = Arrays.asList("Cherprang", "Tarwarn", "Kaw", "Milin");
            members.forEach(it -> {
                Member member = new Member();
                member.setName(it);
                memberRepo.save(member);
            });

            memberRepo.findAll().forEach(System.out::println);
        };
    }
}
