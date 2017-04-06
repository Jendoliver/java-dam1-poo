import java.io.*;

public class DateApp
{
    public static void main(String[] args) throws IOException
    {
        // Creation of the first object
        Date date1 = new Date();
        
        // Creation of the second object (user input)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int day, month, year;
        System.out.println("--- DATE2 CREATION ---");
        System.out.print("Set the day: ");
        day = Integer.parseInt(br.readLine());
        System.out.print("Set the month: ");
        month = Integer.parseInt(br.readLine());
        System.out.print("Set the year: ");
        year = Integer.parseInt(br.readLine());
        Date date2 = new Date(day, month, year);
        
        // First info print (date1)
        System.out.println("DATE1: Today is "+date1.getDay()+" of "+itos(date1, false)+", year "+date1.getYear()+": "+date1.showDate(date1));
        
        // date1 up-date (haha->fun())
        System.out.println("--- DATE1 UPDATE ---");
        System.out.print("Set the day: ");
        date1.setDay(Integer.parseInt(br.readLine()));
        System.out.print("Set the month: ");
        date1.setMonth(Integer.parseInt(br.readLine()));
        System.out.print("Set the year: ");
        date1.setYear(Integer.parseInt(br.readLine()));
        
        // Second info print (date1)
        System.out.println("DATE1: Today is "+date1.getDay()+" of "+itos(date1, false)+", year "+date1.getYear()+": "+date1.showDate(date1));
        
        // date2 prints
        System.out.println("--- DATE2 ---");
        System.out.println("Today is "+date2.getDay()+" of "+itos(date2, false)+", year "+date2.getYear()+": "+date2.showDate(date2));
        System.out.println("Day "+date2.getDay()+" of "+itos(date2, false)+" is on week number "+date2.calcWeekMonth(date2)+" of the month and on week number "+date2.calcWeekYear(date2)+" of the year");
        System.out.println("Special year: "+date2.isSpecialYear(date2));
        System.out.println("Day of the week: "+itos(date2, true));
        System.out.println("Holiday: "+date2.isHoliday(date2)+", Working: "+date2.isWorking(date2));
    }
    
    public static String itos(Date date, boolean op)
    {
        if(op) // calcDayWeek
        {
            switch(date.calcDayWeek(date))
            {
                case 1: return "Monday";
                case 2: return "Tuesday";
                case 3: return "Wednesday";
                case 4: return "Thursday";
                case 5: return "Friday";
                case 6: return "Saturday";
                case 7: return "Sunday";
                default: return "undefined";
            }
        }
        else // getMonth
        {
            switch(date.getMonth())
            {
                case 1: return "January";
                case 2: return "February";
                case 3: return "March";
                case 4: return "April";
                case 5: return "May";
                case 6: return "June";
                case 7: return "July";
                case 8: return "August";
                case 9: return "September";
                case 10: return "October";
                case 11: return "November";
                case 12: return "December";
                default: return "undefined";
            }
        }
    }
}