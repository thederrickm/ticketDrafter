package com.ticketdrafter.schedule.nhl;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface ScheduleRepository extends MongoRepository<NHLDraftSchedule, String> {

}