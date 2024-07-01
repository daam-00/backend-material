package com.example.doublecloutch.controller;

import com.example.doublecloutch.dto.ReceiptDTO;
import com.example.doublecloutch.entity.Receipt;
import com.example.doublecloutch.service.MaterialService;
import com.example.doublecloutch.service.ReceiptService;
import com.example.doublecloutch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @Autowired
    private UserService userService;

    @Autowired
    private MaterialService materialService;

    @GetMapping
    public List<ReceiptDTO> getAllReceipts() {
        return receiptService.findAllReceipts().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ReceiptDTO createReceipt(@RequestBody ReceiptDTO receiptDTO) {
        Receipt receipt = convertToEntity(receiptDTO);
        return convertToDTO(receiptService.saveReceipt(receipt));
    }

    @PutMapping("/{id}")
    public ReceiptDTO updateReceipt(@PathVariable Long id, @RequestBody ReceiptDTO receiptDTO) {
        Receipt receipt = convertToEntity(receiptDTO);
        return convertToDTO(receiptService.updateReceipt(id, receipt));
    }

    @DeleteMapping("/{id}")
    public void deleteReceipt(@PathVariable Long id) {
        receiptService.deleteReceipt(id);
    }

    @GetMapping("/{id}")
    public ReceiptDTO getReceiptById(@PathVariable Long id) {
        return convertToDTO(receiptService.getReceiptById(id));
    }

    @GetMapping("/last-receipt-number")
    public int getLastReceiptNumber() {
        return receiptService.getLastReceiptNumber();
    }

    private ReceiptDTO convertToDTO(Receipt receipt) {
        ReceiptDTO dto = new ReceiptDTO();
        dto.setId(receipt.getId());
        dto.setUser(receipt.getUser());
        dto.setMaterial(receipt.getMaterial());
        dto.setDescription(receipt.getDescription());
        dto.setUnitPrice(receipt.getUnitPrice());
        dto.setQuantity(receipt.getQuantity());
        dto.setTotalPrice(receipt.getTotalPrice());
        dto.setReceiptNumber(receipt.getReceiptNumber());
        dto.setPaymentType(receipt.getPaymentType());
        dto.setDate(receipt.getDate());
        dto.setAmount(receipt.getAmount());
        dto.setDueDate(receipt.getDueDate());
        return dto;
    }

    private Receipt convertToEntity(ReceiptDTO dto) {
        Receipt receipt = new Receipt();
        receipt.setId(dto.getId());
        if (dto.getUser() != null && dto.getUser().getId() != null) {
            receipt.setUser(userService.findById(dto.getUser().getId()).orElse(null));
        }
        if (dto.getMaterial() != null && dto.getMaterial().getId() != null) {
            receipt.setMaterial(materialService.findById(dto.getMaterial().getId()).orElse(null));
        }
        receipt.setDescription(dto.getDescription());
        receipt.setUnitPrice(dto.getUnitPrice());
        receipt.setQuantity(dto.getQuantity());
        receipt.setTotalPrice(dto.getTotalPrice());
        receipt.setReceiptNumber(dto.getReceiptNumber());
        receipt.setPaymentType(dto.getPaymentType());
        receipt.setDate(dto.getDate());
        receipt.setAmount(dto.getAmount());
        receipt.setDueDate(dto.getDueDate());
        return receipt;
    }
}
