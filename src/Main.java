import LCProblems.design.bank.service.*;

public class Main {
    public static void main(String[] args) throws Exception {
        TransferService  transferService = new TransferServiceImpl();
        TransactionService transactionService = new TransactionServiceImpl();
        BankServiceImpl bankService = new BankServiceImpl(transferService, transactionService);
        bankService.deposit("1", 20);
        bankService.deposit("1", 20);
        bankService.withdraw("1", 10);
        bankService.transfer("1", "2", 30);
        bankService.deposit("5",60 );
        System.out.println(bankService.getBankAccountMap().get("1").getBalanceMap());
        System.out.println(transactionService.findTopKMost(2));

        System.out.println("Hello world!");
    }
}