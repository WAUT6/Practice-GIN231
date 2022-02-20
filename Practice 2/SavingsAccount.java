public class SavingsAccount extends BankAccount {

  private double interestRate;

  public SavingsAccount() {
    super();
    interestRate = 0;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }

  // constructor so super(...)
  public SavingsAccount(Person owner, double balance) {
    super(owner, balance);
    // better to write this in case i call this method in main so i already set this
    setInterestRate(interestRate);
  }

  public SavingsAccount(Person owner, double balance, double interestRate) {
    super(owner, balance);
    setOwner(owner);
    setBalance(balance);
    setInterestRate(interestRate);
  }

  public SavingsAccount(double balance, double interestRate) {
    setBalance(balance);
    setInterestRate(interestRate);
  }

  @Override
  // method so super.something
  public void deposit(double amount) {
    super.deposit(amount);
  }

  public double computeInterest(double amount, double interestRate) {
    double interest = amount * interestRate;
    return interest;
  }

  public SavingsAccount(SavingsAccount otherSaving) {
    super(otherSaving);
    interestRate = otherSaving.interestRate;
  }

  public static void main(String[] args) {
    // how do i assign a value to owner and other values to balance and interestRate (by assigning them to acc directly)
    SavingsAccount acc = new SavingsAccount();
    SavingsAccount trial = new SavingsAccount(8, 6);
    SavingsAccount copy = new SavingsAccount(acc);
    System.out.println(acc.getOwner());
    System.out.println(trial.getBalance());
    System.out.println(trial.getInterestRate());
    System.out.println(copy.getBalance());
    System.out.println(acc.getBalance());
    System.out.println(acc.getInterestRate());
    System.out.println(acc.computeInterest(5, 8));
  }
}
