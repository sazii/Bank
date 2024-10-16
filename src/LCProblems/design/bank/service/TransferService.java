package LCProblems.design.bank.service;

import LCProblems.design.bank.data.model.Transfer;

public interface TransferService {
    Transfer createTransfer(String acc1, String acc2, Long amount, String transactionInId, String TransactionOutId);
}
