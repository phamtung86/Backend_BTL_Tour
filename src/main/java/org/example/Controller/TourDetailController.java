package org.example.Controller;

import org.example.Modal.TourDetail;
import org.example.Service.TourDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/TourDetail")
public class TourDetailController {
    @Autowired
    private TourDetailService tourDetailService;

    @GetMapping("/TourDetails")
    public ResponseEntity<List<TourDetail>> listTourDetail() {
        List<TourDetail> tourDetails = tourDetailService.getAllTourDetail();
        return new ResponseEntity<>(tourDetails, HttpStatus.OK);
    }

    @GetMapping("/TourDetails/{tourId}")
    public ResponseEntity<TourDetail> tourDetailById(@PathVariable String tourId) {
        TourDetail tourDetail = tourDetailService.findTourDetailByTourId(tourId);
        if (tourDetail == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tourDetail, HttpStatus.OK);
    }

    @PostMapping("/TourDetails") // Thêm dấu /
    public ResponseEntity<TourDetail> addNewTourDetail(@RequestBody TourDetail tourDetail) {
        TourDetail newTourDetail = tourDetailService.createNewTourDetail(tourDetail);
        return new ResponseEntity<>(newTourDetail, HttpStatus.CREATED);
    }
    @DeleteMapping("/TourDetails/{id}")
    public ResponseEntity<Void> deleteTourDetail(@PathVariable("id") int id){
        boolean isDeleted = tourDetailService.deleteTourDetail(id);
        if(isDeleted){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();

        }

    }
    @PostMapping("/updateTourDetail/{id}")
    public ResponseEntity<TourDetail> updateTourDetail(@PathVariable("id") int id, TourDetail tourDetailupdate){
        TourDetail updateTourDetail = tourDetailService.updateTour(id,tourDetailupdate);
        return ResponseEntity.ok(updateTourDetail);
    }

}
