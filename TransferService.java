public class TransferService {
    public void transfer(BankAccount from, BankAccount to, double amount)
            throws InsufficientFundsException {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Один из счетов не существует");
        }
        if (from.getAccountNumber().equals(to.getAccountNumber())) {
            throw new IllegalArgumentException("Нельзя переводить деньги на тот же счет");
        }
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("Сумма перевода должна быть больше нуля");
        }
        if (!Double.isFinite(to.getBalance() + amount)) {
            throw new IllegalArgumentException("Слишком большая сумма перевода");
        }

        from.withdraw(amount);
        to.deposit(amount);

        System.out.println("Перевод выполнен успешно");
    }
}
