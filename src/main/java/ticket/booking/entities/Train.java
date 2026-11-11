package ticket.booking.entities;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;


@JsonIgnoreProperties (ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

public class Train {

    private String trainId;
    private String trainNo;
   
    @JsonProperty("seats")
    private int[][] seatAvailability;
    private Map<String , String> stationTimes;
    private List<String> stations;

    public Train (){

    }
    public Train (String trainId, String trainNo,  int[][] seatAvailability, Map<String , String> stationTimes, List<String> stations) {
        this.trainId = trainId;
        this.trainNo = trainNo;
        this.seatAvailability = seatAvailability;
        this.stationTimes = stationTimes;
        this.stations = stations;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }
    public String getTrainId() {
        return this.trainId;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public String getTrainNo() {
        return this.trainNo;
    }

   

    public void setSeatAvailability(int[][] seatAvailability) {
        this.seatAvailability = seatAvailability;
    }

    public int[][] getSeatAvailability() {
        return this.seatAvailability;
    }

    public void setStationTimes(Map<String , String> stationTimes) {
        this.stationTimes = stationTimes;
    }

    public Map<String , String> getStationTimes() {
        return this.stationTimes;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public List<String> getStations() {
        return this.stations;
    }


    public String getTrainInfo(){
        return String.format("Train ID: %s, Train No: %s",
            trainId,
            trainNo
        );
    }



    
}
