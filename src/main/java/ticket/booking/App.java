package ticket.booking;


import ticket.booking.service.TrainService;

import ticket.booking.entities.Train;
import java.util.List;
import java.io.IOException;


public class App {
    public static void main(String[] args) {
        System.out.println("Phase 4: Ticket Booking System Testing");

        try {
    
           TrainService trainService = new TrainService();
            List<Train> trains = trainService.getTrainList();

            System.out.println("Train loaded successfully:" + trains.size() + " trains found.");

            if(!trains.isEmpty()){

                System.out.println(trains.get(0).getTrainId());

            }


        } catch (IOException e) {
            System.out.println("Error loading train data: " + e.getMessage());
        }

    }
}