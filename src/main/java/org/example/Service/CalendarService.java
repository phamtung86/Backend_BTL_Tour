package org.example.Service;

import org.example.Modal.Calendar;
import org.example.Reponsitory.CalendarReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarService {
    @Autowired
    private CalendarReponsitory calendarReponsitory;
    //getAll
    public List<Calendar> getAllCalendar(){
        return  calendarReponsitory.findAll();
    }
    //CreateCalendarService
    public Calendar createNewCalendar(Calendar calendar){
        return calendarReponsitory.save(calendar);

    }
    //FindCalendarbyTourId
    public List<Calendar> findCalendarbyTour( String tourID){
        List<Calendar> calendars = new ArrayList<>();
        for(Calendar calendar : getAllCalendar()) {
            if(calendar.getTourId().equals(tourID)) {
                calendars.add(calendar);
            }

        }
        return calendars;
    }


}
