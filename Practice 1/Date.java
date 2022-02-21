public class Date {

  //Constants
  public static final int[] START_DATE = { 15, 10, 1582 };

  //Attributes
  private int day;
  private int month;
  private int year;

  //Constructors
  public Date() {
    this(START_DATE[0], START_DATE[1], START_DATE[2]);
  }

  public Date(int day, int month, int year) {
    if (year < getStartYear()) {
      setDay(getStartDay());
      setMonth(getStartMonth());
      setYear(getStartYear());
    } else if (year == getStartYear()) {
      if (month < getStartMonth()) {
        setDay(getStartDay());
        setMonth(getStartMonth());
        setYear(getStartYear());
      } else if (month == getStartMonth()) {
        if (day < getStartDay()) {
          setDay(getStartDay());
          setMonth(getStartMonth());
          setYear(getStartYear());
        } else {
          setDay(day);
          setMonth(month);
          setYear(year);
        }
      }
    } else {
      setDay(day);
      setMonth(month);
      setYear(year);
    }
  }

  //Copy Constructor
  public Date(Date otherDate) {
    setDay(otherDate.day);
    setMonth(otherDate.month);
    setYear(otherDate.year);
  }

  //Setters
  public void setDay(int day) {
    this.day = day;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public void setYear(int year) {
    this.year = year;
  }

  //Getters
  public int getDay() {
    return this.day;
  }

  public int getMonth() {
    return this.month;
  }

  public int getYear() {
    return this.year;
  }

  public static int getStartDay() {
    return START_DATE[0];
  }

  public static int getStartMonth() {
    return START_DATE[1];
  }

  public static int getStartYear() {
    return START_DATE[2];
  }

  //Miscellaneous
  public boolean isLeapYear(int year) {
    if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isLeapYear() {
    return isLeapYear(getYear());
  }

  public int daysFromStartDate() {
    int totalMonths = getMonth() - getStartMonth();

    int totalDays = getDay() - getStartDay();

    int totalLeapYears = 0;

    int totalNormalYears = 0;
    for (int i = getStartYear(); i < getYear(); i++) {
      if (isLeapYear(i)) {
        totalLeapYears++;
      } else {
        totalNormalYears++;
      }
    }

    int daysFromStartDate = totalLeapYears * 366 + totalNormalYears * 365;

    if (totalMonths < 0) {
      daysFromStartDate -= Math.abs(totalMonths) * 30;
    } else if (totalMonths >= 0) {
      daysFromStartDate += totalMonths * 30;
    }

    if (totalDays < 0) {
      daysFromStartDate -= Math.abs(totalDays);
    } else if (totalDays >= 0) {
      daysFromStartDate += totalDays;
    }

    return daysFromStartDate;
  }

  public int daysBetween(Date date) {
    int totalMonths = date.getMonth() - getMonth();

    int totalDays = date.getDay() - getDay();

    int totalLeapYears = 0;

    int totalNormalYears = 0;

    if (date.getYear() < getYear()) for (
      int i = date.getYear();
      i <= getYear();
      i++
    ) {
      if (isLeapYear(i)) {
        totalLeapYears++;
      } else {
        totalNormalYears++;
      }
    }

    int daysCounter = totalLeapYears * 366 + totalNormalYears * 365;

    if (totalMonths < 0) {
      daysCounter -= Math.abs(totalMonths) * 30;
    } else if (totalMonths >= 0) {
      daysCounter += totalMonths * 30;
    }

    if (totalDays < 0) {
      daysCounter -= Math.abs(totalDays);
    } else if (totalDays >= 0) {
      daysCounter += totalDays;
    }

    return daysCounter;
  }

  public String toString(Date date) {
    return date.getMonth() + "/" + date.getDay() + "/" + date.getYear();
  }

  public int compare(Date d1, Date d2) {
    int i = 0;
    if (d1.getYear() > d2.getYear()) {
      i = 1;
    } else if (d1.getYear() < d2.getYear()) {
      i = -1;
    } else if (d1.getYear() == d2.getYear()) {
      if (d1.getMonth() > d2.getMonth()) {
        i = 1;
      } else if (d1.getMonth() < d2.getMonth()) {
        i = -1;
      } else if (d1.getMonth() == d2.getMonth()) {
        if (d1.getDay() > d2.getDay()) {
          i = 1;
        } else if (d1.getDay() < d2.getDay()) {
          i = -1;
        } else if (d1.getDay() == d2.getDay()) {
          i = 0;
        }
      }
    }
    return i;
  }

  public int compareTo(Date d) {
    return compare(this, d);
  }

  public boolean equals(Date d1, Date d2) {
    if (d1 != d2) {
      return false;
    } else if (this != d1 || this != d2) {
      return false;
    } else {
      return true;
    }
  }

  public int daysTillNextYear() {
    int daysCounter = 0;
    for (int i = getDay(); i <= 30; i++) {
      daysCounter++;
    }

    for (int i = getMonth() + 1; i <= 12; i++) {
      for (int j = 1; j <= 30; j++) {
        daysCounter++;
      }
    }
    return daysCounter;
  }
}

class Driver {

  public static void main(String[] args) {
    Date myBirthday = new Date(29, 12, 2003);

    System.out.println(myBirthday.toString(myBirthday));
    System.out.println(myBirthday.daysFromStartDate());

    Date mySameBirthday = new Date(myBirthday);
    mySameBirthday.setDay(30);

    System.out.println(myBirthday.daysBetween(mySameBirthday));

    System.out.println(myBirthday.toString(myBirthday));
    System.out.println(mySameBirthday.toString(mySameBirthday));

    System.out.println(myBirthday.compareTo(mySameBirthday));
    System.out.println(myBirthday.daysTillNextYear());
  }
}
