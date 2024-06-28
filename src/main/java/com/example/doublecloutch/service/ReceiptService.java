package com.example.doublecloutch.service;

import com.example.doublecloutch.entity.Receipt;
import com.example.doublecloutch.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    public List<Receipt> findAllReceipts() {
        return receiptRepository.findAll();
    }

    public Receipt saveReceipt(Receipt receipt) {
        if (receipt.getQuantity() == 0) {
            receipt.setQuantity(1); // Valore predefinito
        }
        receipt.setTotalPrice(receipt.getUnitPrice() * receipt.getQuantity());
        receipt.setDate(new Date());
        return receiptRepository.save(receipt);
    }

    public void deleteReceipt(Long id) {
        receiptRepository.deleteById(id);
    }

    public Receipt getReceiptById(Long id) {
        return receiptRepository.findById(id).orElse(null);
    }
}
