package com.nuoda.glassesshop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class
        })
@PropertySource({
        "classpath:/application.properties"
})
@ComponentScan(basePackages = "com.nuoda.glassesshop")
@EnableScheduling
@EnableAspectJAutoProxy(exposeProxy = true)
public class GlassesShopApplication {
	public static void main(String[] args) {
		SpringApplication.run(GlassesShopApplication.class, args);
	}
}