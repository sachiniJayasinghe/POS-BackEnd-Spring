package gdse68.posbackendspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "gdse68.posbackendspring")
@EnableWebMvc
@EnableJpaRepositories(basePackages = "gdse68.posbackendspring")
@EnableTransactionManagement
public class WebAppConfig {

}
