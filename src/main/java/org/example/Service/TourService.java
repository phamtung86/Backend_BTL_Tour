package org.example.Service;

import org.example.Modal.Tour;
import org.example.Reponsitory.TourReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TourService {
    @Autowired
    private TourReponsitory tourReponsitory;
    public List<Tour> getAllTours() {
        return tourReponsitory.findAll();
    }

    // add tour
    public Tour createNewTour(Tour tour) {
        return tourReponsitory.save(tour);
    }

    // delete Tour By ID
    public boolean deleteTourById(String id) {
        if (tourReponsitory.existsById(id)) {
            tourReponsitory.deleteById(id);
            return true; // Trả về true nếu xóa thành công
        }
        return false; // Trả về false nếu không tìm thấy tour
    }

    // update tour by id
    public Tour updateTour(String id, Tour tourDetails) {
            Optional<Tour> optionalTour = tourReponsitory.findById(id);
            if(optionalTour.isPresent()) {
                Tour existingTour = optionalTour.get();
                existingTour.setName(tourDetails.getName());
                existingTour.setPrice(tourDetails.getPrice());
                existingTour.setImageLink(tourDetails.getImageLink());
                existingTour.setFileName(tourDetails.getFileName());
                existingTour.setDestination(tourDetails.getDestination());
                existingTour.setDeparturePoint(tourDetails.getDeparturePoint());
                existingTour.setSlot(tourDetails.getSlot());
                existingTour.setTransportId(tourDetails.getTransportId());
                existingTour.setTourTypeId(tourDetails.getTourTypeId());
                return tourReponsitory.save(existingTour);
            }else {
                System.out.println("Tour not found with id " + id);
                return null;
            }
    }

}
