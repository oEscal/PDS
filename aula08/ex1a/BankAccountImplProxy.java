package aula08.ex1a;

public class BankAccountImplProxy implements BankAccount {

    private BankAccount real_bank_account;

    public BankAccountImplProxy (BankAccount real_bank_account) {

        this.real_bank_account = real_bank_account;
    }

    @Override
    public void deposit(double amount) {

        this.real_bank_account.deposit(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        throw new UnsupportedOperationException("Access denied to withdraw!");
    }

    @Override
    public double balance() {
        throw new UnsupportedOperationException("Access denied to balance!");
    }
}
