package com.example.demo.Transaction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BankAccountController {

    private final TransferCommandHandler transferCommandHandler;

    public BankAccountController(TransferCommandHandler transferCommandHandler) {
        this.transferCommandHandler = transferCommandHandler;
    }

    @PostMapping("/transaction")
    public ResponseEntity transfer(@RequestBody TransferDto transferDto) {
        return transferCommandHandler.transfer(transferDto);
    }




}
