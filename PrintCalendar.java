import java.util.*;
// grading notes including in source file. will be included in riley.md for future projects.
public class PrintCalendar {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter full year (e.g., 2001): ");
    int year = input.nextInt();

    System.out.print("Enter month in number between 1 and 12: ");
    int month = input.nextInt();
    Calendar calendar = new GregorianCalendar(year, month, 1);
    calendar.set(Calendar.MONTH, month - 1);

    printMonth(year, month, calendar);
    System.out.println(getMonthName(month) + ", " + year + " contains " + getNumberOfDaysInMonth(year, month) + " days");
  }

  public static void printMonth(int year, int month, Calendar calendar) {
    int startDay = getStartDay(calendar);
    int numOfDaysInMonth = getNumberOfDaysInMonth(year, month);
    printMonthTitle(year, month);
    printMonthBody(startDay, numOfDaysInMonth);
  }

  public static int getStartDay(Calendar calendar) {
    return calendar.get(Calendar.DAY_OF_WEEK);
  }

  public static void printMonthBody(int startDay, int numOfDaysInMonth) {
    int i = 0;
    for (i = 0; i < startDay-1; i++) {
      System.out.print("    ");
    }
    for (i = 1; i <= numOfDaysInMonth; i++) {
      if (i < 10)
        System.out.print("   "+i);
      else
        System.out.print("  "+i);

      if ((i + startDay - 1) % 7 == 0)
        System.out.println();
    }
    System.out.println("");
  }
  
  public static String getMonthName(int month) {
    String monthName[] = {"Jan", "Feb", "Mar", "April" , "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
    return monthName[month - 1];
  }
 // is this necessary? can we get this info from the class? 
  public static int getNumberOfDaysInMonth(int year, int month) {
    if (month == 1 || month == 3 || month == 5 || month == 7 ||
      month == 8 || month == 10 || month == 12)
      return 31;
    if (month == 4 || month == 6 || month == 9 || month == 11)
      return 30;
    if (month == 2) return isLeapYear(year) ? 29 : 28;

    return 0;
  }
    
  public static boolean isLeapYear(int year) {
    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
  }

  public static void printMonthTitle(int year, int month) {
    System.out.println("         "+getMonthName(month)+", "+year);
    System.out.println("-----------------------------");
    System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
  }
}
