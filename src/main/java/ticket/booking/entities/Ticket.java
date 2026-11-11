package ticket.booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming (PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties ( ignoreUnknown = true)
public class Ticket {

    private String ticketId;
    private String userId;
    private String source;
    private String destination;
    private String dateOfJourney;
    private Train train;

    public Ticket () {

    }
    
    public Ticket (String ticketId, String userId, String source , String destination, String dateOfJourney, Train train) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.source = source;
        this.destination = destination;
        this.dateOfJourney = dateOfJourney;
        this.train = train;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return this.source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDateOfJourney(String dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }

    public String getDateOfJourney() {
        return this.dateOfJourney;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Train getTrain() {
        return this.train;
    }

    public String getTicketInfo(){
        return String.format("Ticket ID: %s belongs to user %s  from %s to %s on %s ",
            ticketId,
            userId,
            source,
            destination,
            dateOfJourney
          
        );
    }

    
}
