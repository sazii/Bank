package LCProblems.design.bank.data.model;

import LCProblems.design.bank.data.enums.TransactionDirectionEnum;
import LCProblems.design.bank.data.enums.TransactionType;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    String transactionId;

    String accId;
    TransactionDirectionEnum direction;
    TransactionType transactionType;
    Long amount;
    LocalDateTime transactionDate;

    String transferId;

    public String produceId (){
        return this.transactionType.getPrefixId() + UUID.randomUUID();
    }

    public Transaction( TransactionType transactionType,  Long amount, String accId ){
        this.transactionType = transactionType;
        this.accId = accId;
        this.direction = transactionType.getDirection();
        this.amount = amount;
        this.transactionId = transactionType.getPrefixId() + UUID.randomUUID();
        this.transactionDate = LocalDateTime.now();
    }

    public void setTransferId(String transferId) {
        this.transferId = transferId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public TransactionDirectionEnum getDirection() {
        return direction;
    }

    public Long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "{" + "transactionId : " + transactionId + "\n" + "transactionType :" + transactionType + "\ndirection : " + direction
                + "\naccId: " + accId + "\namount :" + amount + "\ntransactionDate : " + transactionDate + "\ntransferId : " + transferId + "}\n";
    }
}
