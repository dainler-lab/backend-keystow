package com.keystow.application.user;

import io.github.wimdeblauwe.jpearl.InMemoryUniqueIdGenerator;
import io.github.wimdeblauwe.jpearl.UniqueIdGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("data-jpa-test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

	private final UserRepository repository;

	private final JdbcTemplate jdbcTemplate;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	UserRepositoryTest(UserRepository repository, JdbcTemplate jdbcTemplate) {
		this.repository = repository;
		this.jdbcTemplate = jdbcTemplate;
	}

	@BeforeEach
	void validatePreconditions() {
		assertThat(repository.count()).isZero();
	}

	@Test
	void testSaveUser() {

		UserId id = repository.nextId();

		// @formatter:off
		repository.save(new User(
			id,
			new UserName("Tommy", "Walton"),
			new Email("tommy.walton@gmail.com"),
			"password",
			true,
			LocalDateTime.of(2022, Month.NOVEMBER, 11, 11, 11, 11)

		));
		// @formatter:on

		entityManager.flush();

		// UUID idInDb = jdbcTemplate.queryForObject("SELECT id FROM tt_user",
		// UUID.class);
		// assertThat(idInDb).isEqualTo(id.getId());

		assertThat(jdbcTemplate.queryForObject("SELECT id FROM tt_user", UUID.class)).isEqualTo(id.getId());
		assertThat(jdbcTemplate.queryForObject("SELECT first_name FROM tt_user", String.class)).isEqualTo("Tommy");
		assertThat(jdbcTemplate.queryForObject("SELECT last_name FROM tt_user", String.class)).isEqualTo("Walton");
		assertThat(jdbcTemplate.queryForObject("SELECT email FROM tt_user", String.class))
				.isEqualTo("tommy.walton@gmail.com");
		assertThat(jdbcTemplate.queryForObject("SELECT password FROM tt_user", String.class)).isEqualTo("password");
		assertThat(jdbcTemplate.queryForObject("SELECT enabled FROM tt_user", Boolean.class)).isEqualTo(true);
		assertThat(jdbcTemplate.queryForObject("SELECT created_at FROM tt_user", LocalDateTime.class))
				.isEqualTo(LocalDateTime.of(2022, Month.NOVEMBER, 11, 11, 11, 11));
	}

	@TestConfiguration
	static class TestConfig {

		@Bean
		public UniqueIdGenerator<UUID> uniqueIdGenerator() {
			return new InMemoryUniqueIdGenerator();
		}

	}

}