public class Date
{
    // Attributes
    private int day = 1;
    private int month = 1;
    private int year = 2000;
    
    // Constructors
    public Date() {
        // Empty constructor
    }
    public Date(int newDay, int newMonth, int newYear) {
        setDay(newDay); setMonth(newMonth); setYear(newYear);
    }
    
    // Setters
    public void setDay(int newDay) {
        this.day = newDay;
    }
    public void setMonth(int newMonth) {
        this.month = newMonth;
    }
    public void setYear(int newYear) {
        this.year = newYear;
    }
    
    // Getters
    public int getDay() {
        return this.day;
    }
    public int getMonth() {
        return this.month;
    }
    public int getYear() {
        return this.year;
    }
    
    // Methods
    public String showDate(Date date)
    {
        String res = "";
        int day, month, year;
        res += day=date.getDay() > 9 ? day : "0"+day; 
        res += "/";
        res += month=date.getMonth() > 9 ? month : "0"+month; 
        res += "/";
        res += year=date.getYear() > 9 ?  month : "0"+year;
        return res;
    }
    
    public int calcWeekMonth(Date date)
    {
        return date.getDay() / 7;
    }
    
    public int calcWeekYear(Date date)
    {
        return date.getDay()*date.getMonth() / 7;
    }
    
    public boolean isSpecialYear(Date date)
    {
        boolean a = ((date.getDay()+date.getMonth()+date.getYear()) % 3) == 0;
        boolean b = sumTwoLastDigits(date.getYear()) % 5 == 0;
        return a || b;
    }
    private int sumTwoLastDigits(int year) // Aux method
    {
        String str = Integer.toString(year);
        return (int)str.charAt(str.length()-1)+(int)str.charAt(str.length());
    }
    
    public int calcDayWeek(Date date)
    {
        return (date.getDay() % 7) + (date.getMonth()-1)*2;
    }
    
    public boolean isHoliday(Date date)
    {
        if(date.getDay() == 15 && date.getMonth() % 2 == 0)
            return true;
        return date.calcDayWeek(date) > 5;
    }
    
    public boolean isWorking(Date date)
    {
        return !date.isHoliday(date);
    }
}