package com.br.oraculo.repository;

import com.br.oraculo.domain.Ticket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long>{

    public List<Ticket> findAll();
}
