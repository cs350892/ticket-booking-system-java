package ticket.booking.service;


import java.util.List;
import ticket.booking.entities.Train;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;



public class TrainService {

    private List<Train> trainList ;

    private ObjectMapper objectMpper = new ObjectMapper();

    private static final String TRAIN_DB_PATH =
            "ticket-booking-system/src/data/trains.json";
    public TrainService() throws IOException {
        this.trainList = objectMpper.readValue(new File(TRAIN_DB_PATH), new TypeReference<List<Train>>() {});
    }

    public List<Train> getTrainList() {
        return trainList;
    }


    public void saveTrainList()  {
     try {
        objectMpper.writeValue(new File(TRAIN_DB_PATH), trainList);
     } catch (IOException e) {
        e.printStackTrace();
     }
    }


   public List<Train> searchTrains(String source, String destination) {

      return trainList.stream ()
        .filter (train  -> {

            List<String> stations = train.getStations();

            int sourceIndex =-1;
            int destinationIndex = -1;

            for (int i = 0; i < stations.size(); i++) {
                if (stations.get(i).equalsIgnoreCase(source)) {
                    sourceIndex = i;
                }
                if (stations.get(i).equalsIgnoreCase(destination)) {
                    destinationIndex = i;
                }
            }
            return sourceIndex != -1 && destinationIndex != -1 && sourceIndex < destinationIndex;
        })
        .collect(Collectors.toList());
   }


   private boolean isValidTrain(Train train, String source , String destination) {

    List<String> stations = train.getStations();

    int sourceIndex =-1;
    int destinationIndex = -1;

    for (int i = 0; i < stations.size(); i++) {
        if (stations.get(i).equalsIgnoreCase(source)) {
            sourceIndex = i;
        }
        if (stations.get(i).equalsIgnoreCase(destination)) {
            destinationIndex = i;
        }
    }

    return sourceIndex != -1 && destinationIndex != -1 && sourceIndex < destinationIndex;

   }


   






    
}