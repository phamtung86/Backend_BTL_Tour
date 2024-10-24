package org.example.Controller;

import org.example.Modal.Voucher;
import org.example.Service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Voucher")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;
    @GetMapping("/ListAllVoucher")
    public List<Voucher> getAllVoucher() {
        return voucherService.listAllVoucher();
    }

    @GetMapping("/VoucherById/{id}")
    public Voucher getVoucherById(@PathVariable int id) {
        Optional<Voucher> isExists = voucherService.findVoucherById(id);
        if (isExists.isPresent()) {
            return isExists.get();
        }
        return null;
    }

    @PostMapping("/AddNewVoucher")
    public boolean addNewVoucher(@RequestBody Voucher voucher) {
        Voucher newVoucher = voucherService.createVoucher(voucher);
        if (newVoucher != null) {
            return true;
        }
        return false;
    }

    // update voucher

    @PutMapping("/UpdateVoucher/{id}")
    public boolean updateVoucher(@PathVariable int id, @RequestBody Voucher voucher) {
        Optional<Voucher> isExists = voucherService.findVoucherById(id);
        if (isExists.isPresent()) {
            voucherService.updateVoucher(id, voucher);
            return true;
        }
        return false;
    }

    @DeleteMapping("DeleteVoucher/{id}")
    public boolean deleteVoucher(@PathVariable int id) {
        Optional<Voucher> isExists = voucherService.findVoucherById(id);
        if (isExists.isPresent()) {
            voucherService.deleteVoucher(id);
            return true;
        }
        return false;
    }
}
