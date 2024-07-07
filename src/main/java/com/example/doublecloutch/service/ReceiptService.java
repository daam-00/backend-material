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
        // Imposta la data corrente se non è già impostata
        if (receipt.getDate() == null) {
            receipt.setDate(new Date());
        }

        // Imposta la quantità predefinita se non è specificata
        if (receipt.getQuantity() == 0) {
            receipt.setQuantity(1); // Valore predefinito
        }

        // Calcola e imposta il prezzo totale
        receipt.setTotalPrice(receipt.getUnitPrice() * receipt.getQuantity());

        // Imposta i valori predefiniti per i campi aggiuntivi
        setDefaultValuesForAdditionalPayments(receipt);

        return receiptRepository.save(receipt);
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

            // Aggiorna i valori dei campi aggiuntivi
            receipt.setAmount2(updatedReceipt.getAmount2() != null ? updatedReceipt.getAmount2() : 0.0);
            receipt.setDueDate2(updatedReceipt.getDueDate2());
            receipt.setPaymentType2(updatedReceipt.getPaymentType2());
            receipt.setAmount3(updatedReceipt.getAmount3() != null ? updatedReceipt.getAmount3() : 0.0);
            receipt.setDueDate3(updatedReceipt.getDueDate3());
            receipt.setPaymentType3(updatedReceipt.getPaymentType3());
            receipt.setAmount4(updatedReceipt.getAmount4() != null ? updatedReceipt.getAmount4() : 0.0);
            receipt.setDueDate4(updatedReceipt.getDueDate4());
            receipt.setPaymentType4(updatedReceipt.getPaymentType4());
            receipt.setAmount5(updatedReceipt.getAmount5() != null ? updatedReceipt.getAmount5() : 0.0);
            receipt.setDueDate5(updatedReceipt.getDueDate5());
            receipt.setPaymentType5(updatedReceipt.getPaymentType5());

            return receiptRepository.save(receipt);
        }
        return null;
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

    // Metodo privato per impostare i valori predefiniti per i pagamenti addizionali
    private void setDefaultValuesForAdditionalPayments(Receipt receipt) {
        // Se il campo amount2 non è specificato, imposta il valore predefinito a 0.0
        if (receipt.getAmount2() == null) {
            receipt.setAmount2(0.0);
        }
        // Imposta eventuali altri valori predefiniti per amount3, amount4, amount5 qui
        if (receipt.getAmount3() == null) {
            receipt.setAmount3(0.0);
        }
        if (receipt.getAmount4() == null) {
            receipt.setAmount4(0.0);
        }
        if (receipt.getAmount5() == null) {
            receipt.setAmount5(0.0);
        }

        // Imposta eventuali valori predefiniti per le date e i tipi di pagamento aggiuntivi
        if (receipt.getDueDate2() == null) {
            receipt.setDueDate2(new Date());
        }
        // Imposta eventuali altre date predefinite per dueDate3, dueDate4, dueDate5 qui
        if (receipt.getDueDate3() == null) {
            receipt.setDueDate3(new Date());
        }
        if (receipt.getDueDate4() == null) {
            receipt.setDueDate4(new Date());
        }
        if (receipt.getDueDate5() == null) {
            receipt.setDueDate5(new Date());
        }
    }
}
