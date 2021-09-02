package com.sahil.movieBookingSystem.dao;

import com.sahil.movieBookingSystem.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusDao extends JpaRepository<Status, Integer> {
//    public Optional<Status> findStatusByName(String statusName);
    public Status findByStatusName(String statusName);

}
