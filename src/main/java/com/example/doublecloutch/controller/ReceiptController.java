package com.example.doublecloutch.controller;

import com.example.doublecloutch.dto.ReceiptDTO;
import com.example.doublecloutch.entity.Material;
import com.example.doublecloutch.entity.Receipt;
import com.example.doublecloutch.entity.User;
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

    @DeleteMapping("/{id}")
    public void deleteReceipt(@PathVariable Long id) {
        receiptService.deleteReceipt(id);
    }

    @GetMapping("/{id}")
    public ReceiptDTO getReceiptById(@PathVariable Long id) {
        return convertToDTO(receiptService.getReceiptById(id));
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
        return receipt;
    }
}
