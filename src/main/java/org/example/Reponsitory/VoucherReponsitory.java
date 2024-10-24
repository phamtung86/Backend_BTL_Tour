package org.example.Reponsitory;

import org.example.Modal.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherReponsitory extends JpaRepository<Voucher, Integer> {
}
