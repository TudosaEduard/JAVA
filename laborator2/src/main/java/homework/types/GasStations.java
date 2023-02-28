package homework.types;

import homework.objects.Location;

public class GasStations extends Location {

    private double priceGasolin;
    private int parkingPlacesAvailable;
  
    public GasStations(String name, double x, double y, double price, int parkingPlacesAvailable) {
        super(name, x, y);
        this.priceGasolin = price;
        this.parkingPlacesAvailable = parkingPlacesAvailable;
    }

    public double getPriceGasolin() {
        return priceGasolin;
    }

    public void setPriceGasolin(double price) {
        this.priceGasolin = price;
    }

    public int getParkingPlacesAvailable() {
        return parkingPlacesAvailable;
    }

    public void setParkingPlacesAvailable(int parkingPlacesAvailable) {
        this.parkingPlacesAvailable = parkingPlacesAvailable;
    }

    @Override
    public String toString() {
        return "GasStations [price=" + priceGasolin + ", parkingPlacesAvailable=" + parkingPlacesAvailable + "]";
    }

    
}
