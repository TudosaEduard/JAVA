package homework.types;

import homework.objects.Location;

public class AirPorts extends Location {

    private double ticketPrices;
    private int numberOfRaceAvailable;
 
    public AirPorts(String name, double x, double y, double ticketPrices, int numberOfRaceAvailable) {
        super(name, x, y);
        this.ticketPrices = ticketPrices;
        this.numberOfRaceAvailable = numberOfRaceAvailable;
    }

    public double getTicketPrices() {
        return ticketPrices;
    }

    public void setTicketPrices(double ticketPrices) {
        this.ticketPrices = ticketPrices;
    }

    public int getNumberOfRaceAvailable() {
        return numberOfRaceAvailable;
    }

    public void setNumberOfRaceAvailable(int numberOfRaceAvailable) {
        this.numberOfRaceAvailable = numberOfRaceAvailable;
    }

    @Override
    public String toString() {
        return "AirPorts [ticketPrices=" + ticketPrices + ", numberOfRaceAvailable=" + numberOfRaceAvailable + "]";
    }
  
    
}
