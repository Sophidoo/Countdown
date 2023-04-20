package org.example;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class DateController implements DateInterface{
    @Override
    public String startTimer(DateModel dateModel) {
        LocalDateTime date = LocalDateTime.of(dateModel.getYear(), dateModel.getMonth(), dateModel.getDay(), dateModel.getHour(), dateModel.getMinute(), dateModel.getSecond());
        LocalDateTime now = LocalDateTime.now();

        Duration duration = Duration.between(now, date);
        final long[] seconds = {ChronoUnit.SECONDS.between(now, date)};

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int counter = (int) seconds[0];
            @Override
            public void run() {
                System.out.println(counter);

                counter--;
                if(counter == -1){
                    System.out.println(onFinish());
                    timer.cancel();
                }
            }
        }, 0, 1000);

        return "Countdown Starts";

    }

    @Override
    public String onFinish() {
        Scanner input = new Scanner(System.in);
        LocalDate now = LocalDate.now();
        LocalDate buhariHandover = LocalDate.of(2023, 05, 29);
        long daysRemainings = ChronoUnit.DAYS.between(now, buhariHandover);

        return "it is remaining " + daysRemainings + " days to buhari handover😝";
    }

}
