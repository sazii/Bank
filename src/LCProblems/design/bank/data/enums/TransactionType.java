package LCProblems.design.bank.data.enums;

public enum TransactionType {
    WITHDRAWAL("WITH-", TransactionDirectionEnum.OUT),
    DEPOSIT("DEP-", TransactionDirectionEnum.IN),
    CASHBACK("CB-", TransactionDirectionEnum.IN),
    TRANSFER_IN("TRIN-", TransactionDirectionEnum.IN),
    TRANSFER_OUT("TROUT-", TransactionDirectionEnum.OUT);
    String prefixId;
    TransactionDirectionEnum direction;

    TransactionType(String prefixId, TransactionDirectionEnum direction){
        this.prefixId = prefixId;
        this.direction = direction;
    }

    public String getPrefixId() {
        return prefixId;
    }

    public void setDirection(TransactionDirectionEnum direction) {
        this.direction = direction;
    }

    public TransactionDirectionEnum getDirection() {
        return direction;
    }
}
