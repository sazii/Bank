package LCProblems.design.bank.service;

import LCProblems.design.bank.data.enums.TransactionDirectionEnum;
import LCProblems.design.bank.data.enums.TransactionType;
import LCProblems.design.bank.data.model.BankAccount;
import LCProblems.design.bank.data.model.Transaction;

import java.util.PriorityQueue;
import java.util.Set;

public interface TransactionService {
    Transaction createTransaction(TransactionType transactionType, Long amount, String acc);
    void addTransaction(Transaction transaction, BankAccount bankAccount);

    Set<Transaction> findTopKMost(int k);
}
