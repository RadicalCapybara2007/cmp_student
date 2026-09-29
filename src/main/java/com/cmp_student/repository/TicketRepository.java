package com.cmp_student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmp_student.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByNameContainingIgnoreCase(String name);
}