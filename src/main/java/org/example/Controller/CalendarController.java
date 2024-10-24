package org.example.Controller;

import org.example.Modal.Calendar;
import org.example.Service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Calendar")
public class CalendarController {
    @Autowired
    private CalendarService calendarService;
    @GetMapping("/Calendars")
    public List<Calendar> listCalendar(){
        List<Calendar> calendars = calendarService.getAllCalendar();
        return calendars;
    }
    @PostMapping("/Calendars")
    public ResponseEntity<Calendar> createCalendar(@RequestBody Calendar calendar){
        Calendar newCalendar = calendarService.createNewCalendar(calendar);
        return new ResponseEntity<>(newCalendar, HttpStatus.CREATED);
    }
    @GetMapping("/Calendars/{tourId}")
    public List<Calendar> listCalendarByTourId(@PathVariable("tourId") String id){
        List<Calendar> calendarsbyTourId = calendarService.findCalendarbyTour(id);
        return calendarsbyTourId;
    }


}
