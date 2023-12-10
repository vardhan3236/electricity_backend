package com.electricity.connectionservice.repository;

import com.electricity.connectionservice.model.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ConnectionRepository extends JpaRepository<Connection, Long> {

    @Query("SELECT c FROM Connection c WHERE c.dateOfApplication BETWEEN :startDate AND :endDate")
    List<Connection> findByDateOfApplicationBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    Optional<Connection> findByIdNumber(String applicationId);

}
