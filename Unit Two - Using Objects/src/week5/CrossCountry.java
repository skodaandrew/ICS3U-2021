package week5;

import java.util.Scanner;

public class CrossCountry {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        processRunner(in);
        processRunner(in);
        processRunner(in);
        in.close();
    }
    

    private static void processRunner(Scanner in){
        String firstName, lastName;
        String mileOne, mileTwo, finish;
        String splitTwo, splitThree;
      
        /**
         * get first last name of the runner
         * get the mileone, miletwo and finish times for the runner
         */

        // user name
        System.out.println("Enter your first name: ");
        firstName = in.nextLine();
        System.out.println("Enter your last name");
        lastName = in.nextLine();

        //mile times
        System.out.println("Enter your mile one time");
        mileOne = in.nextLine();
    
        System.out.println("Enter your mile two time");
        mileTwo = in.nextLine();

        System.out.println("Enter finish time");
        finish = in.nextLine();
        splitTwo = subtractTime(mileTwo, mileOne);
        splitThree = subtractTime(finish, mileTwo);


        System.out.println("");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("MileOne: " + convertToTime(convertToSeconds( mileOne)));
        System.out.println("Split two: " + splitTwo);
        System.out.println("Split three: " + splitThree);
        System.out.println("Finish time: " + convertToTime(convertToSeconds(finish)));
        System.out.println("");


         /**
          * display summary for the runner
          */



    }



/**
 * @param endTime
 * @param startTime
 * @return
 */

    private static String subtractTime(String endTime, String startTime) {
        double endTimeInSeconds = convertToSeconds(endTime);
        double startTimeInSeconds = convertToSeconds(startTime);

        double diffInSeconds = endTimeInSeconds - startTimeInSeconds;

        return convertToTime(diffInSeconds);
    }


    private static String convertToTime(double timeInSeconds) {
        return String.format("%d:%06.3f", (int) timeInSeconds/60, timeInSeconds%60);
        

        // Time in seconds "mod" 60 = minutes
        // Time in seconds "remainder" 60 = seconds OR timeInSeconds - (60 * minutes) = seconds
        // return minutes + ':' + seconds
    }


    private static double convertToSeconds(String time) {
        //5:07.761
        //50.8
        if (time.indexOf(":") == -1){
            return  (Double.parseDouble(time));
        }
        String minute = time.substring(0,time.indexOf(":")); 
        
        return (Double.parseDouble( minute ) * 60) + Double.parseDouble(time.substring(time.indexOf(":") + 1)); //minutes and seconds
        
    }
    


}
 
