package com.example.doublecloutch.repository;

import com.example.doublecloutch.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    @Query("SELECT MAX(r.receiptNumber) FROM Receipt r")
    Integer findMaxReceiptNumber();
}
