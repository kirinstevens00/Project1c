import java.util.ArrayList;
import java.util.Date;


public class NewAccount<Transaction> {

    public static void main(String[] args) {
        Account account = new Account("George", 1122, 1000);
        account.setAnnualInterestRate(1.5);
        account.deposit(30);
        account.deposit(40);
        account.deposit(50);
        account.withdraw(5);
        account.withdraw(4);
        account.withdraw(2);
        System.out.println(account);
    }

    class Account {
        private String name;
        private int ID;
        private double balance;
        private double AnnualInterestRate; // AnnualInterestRate is percentage.
        private java.util.Date DateCreated;
        private ArrayList<Transaction> Transactions;


        public NewAccount() {
            DateCreated = new Date();
            Transactions = new ArrayList<>();
        }

        public NewAccount(int id, double balance) {
            this();
            ID = id;
            balance = balance;
        }

        public NewAccount(String name, int id, double balance) {
            this(id, balance);
            name = name;

        }

        public int getId() {
            return ID;
        }

        public void setId(int id) {
            ID = id;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            balance = balance;
        }


        public void setAnnualInterestRate(double annualInterestRate) {
            AnnualInterestRate = annualInterestRate;
        }

        public double getAnnualInterestRate() {
            return AnnualInterestRate;
        }


        public Date getDateCreated() {
            return DateCreated;
        }

        public double getMonthlyInterestRate() {
            return balance * (AnnualInterestRate / 12) / 100;
        }

        public void deposit(double amount) {
            Transactions.add(new Transaction('D', amount, balance, "deposit"));
            balance += amount;
        }

        public void withdraw(double amount) {
            Transactions.add(new Transaction('W', amount, balance, "withdraw"));
            balance -= amount;
        }


        public String toString() {
            return "Account name: " + name
                    + "\n" + "Interest rate: "
                    + AnnualInterestRate + "\n"
                    + Transactions;
        }

        public ArrayList<Transaction> getTransactions() {
            return new ArrayList<>(Transactions);
        }

    }
}
