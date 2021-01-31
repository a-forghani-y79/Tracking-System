package com.moon.trackingsystem.models.ticket;

import com.moon.trackingsystem.models.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {


}
