package org.example.Reponsitory;

import org.example.Modal.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarReponsitory extends JpaRepository<Calendar,Integer> {

}
