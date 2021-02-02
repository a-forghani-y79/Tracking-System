package com.moon.trackingsystem.models.token;

import com.moon.trackingsystem.models.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

    Token findByCode(String code);
}