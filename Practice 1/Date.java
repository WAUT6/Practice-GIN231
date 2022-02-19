public class Date{
    
    
    //Attributes
    private int day;
    
    private int month;
    
    private int year;
    
    public static final class START_DATE {
        private static int day=15;
        private static int month=10;
        private static int year=1582;
    }
    //Setters
    public void setDay(int day){
        this.day=day;
    }
    
    public void setMonth(int month){
        this.month=month;
    }
    
    public void setYear(int year){
        this.year=year;
    }

    //Getters
    public int getDay(){
        return this.day;
    }

    public int getMonth(){
        return this.month;
    }

    public int getYear(){
        return this.year;
    }

    public int getStartDay(){
        return START_DATE.day;
    }

    public int getStartMonth(){
        return START_DATE.month;
    }

    public int getStartYear(){
        return START_DATE.year;
    }

    //Constructor
    public void Date(){
        this.Date(getStartDay(),getStartMonth(),getStartYear());
    }
    public void Date(int day,int month, int year){
        if (day<getStartDay() && month<getStartMonth() && year<getStartYear()){
            Date(getStartDay(),getStartMonth(),getStartYear());
        } else {
            setDay(day);
            setMonth(month);
            setYear(year);
        }
    }

    //Miscellaneous
    public boolean isLeapYear(int year){
        if (year%400==0 || (year%4==0 && year%100!=0)){
            return true;
        } else {
            return false;
        }

    }

    public boolean isLeapYear(){
        return isLeapYear(getYear());
    }

    public int daysFromStartDate(){
        
        int totalMonths=getMonth()-getStartMonth();

        int totalDays=getDay()-getStartDay();

        int totalLeapYears=0;

        int totalNormalYears=0;
        for(int i=getStartYear();i<=getYear();i++){
            if (isLeapYear(i)){
                totalLeapYears++;
            } else {
                totalNormalYears++;
            }
        }

        int daysFromStartDate=totalLeapYears*366 + totalNormalYears*365;
        
        if (totalMonths<0){
            daysFromStartDate-=Math.abs(totalMonths)*30;
        } else if (totalMonths>=0){
            daysFromStartDate+=totalMonths*30;
        }

        if (totalDays<0){
            daysFromStartDate-=Math.abs(totalDays);
        } else if (totalDays>=0){
            daysFromStartDate+=totalDays;
        }

        return daysFromStartDate;
    }

    public int daysBetween(Date date){
        int totalMonths=date.getMonth()-getMonth();

        int totalDays=date.getDay()-getDay();

        int totalLeapYears=0;

        int totalNormalYears=0;

        if (date.getYear()<getYear())
        for(int i=date.getYear();i<=getYear();i++){
            if (isLeapYear(i)){
                totalLeapYears++;
            } else {
                totalNormalYears++;
            }
        }

        int daysCounter=totalLeapYears*366 + totalNormalYears*365;
        
        if (totalMonths<0){
            daysCounter-=Math.abs(totalMonths)*30;
        } else if (totalMonths>=0){
            daysCounter+=totalMonths*30;
        }

        if (totalDays<0){
            daysCounter-=Math.abs(totalDays);
        } else if (totalDays>=0){
            daysCounter+=totalDays;
        }

        return daysCounter;
    }

    public String toString(Date date){
        return date.getMonth()+"/"+date.getDay()+"/"+date.getYear();

    }

    public int compare(Date d1, Date d2){
        int i=0;
        if(d1.getYear()>d2.getYear()){
             i=1;
        } else if (d1.getYear()<d2.getYear()){
             i=-1;
        } else if (d1.getYear()==d2.getYear()){
            if(d1.getMonth()>d2.getMonth()){
                 i=1;
            } else if (d1.getMonth()<d2.getMonth()){
                 i=-1;
            } else if (d1.getMonth()==d2.getMonth()){
                if(d1.getDay()>d2.getDay()){
                     i=1;
                } else if (d1.getDay()<d2.getDay()){
                     i=-1;
                } else if (d1.getDay()==d2.getDay()){
                     i=0;
                }
            }
        }
        return i;
    }

    public int compareTo(Date d){
        return compare(this, d);
    }
    
    public boolean equals(Date d1,Date d2){
        if(d1!=d2) {
            return false;
        } else if (this != d1 || this !=d2){
            return false;
        } else {
            return true;
        }
    }

    public int daysTillNextYear(){
        int daysCounter=0;
        for(int i=getDay();i<=30;i++){
            daysCounter++;
        }

        for(int i=getMonth()+1;i<=12;i++){
            for(int j=1;j<=30;j++){
                daysCounter++;
            }
        }
        return daysCounter;
    }
    

}

class Driver {
    public static void main(String[] args){
        Date myBirthday= new Date(30,7,2003);
        myBirthday.setDay(30);
        myBirthday.setMonth(7);
        myBirthday.setYear(2003);
        
        System.out.println(myBirthday.toString(myBirthday));
        System.out.println(myBirthday.daysFromStartDate());
    }
}