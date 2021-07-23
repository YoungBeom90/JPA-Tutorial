package jpa.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
/* @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) */ // 디비연결 안하고 실행할 경우에만 사용
public class JpshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpshopApplication.class, args);
	}

}