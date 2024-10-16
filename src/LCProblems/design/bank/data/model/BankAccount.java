package LCProblems.design.bank.data.model;

import LCProblems.design.bank.data.enums.TransactionType;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class BankAccount {
    String accId;
    Long curBalance;
    LocalDateTime openDate;
    Map<LocalDateTime, Long> balanceMap;
    Map<String, Transaction> transactionMap;

    public BankAccount(){
        this.accId = "BA-" + UUID.randomUUID();
        this.curBalance = 0L;
        this.openDate = LocalDateTime.now();
        this.balanceMap = new HashMap<>();
        balanceMap.put(openDate, curBalance);
        this.transactionMap = new HashMap<>();
        addOpenTransaction();
    }

    public BankAccount(String accId){
        this.accId = accId;
        this.curBalance = 0L;
        this.openDate = LocalDateTime.now();
        this.balanceMap = new HashMap<>();
        balanceMap.put(openDate, curBalance);
        this.transactionMap = new HashMap<>();
        addOpenTransaction();
    }

    public BankAccount(String accId, Long amount){
        this.accId = accId;
        this.openDate = LocalDateTime.now();
        this.curBalance = amount;
        this.balanceMap = new HashMap<>();
        balanceMap.put(openDate, curBalance);
        this.transactionMap = new HashMap<>();
        addOpenTransaction();

    }

    public String getAccId() {
        return accId;
    }

    public void setCurBalance(Long curBalance) {
        this.curBalance = curBalance;
    }

    public Long getCurBalance() {
        return curBalance;
    }

    public void addOpenTransaction(){
        Transaction  transaction = new Transaction(TransactionType.DEPOSIT, curBalance, accId);
        this.transactionMap.put(transaction.getTransactionId(), transaction);
    }


    public void updateMaps(Transaction transaction) {
        transactionMap.put(transaction.getTransactionId(), transaction);
        balanceMap.put(transaction.transactionDate, curBalance);
    }

    public boolean isSufficient(Long money) throws Exception{
        if(money > this.curBalance){
            throw new Exception("insufficient funds");
        }
        return true;
    }

    @Override
    public String toString() {
        return "curBalance :" + curBalance + "accId : " + accId + "openDate : "+ openDate + "balanceMap : "
                + balanceMap + " transactionMap : " + transactionMap ;
    }

    public Map<String, Transaction> getTransactionMap() {
        return transactionMap;
    }

    public Map<LocalDateTime, Long> getBalanceMap() {
        return balanceMap;
    }
}
