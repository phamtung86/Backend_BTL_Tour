package org.example.Service;

import org.example.Modal.Tour;
import org.example.Modal.TourDetail;
import org.example.Reponsitory.TourDetailReponsitory;
import org.example.Reponsitory.TourDetailReponsitory; // Đổi tên
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourDetailService {
    @Autowired
    private TourDetailReponsitory tourDetailRepository; // Đổi tên

    public List<TourDetail> getAllTourDetail() {
        return tourDetailRepository.findAll();
    }

    // Xem theo id_tour
    public TourDetail findTourDetailByTourId(String tourId) {
        TourDetail tourDetail = tourDetailRepository.findTourDetailByTourId(tourId);
        if (tourDetail == null) {
            // Xử lý khi không tìm thấy tourDetail
            throw new RuntimeException("TourDetail not found for ID: " + tourId);
        }
        return tourDetail;
    }

    // Add tour_detail
    public TourDetail createNewTourDetail(TourDetail tourDetail) {
        return tourDetailRepository.save(tourDetail);
    }

    // Delete TourDetail by ID
    public boolean deleteTourDetail(int id) {
        if (tourDetailRepository.existsById(id)) {
            tourDetailRepository.deleteById(id);
            return true;
        }
        return false; // Có thể thêm thông điệp ở đây nếu cần
    }
    // update tour_detail
    public TourDetail updateTour(int id, TourDetail tourdetailt_update ){
        Optional<TourDetail> optionalTourDetail = tourDetailRepository.findById(id);
        if(optionalTourDetail.isPresent()){
            TourDetail existingTourDetail = optionalTourDetail.get();
            existingTourDetail.setFile_name(tourdetailt_update.getFile_name());
            existingTourDetail.setUrl(tourdetailt_update.getUrl());
            existingTourDetail.setSightseeing(tourdetailt_update.getSightseeing());
            existingTourDetail.setCuisine(tourdetailt_update.getCuisine());
            existingTourDetail.setSuitable_people(tourdetailt_update.getSuitable_people());
            existingTourDetail.setTime_suitable(tourdetailt_update.getTime_suitable());
            existingTourDetail.setTransport(tourdetailt_update.getTransport());
            existingTourDetail.setSale_description(tourdetailt_update.getSale_description());
            existingTourDetail.setTour_id(tourdetailt_update.getTour_id());
            return tourDetailRepository.save(existingTourDetail);

        } else{
            System.out.println("TourDetail not found with Id" + id);
            return null;
        }
    }
}
