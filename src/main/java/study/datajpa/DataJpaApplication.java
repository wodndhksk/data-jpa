package study.datajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.UUID;


@EnableJpaAuditing
@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaApplication.class, args);
	}

	/**
	 * @CreatedBy, @LastModifiedBy 에 사용될 정보를 제공
	 * (원래는 user 정보를 꺼내는게 일반적. 현재는 학습을 위해 임시로 UUID 를 사용함)
	 * @return
	 */
	@Bean
	public AuditorAware<String> auditorProvider(){
		return ()-> Optional.of(UUID.randomUUID().toString());
	}

}
