package com.example.demo.Transaction;


import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferCommandHandler {

    private final BankAccountRepository bankAccountRepository;

    public TransferCommandHandler(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public ResponseEntity transfer(TransferDto transferDto) {
        Optional<BankAccount> fromAccount = bankAccountRepository.findById(Integer.valueOf(transferDto.getToUser()));
        Optional<BankAccount> toAccount = bankAccountRepository.findById(Integer.valueOf(transferDto.getFromUser()));

        if(fromAccount.isEmpty() || toAccount.isEmpty()) {
            throw new RuntimeException("khong co to and from user in bank transaction");
        }
        BankAccount from = fromAccount.get();
        BankAccount to = toAccount.get();
        add(to, (int) transferDto.getAmount());
        deduct(from, (int) transferDto.getAmount());
        return ResponseEntity.ok("success transaction");
    }


    private void deduct(BankAccount bankAccount, Integer amount) {
        if(bankAccount.getBalance() < amount) {
            throw new RuntimeException("so tuong rut ra lon hon so luong duoc giu trong ngan hang");
        }

        bankAccount.setBalance(bankAccount.getBalance() - amount);
    }

    private void add(BankAccount bankAccount, Integer amount) {
        bankAccount.setBalance(bankAccount.getBalance() + amount);
    }

}
