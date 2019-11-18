package cn.com.fovsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class FovsoftApplication {

    public static void main(String[] args) {
        SpringApplication.run(FovsoftApplication.class, args);
    }

}

//@SpringBootApplication
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class FovsoftApplication extends SpringBootServletInitializer{
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(FovsoftApplication.class);
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(FovsoftApplication.class,args);
//    }
//}
