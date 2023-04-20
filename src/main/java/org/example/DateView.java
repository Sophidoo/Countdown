package org.example;

import java.util.Date;
import java.util.Scanner;

public class DateView {
    public void dateView() {
        DateModel dateModel =new DateModel();
        DateController dateController = new DateController();
        Scanner input = new Scanner(System.in);
        Boolean formatCorrect = false;

        System.out.println();
        System.out.println("📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺");
        System.out.println("📺                 WELCOME TO ANNOUNCEMENT CHANNEL                  📺");
        System.out.println("📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺📺");
        System.out.println();
        System.out.println(">> Please Enter the date for the announcement in the format yyyy-mm-dd");
        System.out.print(">> ");
        while(!formatCorrect){
            String userInput = input.next();
            if(!userInput.contains("-")){
                System.out.println(">> Please enter the correct date format");
                System.out.print(">>");
                continue;
            }
            if(userInput.split("-")[0].length() != 4 || userInput.split("-")[1].length() != 2 || userInput.split("-")[2].length() != 2){
                System.out.println(">> Please enter the date in the format: yyyy-mm-dd");
                System.out.print(">>");
                continue;
            }

            int year = Integer.parseInt(userInput.split("-")[0]) ;
            int month = Integer.parseInt(userInput.split("-")[1]) ;
            int day = Integer.parseInt(userInput.split("-")[2]) ;

            dateModel.setYear(year);
            dateModel.setMonth(month);
            dateModel.setDay(day);
            formatCorrect = true;
        }


        Boolean timeCorrect = false;

        System.out.println();
        System.out.println(">> Please Enter the time for the announcement in the format hh:mm:ss");
        System.out.print(">>");
        while(!timeCorrect){
            String userInput = input.next();
            if(!userInput.contains(":")){
                System.out.println();
                System.out.println(">> Please enter the correct time format");
                System.out.println(">> ");
                continue;
            }
            if(userInput.split(":")[0].length() != 2 || userInput.split(":")[1].length() != 2 || userInput.split(":")[2].length() != 2){
                System.out.println();
                System.out.println(">> Please enter the time in the format: hh:mm:ss");
                System.out.println(">> ");
                continue;
            }

            int hour = Integer.parseInt(userInput.split(":")[0]) ;
            int minute = Integer.parseInt(userInput.split(":")[1]) ;
            int second = Integer.parseInt(userInput.split(":")[2]) ;
            dateModel.setHour(hour);
            dateModel.setMinute(minute);
            dateModel.setSecond(second);
            timeCorrect = true;
        }

        System.out.println(dateController.startTimer(dateModel));

    }
}
