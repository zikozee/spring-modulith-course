package com.zee.springmodulithcourse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest
class SpringModulithCourseApplicationTests {

    @Test
    void contextLoads() {
        ApplicationModules.of(SpringModulithCourseApplication.class).verify();
    }

}
