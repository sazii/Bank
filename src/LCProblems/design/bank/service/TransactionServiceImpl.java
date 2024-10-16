package LCProblems.design.bank.service;

import LCProblems.design.bank.data.enums.TransactionDirectionEnum;
import LCProblems.design.bank.data.enums.TransactionType;
import LCProblems.design.bank.data.model.BankAccount;
import LCProblems.design.bank.data.model.Transaction;

import java.util.*;

public class TransactionServiceImpl implements TransactionService{

    Map<String, Transaction> transactionMap;

    public TransactionServiceImpl(){
        this.transactionMap = new HashMap<>();
    }
    @Override
    public Transaction createTransaction(TransactionType transactionType, Long amount, String acc) {
        return null;
    }

    @Override
    public void addTransaction(Transaction transaction, BankAccount bankAccount){
        if(transaction.getDirection().equals(TransactionDirectionEnum.IN)){
            addInTransaction(transaction, bankAccount);
        } else {
            addOutTransaction(transaction, bankAccount);
        }
        transactionMap.put(transaction.getTransactionId(), transaction);
    }

    public void addOutTransaction(Transaction transaction, BankAccount bankAccount){
        bankAccount.setCurBalance(bankAccount.getCurBalance() - transaction.getAmount());
        bankAccount.updateMaps(transaction);
    }

    public void  addInTransaction(Transaction transaction, BankAccount bankAccount){
        bankAccount.setCurBalance(bankAccount.getCurBalance() + transaction.getAmount());
        bankAccount.updateMaps(transaction);
    }


    @Override
    public Set<Transaction> findTopKMost(int k) {
        Set<Transaction> top5Most =  new HashSet<>();
        PriorityQueue<Transaction> pq = new PriorityQueue<>((tr1, tr2) -> Math.toIntExact(tr1.getAmount() - tr2.getAmount()));
        for(Transaction transaction: transactionMap.values()){
            if(pq.size() < k){
                pq.add(transaction);
            } else if(pq.peek().getAmount() < transaction.getAmount()){
                pq.poll();
                pq.add(transaction);
            }
        }
        while(!pq.isEmpty()){
            top5Most.add(pq.poll());
        }
        return top5Most;
    }
}
