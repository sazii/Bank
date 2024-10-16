package LCProblems.design.bank.data.model;

public class AccTransactionPair {
    String accId;
    String transactionId;

    public AccTransactionPair(String accId , String transactionId){
        this.accId = accId;
        this.transactionId = transactionId;
    }
}
