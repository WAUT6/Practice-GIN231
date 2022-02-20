public class Driver2 {

  public static void main(String[] args) {
    Person yuri = new Person("Yuri", 18, 190);
    BankAccount yuriBankAccount = new BankAccount(yuri, 2000);
    System.out.println(yuri.toString());
    System.out.println(yuriBankAccount.toString());
    SavingsAccount yuriSavingsAccount = new SavingsAccount(yuri, 1000);
    System.out.println(yuriSavingsAccount.toString());
  }
}
