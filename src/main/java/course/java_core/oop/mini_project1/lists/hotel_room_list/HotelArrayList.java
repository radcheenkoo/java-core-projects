package course.java_core.oop.mini_project1.lists.hotel_room_list;

import course.java_core.oop.mini_project1.lists.List;
import course.java_core.oop.mini_project1.lists.Sortable;
import course.java_core.oop.mini_project1.model.HotelRoom;

public class HotelArrayList implements List<HotelRoom>, Sortable<HotelRoom> {

    private HotelRoom[] hotelRooms = new HotelRoom[10];
    private int size = 0;

    @Override
    public void add(HotelRoom hotelRoom) {

        if (size == hotelRooms.length){
            hotelRooms = createLargerArray();
        }

        hotelRooms[size] = hotelRoom;
        size++;

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
    public HotelRoom[] sort() {


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


    // ------- helpers --------


    private HotelRoom[] createLargerArray(){
        HotelRoom[] newArray = new HotelRoom[hotelRooms.length*2];

        for (int i = 0; i < hotelRooms.length; i++) {
            newArray[i] = hotelRooms[i];
        }

        return newArray;
    }
}
