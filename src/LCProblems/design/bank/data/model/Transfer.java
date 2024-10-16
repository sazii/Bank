package LCProblems.design.bank.data.model;

import java.util.UUID;

public class Transfer {
    String transferId;
    AccTransactionPair source;
    AccTransactionPair destination;
    Long amount;

    String produceId(){
        return "TR-" + UUID.randomUUID();
    }

    public  Transfer(AccTransactionPair source, AccTransactionPair destination, Long amount){
        this.transferId = produceId();
        this.source = source;
        this.destination = destination;
        this.amount = amount;
    }

    public String getTransferId() {
        return transferId;
    }
}
