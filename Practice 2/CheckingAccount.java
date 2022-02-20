public class CheckingAccount extends BankAccount {

  private int numbCheques;

  public int getNumCheques() {
    return numbCheques;
  }

  public void setNumCheques(int numbCheques) {
    this.numbCheques = numbCheques;
  }

  public CheckingAccount() {
    //cant i put super and this in the same constructor?
    super();
    numbCheques = 0;
  }

  public CheckingAccount(Person owner, double balance) {
    super(owner, balance);
  }

  public CheckingAccount(double balance, int numbCheques) {}

  public CheckingAccount(Person owner, double balance, int numbCheques) {
    super(owner, balance);
    setNumCheques(numbCheques);
  }

  @Override
  // same method name and param but diff invocation inside
  public void deposit(double amount) {
    super.deposit(amount);
  }

  // copy constructor
  public CheckingAccount(CheckingAccount other) {
    this.numbCheques = other.numbCheques;
  }
}
