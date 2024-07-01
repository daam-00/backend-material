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

    public int getLastReceiptNumber() {
        Integer lastReceiptNumber = receiptRepository.findMaxReceiptNumber();
        return lastReceiptNumber != null ? lastReceiptNumber : 0;
    }

    public Receipt updateReceipt(Long id, Receipt updatedReceipt) {
        Receipt receipt = getReceiptById(id);
        if (receipt != null) {
            receipt.setUser(updatedReceipt.getUser());
            receipt.setMaterial(updatedReceipt.getMaterial());
            receipt.setDescription(updatedReceipt.getDescription());
            receipt.setUnitPrice(updatedReceipt.getUnitPrice());
            receipt.setQuantity(updatedReceipt.getQuantity());
            receipt.setTotalPrice(updatedReceipt.getUnitPrice() * updatedReceipt.getQuantity());
            receipt.setReceiptNumber(updatedReceipt.getReceiptNumber());
            receipt.setPaymentType(updatedReceipt.getPaymentType());
            receipt.setDate(new Date());
            receipt.setAmount(updatedReceipt.getAmount());
            receipt.setDueDate(updatedReceipt.getDueDate());
            return receiptRepository.save(receipt);
        }
        return null;
    }
}
