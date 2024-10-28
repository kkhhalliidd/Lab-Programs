import java.util.Scanner;

class Account {
String customerName;
String accountNumber;
double balance;
String accountType;

public Account(String customerName, String accountNumber, String accountType) {
this.customerName = customerName;
this.accountNumber = accountNumber;
this.accountType = accountType;
this.balance = 0.0;
}

public void deposit(double amount) {
balance += amount;
System.out.println("Deposited: " + amount);
displayBalance();
}

public void displayBalance() {
System.out.println("Balance: " + balance);
}

public double getBalance() {
return balance;
}
}

class SavingsAccount extends Account {
double interestRate;

public SavingsAccount(String customerName, String accountNumber, double interestRate) {
super(customerName, accountNumber, "Savings");
this.interestRate = interestRate;
}

public void computeInterest() {
double interest = balance * interestRate / 100;
balance += interest;
System.out.println("Interest computed and added: " + interest);
displayBalance();
}

public void withdraw(double amount) {
if (amount <= balance) {
balance -= amount;
System.out.println("Withdrew: " + amount);
displayBalance();
} else {
System.out.println("Insufficient balance!");
}
}
}

class CurrentAccount extends Account {
double minimumBalance;
double serviceCharge;

public CurrentAccount(String customerName, String accountNumber, double minimumBalance, double serviceCharge) {
super(customerName, accountNumber, "Current");
this.minimumBalance = minimumBalance;
this.serviceCharge = serviceCharge;
}

public void withdraw(double amount) {
if (amount <= balance) {
balance -= amount;
System.out.println("Withdrew: " + amount);
displayBalance();
} else {
System.out.println("Insufficient balance!");
}
checkMinimumBalance();
}

public void checkMinimumBalance() {
if (balance < minimumBalance) {
balance -= serviceCharge;
System.out.println("Service charge applied: " + serviceCharge);
displayBalance();
}
}
}

public class Bank {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.println("Enter customer name:");
String name = scanner.nextLine();
System.out.println("Enter account number:");
String accountNumber = scanner.nextLine();

System.out.println("Choose account type (1 for Savings, 2 for Current):");
int choice = scanner.nextInt();

Account account = null;
if (choice == 1) {
System.out.println("Enter interest rate:");
double interestRate = scanner.nextDouble();
account = new SavingsAccount(name, accountNumber, interestRate);
} else if (choice == 2) {
System.out.println("Enter minimum balance:");
double minBalance = scanner.nextDouble();
System.out.println("Enter service charge:");
double serviceCharge = scanner.nextDouble();
account = new CurrentAccount(name, accountNumber, minBalance, serviceCharge);
} else {
System.out.println("Invalid choice.");
return;
}
while (true) {
System.out.println("Choose an action (1 for Deposit, 2 for Withdraw, 3 for Display Balance, 4 for Compute Interest, 5 to Exit):");
int action = scanner.nextInt();
switch (action) {
case 1:
System.out.println("Enter amount to deposit:");
double depositAmount = scanner.nextDouble();
account.deposit(depositAmount);
break;
case 2:
System.out.println("Enter amount to withdraw:");
double withdrawAmount = scanner.nextDouble();
if (account instanceof SavingsAccount) {
((SavingsAccount) account).withdraw(withdrawAmount);
} else if (account instanceof CurrentAccount) {
((CurrentAccount) account).withdraw(withdrawAmount);
}
break;
case 3:
account.displayBalance();
break;
case 4:
if (account instanceof SavingsAccount) {
((SavingsAccount) account).computeInterest();
} else {
System.out.println("Interest computation is not applicable for Current Account.");
}
break;
case 5:
System.out.println("Exiting...");
return;
default:
System.out.println("Invalid action.");
}
}
}
}