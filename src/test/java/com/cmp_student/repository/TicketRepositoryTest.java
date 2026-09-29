package com.cmp_student.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.cmp_student.entity.Ticket;

@DataJpaTest
@Testcontainers(disabledWithoutDocker = true)
class TicketRepositoryTest {

    @Container
    static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

    @DynamicPropertySource
    static void configurePostgres(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    void persistsTicketsAndSupportsCrudAndNameSearch() {
        Ticket saved = ticketRepository.save(new Ticket("Support ticket"));

        assertThat(ticketRepository.findById(saved.getId())).isPresent();
        assertThat(ticketRepository.findAll()).extracting(Ticket::getName).containsExactly("Support ticket");
        assertThat(ticketRepository.findByNameContainingIgnoreCase("SUPPORT"))
                .extracting(Ticket::getName).containsExactly("Support ticket");

        ticketRepository.deleteById(saved.getId());
        assertThat(ticketRepository.findById(saved.getId())).isEmpty();
    }
}