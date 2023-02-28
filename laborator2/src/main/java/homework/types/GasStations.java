package homework.types;

import homework.objects.Location;

public class GasStations extends Location {

    private double priceGasoline;
    private int parkingPlacesAvailable;

    /**
     * 
     * @param name                   Name of the location created
     * @param x                      The x coordinate for location positioning
     * @param y                      The y coordinate for location positioning
     * @param price                  The gasoline price
     * @param parkingPlacesAvailable Parking places available
     */

    public GasStations(String name, double x, double y, double price, int parkingPlacesAvailable) {
        super(name, x, y);
        this.priceGasoline = price;
        this.parkingPlacesAvailable = parkingPlacesAvailable;
    }

    public double getPriceGasolin() {
        return priceGasoline;
    }

    public void setPriceGasolin(double price) {
        this.priceGasoline = price;
    }

    public int getParkingPlacesAvailable() {
        return parkingPlacesAvailable;
    }

    public void setParkingPlacesAvailable(int parkingPlacesAvailable) {
        this.parkingPlacesAvailable = parkingPlacesAvailable;
    }

    @Override
    public String toString() {
        return "GasStations [price=" + priceGasoline + ", parkingPlacesAvailable=" + parkingPlacesAvailable + "]";
    }

}
