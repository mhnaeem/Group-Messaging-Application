public class Date{
    static int MAX_VALID_YR = 2019; // Current Year
    static int MIN_VALID_YR = 1900; 
    
    private int day, month, year;
    
    public Date(int dd, int mm, int yy){
        if(isValidDate(dd, mm, yy)){
            day = dd;
            month = mm;
            year = yy;
        }
        else{
            System.out.println("Invalid Date!");
        }
    }
    
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    
    public String getDateString(){
        switch(month){
            case(1):
            return Integer.toString(day) + "-Jan-" + Integer.toString(year);
            case(2):
            return Integer.toString(day) + "-Feb-" + Integer.toString(year);
            case(3):
            return Integer.toString(day) + "-Mar-" + Integer.toString(year);
            case(4):
            return Integer.toString(day) + "-Apr-" + Integer.toString(year);
            case(5):
            return Integer.toString(day) + "-May-" + Integer.toString(year);
            case(6):
            return Integer.toString(day) + "-Jun-" + Integer.toString(year);
            case(7):
            return Integer.toString(day) + "-Jul-" + Integer.toString(year);
            case(8):
            return Integer.toString(day) + "-Aug-" + Integer.toString(year);
            case(9):
            return Integer.toString(day) + "-Sep-" + Integer.toString(year);
            case(10):
            return Integer.toString(day) + "-Oct-" + Integer.toString(year);
            case(11):
            return Integer.toString(day) + "-Nov-" + Integer.toString(year);
            case(12):
            return Integer.toString(day) + "-Dec-" + Integer.toString(year);
            default:
            return "Date Error!";
        }
    }
    
    // Returns true if 
    // given year is valid. 
    static boolean isLeap(int year) 
    { 
        // Return true if year is 
        // a multiple of 4 and not 
        // multiple of 100. 
        // OR year is multiple of 400. 
        return (((year % 4 == 0) && 
                (year % 100 != 0)) || 
                (year % 400 == 0)); 
    } 
    
    // Returns true if given 
    // year is valid or not. 
    static boolean isValidDate(int d, int m, int y){ 
        // If year, month and day 
        // are not in given range 
        if ( (y > MAX_VALID_YR) || (y < MIN_VALID_YR) ){
            return false; 
        }
        if ( (m < 1) || (m > 12) ){
            return false; 
        }
        if ( (d < 1) || (d > 31) ){
            return false; 
        }
    
        // Handle February month 
        // with leap year 
        if (m == 2) 
        { 
            if (isLeap(y)) {
                return (d <= 29);
            }
            else{
                return (d <= 28); 
            }
        } 
    
        // Months of April, June, 
        // Sept and Nov must have 
        // number of days less than 
        // or equal to 30. 
        if ( (m == 4) || (m == 6) || (m == 9) || (m == 11) ){ 
            return (d <= 30); 
        }
    
        return true; 
    } 
}