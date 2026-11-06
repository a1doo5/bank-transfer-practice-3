import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("ACC001", "Aida", 50000);
        BankAccount account2 = new BankAccount("ACC002", "Dana", 10000);
        TransferService service = new TransferService();

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите сумму перевода: ");
            double amount = Double.parseDouble(scanner.nextLine().trim());
            service.transfer(account1, account2, amount);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода числа: введите число, а не текст");
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректная сумма или данные: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Операция перевода завершена");
            scanner.close();
        }

        System.out.printf("Баланс %s (%s): %.2f%n",
                account1.getAccountNumber(), account1.getOwner(), account1.getBalance());
        System.out.printf("Баланс %s (%s): %.2f%n",
                account2.getAccountNumber(), account2.getOwner(), account2.getBalance());
    }
}
