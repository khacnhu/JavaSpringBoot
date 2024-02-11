package com.example.demo.Transaction;

import lombok.Data;

@Data
public class TransferDto {

    private String fromUser;
    private String toUser;
    private double amount;


}
