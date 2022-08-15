package com.ticketdrafter;

import com.ticketdrafter.schedule.nhl.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
public class TicketDrafterApplication {


    public static void main(String[] args) {
        SpringApplication.run(TicketDrafterApplication.class, args);
    }



}


