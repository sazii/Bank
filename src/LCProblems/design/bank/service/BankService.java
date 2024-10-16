package LCProblems.design.bank.service;

import java.util.Set;

public interface BankService {
    boolean transfer(String acc1, String acc2, long money) throws Exception;
    boolean withdraw(String acc, long money) throws Exception;
    boolean deposit(String acc, long money) throws Exception;
    Set<String> findTopKMost();


}
