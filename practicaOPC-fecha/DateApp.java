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
        System.out.println("--- DATE1 CREATION ---");
        System.out.print("Set the day: ");
        day = Integer.parseInt(br.readLine());
        System.out.print("Set the month: ");
        month = Integer.parseInt(br.readLine());
        System.out.print("Set the year: ");
        year = Integer.parseInt(br.readLine());
        Date date2 = new Date(day, month, year);
        
        // First info print (date1)
        System.out.println("Today is day "+date1.getDay()+" from month "+date1.getMonth()+", year "+date1.getYear()+": "+date1.showDate(date1));
        
        // date1 up-date (haha->fun())
        System.out.println("--- DATE1 UPDATE ---");
        System.out.print("Set the day: ");
        date1.setDay(Integer.parseInt(br.readLine()));
        System.out.print("Set the month: ");
        date1.setMonth(Integer.parseInt(br.readLine()));
        System.out.print("Set the year: ");
        date1.setYear(Integer.parseInt(br.readLine()));
        
        // Second info print (date1)
        System.out.println("Today is day "+date1.getDay()+" from month "+date1.getMonth()+", year "+date1.getYear()+": "+date1.showDate(date1));
        
        // date2 prints
        // Second info print (date1)
        System.out.println("Today is day "+date2.getDay()+" from month "+date2.getMonth()+", year "+date2.getYear()+": "+date2.showDate(date2));
        System.out.println("Day "+date2.getDay()+" is on week number "+date2.calcWeekMonth(date2)+" of the month and on week number "+date2.calcWeekYear(date2)+" of the year");
        System.out.println("Special year: "+date2.isSpecialYear(date2));
        System.out.print("Day of the week: ");
        switch(date2.calcDayWeek(date2))
        {
            case 1: System.out.println("Monday"); break;
            case 2: System.out.println("Tuesday"); break;
            case 3: System.out.println("Wednesday"); break;
            case 4: System.out.println("Thursday"); break;
            case 5: System.out.println("Friday"); break;
            case 6: System.out.println("Saturday"); break;
            case 7: System.out.println("Sunday"); break;
            default: System.out.println("undefined");
        }
        System.out.println("Holiday: "+date2.isHoliday(date2)+", Working: "+date2.isWorking(date2));
    }
}