public class Person {

  private String name;
  private int age;
  private double height;
  public Object BankAccount;

  public Person() {
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
  public Person(String name, int age, double height) {
    setName(name);
    setAge(age);
    setHeight(height);
  }

  //To string method prints the current object and attributes as a string
  public String toString() {
    return (
      "Name: " +
      this.getName() +
      "| |" +
      "Age: " +
      getAge() +
      "| |" +
      "Height: " +
      getHeight()
    );
  }

  public static void main(String[] args) {
    Person peter = new Person("tia", 5, 7);
    // this is printing wrong
    System.out.println(peter);
    System.out.println(peter.getName());
    System.out.println(peter.getAge());
    System.out.println(peter.getHeight());
  }
}
