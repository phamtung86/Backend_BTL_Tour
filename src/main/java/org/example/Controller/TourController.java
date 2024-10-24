package org.example.Controller;

import org.example.Modal.Tour;
import org.example.Service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Tour")
public class TourController {

    @Autowired
    private TourService tourService;

    // get all tour
    @GetMapping("/ListAllTours")
    public List<Tour> listAllTours() {
        return tourService.getAllTours();
    }

    // add tour
    @PostMapping("/addNewTour")
    public Tour addNewTour(@RequestBody Tour tour) {
        Tour newTour = tourService.createNewTour(tour);
        return new ResponseEntity<>(newTour, HttpStatus.CREATED).getBody();
    }

    // delete tour by id
    @DeleteMapping("/deleteTour/{id}")
    public ResponseEntity<Void> deleteTour(@PathVariable("id") String id) {
        boolean isDeleted = tourService.deleteTourById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
    // update tour by id
    @PutMapping("/updateTour/{id}")
    public ResponseEntity<Tour> updateTour(@PathVariable("id") String id, @RequestBody Tour tourUpdate) {
        Tour updatedTour = tourService.updateTour(id, tourUpdate);
        return ResponseEntity.ok(updatedTour);
    }

}

