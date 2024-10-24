package org.example.Reponsitory;

import org.example.Modal.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourReponsitory extends JpaRepository<Tour, String> {

}
