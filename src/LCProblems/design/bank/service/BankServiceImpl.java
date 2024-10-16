package LCProblems.design.bank.service;

import LCProblems.design.bank.data.enums.TransactionType;
import LCProblems.design.bank.data.model.BankAccount;
import LCProblems.design.bank.data.model.Transaction;
import LCProblems.design.bank.data.model.Transfer;

import java.util.*;

public class BankServiceImpl implements BankService{
    Map<String, BankAccount> bankAccountMap;

    private final TransferService transferService;

    private final TransactionService transactionService;

    public BankServiceImpl(TransferService transferService, TransactionService transactionService){
        this.transferService = transferService;
        this.transactionService = transactionService;
        fillBankAccMap();
    }

    public Map<String, BankAccount> getBankAccountMap() {
        return bankAccountMap;
    }

    private void fillBankAccMap() {
        this.bankAccountMap = new HashMap<>();
        for(int i=0; i<100; i++){
            String accId = String.valueOf(i);
            bankAccountMap.put(accId, new BankAccount(accId));
        }
    }

    @Override
    public boolean transfer(String acc1, String acc2, long money) throws Exception {
        if(isAccExists(acc2) && isAccExists(acc1)){
            BankAccount account1 = bankAccountMap.get(acc1);
            if(account1.isSufficient(money)){
                Transaction outTransferTransaction = new Transaction(TransactionType.TRANSFER_OUT, money, acc1);
                Transaction inTransferTransaction = new Transaction(TransactionType.TRANSFER_IN, money, acc2);
                Transfer transfer = transferService.createTransfer(acc1,acc2,money,
                        inTransferTransaction.getTransactionId(),
                        outTransferTransaction.getTransactionId());
                inTransferTransaction.setTransferId(transfer.getTransferId());
                outTransferTransaction.setTransferId(transfer.getTransferId());
                transactionService.addTransaction(outTransferTransaction, account1);
                BankAccount account2 = bankAccountMap.get(acc2);
                transactionService.addTransaction(inTransferTransaction, account2);
            }

        }
        return true;
    }

    @Override
    public boolean withdraw(String acc, long money) throws Exception{
        if(isAccExists(acc)){
            BankAccount account = bankAccountMap.get(acc);
            if(account.isSufficient(money)){
                Transaction transaction = new Transaction(TransactionType.WITHDRAWAL, money, acc);
                transactionService.addTransaction(transaction, account);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean deposit(String acc, long money) throws Exception {
        if(isAccExists(acc)){
            BankAccount account = bankAccountMap.get(acc);
            transactionService.addTransaction(new Transaction(TransactionType.DEPOSIT, money, acc), account);
            return true;
        }
        return false;
    }

    @Override
    public Set<String> findTopKMost() {

        return null;
    }

    private boolean isAccExists(String acc1) throws Exception{
        if(!bankAccountMap.containsKey(acc1)){
            throw  new Exception("there is no account like "+ acc1);
        }
        return true;
    }
}
