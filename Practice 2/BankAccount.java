public class BankAccount extends Person {

  private Person owner;
  private double balance;

  public BankAccount() {
    // to initialize the owner having several attributes (do we always do this)
    this.owner = new Person(owner.getName(), owner.getAge(), owner.getHeight());
    balance = 0;
  }

  public Person getOwner() {
    return owner;
  }

  public void setOwner(Person owner) {
    this.owner = owner;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public BankAccount(Person owner, double balance) {
    setOwner(owner);
    setBalance(balance);
  }

  public void deposit(double amount) {
    if (amount > 0) {
      balance = getBalance() + amount;
    }
    setBalance(balance);
  }

  // copy constructor form
  public BankAccount(BankAccount otherBank) {}

  @Override
  public String toString() {
    return getOwner().getName();
  }
}
