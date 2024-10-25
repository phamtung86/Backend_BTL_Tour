package org.example.Reponsitory;

import org.example.Modal.TourDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TourDetailReponsitory extends JpaRepository<TourDetail, Integer> {
    @Query("SELECT td FROM TourDetail td WHERE td.tour_id = :idParam")
    TourDetail findTourDetailByTourId(@Param("idParam") String idParam);
}

