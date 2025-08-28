package course.java_core.oop.mini_project1.lists.hotel_room_list;

import course.java_core.oop.mini_project1.lists.List;
import course.java_core.oop.mini_project1.lists.Sortable;
import course.java_core.oop.mini_project1.model.HotelRoom;

public class HotelRoomArrayList implements List<HotelRoom>, Sortable{

    private HotelRoom[] hotelRooms = new HotelRoom[5];
    private int size = 0;

    @Override
    public void add(HotelRoom hotelRoom) {

        if (size == hotelRooms.length){
            System.out.println("Вільні кімнати закінчились.");
        }else{

            hotelRooms[size] = hotelRoom;
            size++;

        }


    }
    @Override
    public int addAndReturnIndex(HotelRoom hotelRoom) {

        if (size == hotelRooms.length){
            System.out.println("Вільні кімнати закінчились.");
        }else {

            hotelRooms[size] = hotelRoom;
            size++;

        }


        return size;
    }

    @Override
    public void set(int index, HotelRoom hotelRoom) {
        hotelRooms[index] = hotelRoom;
    }

    @Override
    public HotelRoom get(int index) {
        return hotelRooms[index];
    }

    @Override
    public HotelRoom[] getList() {
        return hotelRooms;
    }

    @Override
    public void remove(int index) {

        if (index >= 0 && index <= hotelRooms.length){
            for (int i = index; i < hotelRooms.length - 1; i++) {
                hotelRooms[i] = hotelRooms[i+1];
            }

            hotelRooms[size - 1] = null;
            size--; // size = size - 1;

        }else {
            System.out.println("Елемент не видалено, бо не коректний індекс.");
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public HotelRoom[] sortFromMinPriceToMax() {


        HotelRoom[] sortedHotelRooms = new HotelRoom[hotelRooms.length];

        for (int i = 0; i < hotelRooms.length; i++){
            sortedHotelRooms[i] = hotelRooms[i];
        }

        for (int i = 0; i < sortedHotelRooms.length - 1; i++) {
            for (int j = 0; j < sortedHotelRooms.length - i - 1; j++){
                if (sortedHotelRooms[j].compareTo(sortedHotelRooms[j+1]) > 0){

                    HotelRoom newHotelRoom = sortedHotelRooms[j];
                    sortedHotelRooms[j] = sortedHotelRooms[j+1];
                    sortedHotelRooms[j+1] = newHotelRoom;
                }

            }

        }


        return sortedHotelRooms;
    }

    @Override
    public HotelRoom[] sortFromMaxPriceToMin() {
        HotelRoom[] sortedHotelRooms = new HotelRoom[hotelRooms.length];


        for (int i = 0; i < hotelRooms.length; i++){
            sortedHotelRooms[i] = hotelRooms[i];
        }

        for (int i = 0; i < sortedHotelRooms.length - 1; i++) {
            for (int j = 0; j < sortedHotelRooms.length - i - 1; j++) {
                if (sortedHotelRooms[j].compareTo(sortedHotelRooms[j+1]) < 0){

                    HotelRoom newHotelRoom = sortedHotelRooms[j];
                    sortedHotelRooms[j] = sortedHotelRooms[j+1];
                    sortedHotelRooms[j+1] = newHotelRoom;
                }
            }
        }

        return sortedHotelRooms;

    }

}
