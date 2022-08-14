package com.ticketdrafter.security.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.ticketdrafter.security.models.ERole;
import com.ticketdrafter.security.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
