package com.zee.springmodulithcourse;

import com.zee.springmodulithcourse.config.ModulithRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@ImportRuntimeHints(ModulithRegistrar.class)
@SpringBootApplication
public class SpringModulithCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringModulithCourseApplication.class, args);
    }

}
