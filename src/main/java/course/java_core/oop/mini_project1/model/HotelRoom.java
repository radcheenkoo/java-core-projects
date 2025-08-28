package course.java_core.oop.mini_project1.model;

import course.java_core.oop.mini_project1.TypeHotelRoom;

import java.util.Objects;

public class HotelRoom implements Comparable<HotelRoom> {


    private String hotelName;
    private int number;
    private TypeHotelRoom typeHotelRoom;
    private double pricePreDay;
    private boolean isReserved;

    public HotelRoom(String hotelName, int number, TypeHotelRoom typeHotelRoom, double pricePreDay, boolean isReserved) {
        this.hotelName = hotelName;
        this.number = number;
        this.typeHotelRoom = typeHotelRoom;
        this.pricePreDay = pricePreDay;
        this.isReserved = isReserved;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        HotelRoom hotelRoom = (HotelRoom) o;
        return number == hotelRoom.number && Double.compare(pricePreDay, hotelRoom.pricePreDay) == 0 && isReserved == hotelRoom.isReserved && Objects.equals(hotelName, hotelRoom.hotelName) && typeHotelRoom == hotelRoom.typeHotelRoom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelName, number, typeHotelRoom, pricePreDay, isReserved);
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "hotelName='" + hotelName + '\'' +
                ", number=" + number +
                ", typeHotelRoom=" + typeHotelRoom +
                ", pricePreDay=" + pricePreDay +
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
        return pricePreDay;
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
        this.pricePreDay = price;
    }




    @Override
    public int compareTo(HotelRoom o) {

        if (this.pricePreDay > o.pricePreDay){
            return 1;
        }else if (this.pricePreDay < o.pricePreDay){
            return -1;
        }
        else {
            return 0;
        }
    }
}
