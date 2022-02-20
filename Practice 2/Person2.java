public class Person2 {

  private String name;
  private int age;
  private double height;
  private BankAccount bank;

  public Person2() {
    // initialization of parameters
    this("peter", 0, 0.0);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  // refer to the method of initialization in case values are changed in main method
  // instead of calling each method on each line of setters
  public Person2(String name, int age, double height) {
    setName(name);
    setAge(age);
    setHeight(height);
  }

  public BankAccount getBankAccount() {
    return this.bank;
  }

  // deep copy
  public Person2(Person2 object) {
    this.name = (object.name);
    BankAccount otherBankAccount = new BankAccount(object.bank);
  }

  public String toString() {
    return (
      "Name: " +
      getName() +
      " " +
      "Age: " +
      getAge() +
      " " +
      "Height: " +
      getHeight()
    );
  }

  public static void main(String[] args) {
    Person peter = new Person("tia", 5, 7);
    // this is printing wrong because ITS THE ADRESS
    System.out.println(peter.toString());
    System.out.println(peter.getName());
    System.out.println(peter.getAge());
    System.out.println(peter.getHeight());
  }
}
