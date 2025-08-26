package course.java_core.oop.mini_project1.model;

import course.java_core.oop.mini_project1.enums.TypeHotelRoom;

import java.time.LocalDateTime;
import java.util.Objects;

public class HotelRoom implements Comparable<HotelRoom> {


    private String hotelName;
    private int number;
    private TypeHotelRoom typeHotelRoom;
    private double price;
    private LocalDateTime startOccupancy;
    private LocalDateTime endOccupancy;
    private boolean isReserved;

    public HotelRoom(String hotelName, int number, TypeHotelRoom typeHotelRoom, double price, LocalDateTime startOccupancy, LocalDateTime endOccupancy, boolean isReserved) {
        this.hotelName = hotelName;
        this.number = number;
        this.typeHotelRoom = typeHotelRoom;
        this.price = price;
        this.startOccupancy = startOccupancy;
        this.endOccupancy = endOccupancy;
        this.isReserved = isReserved;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        HotelRoom hotelRoom = (HotelRoom) o;
        return number == hotelRoom.number && Double.compare(price, hotelRoom.price) == 0 && isReserved == hotelRoom.isReserved && Objects.equals(hotelName, hotelRoom.hotelName) && typeHotelRoom == hotelRoom.typeHotelRoom && Objects.equals(startOccupancy, hotelRoom.startOccupancy) && Objects.equals(endOccupancy, hotelRoom.endOccupancy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelName, number, typeHotelRoom, price, startOccupancy, endOccupancy, isReserved);
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "hotelName='" + hotelName + '\'' +
                ", number=" + number +
                ", typeHotelRoom=" + typeHotelRoom +
                ", price=" + price +
                ", startOccupancy=" + startOccupancy +
                ", endOccupancy=" + endOccupancy +
                ", isReserved=" + isReserved +
                '}';
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public String hotelName() {
        return hotelName;
    }

    public int number() {
        return number;
    }

    public TypeHotelRoom typeHotelRoom() {
        return typeHotelRoom;
    }

    public double price() {
        return price;
    }

    public LocalDateTime startOccupancy() {
        return startOccupancy;
    }

    public LocalDateTime endOccupancy() {
        return endOccupancy;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setTypeHotelRoom(TypeHotelRoom typeHotelRoom) {
        this.typeHotelRoom = typeHotelRoom;
    }

    public void setPrince(double price) {
        this.price = price;
    }

    public void setStartOccupancy(LocalDateTime startOccupancy) {
        this.startOccupancy = startOccupancy;
    }

    public void setEndOccupancy(LocalDateTime endOccupancy) {
        this.endOccupancy = endOccupancy;
    }



    @Override
    public int compareTo(HotelRoom o) {

        if (this.price > o.price){
            return 1;
        }else if (this.price < o.price){
            return -1;
        }
        else {
            return 0;
        }
    }
}
