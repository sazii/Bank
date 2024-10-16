package LCProblems.design.bank.service;

import LCProblems.design.bank.data.model.AccTransactionPair;
import LCProblems.design.bank.data.model.Transfer;

import java.util.HashMap;
import java.util.Map;

public class TransferServiceImpl implements TransferService{

    Map<String, Transfer> transferMap;

    public TransferServiceImpl(){
        transferMap = new HashMap<>();
    }
    @Override
    public Transfer createTransfer(String acc1, String acc2, Long amount, String transactionInId, String transactionOutId) {
        Transfer transfer = new Transfer(new AccTransactionPair(acc1,transactionOutId),
                new AccTransactionPair(acc2, transactionInId),
                amount
        );
        transferMap.put(transfer.getTransferId(), transfer);
        return transfer;
    }
}
