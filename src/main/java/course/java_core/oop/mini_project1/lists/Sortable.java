package course.java_core.oop.mini_project1.lists;

import course.java_core.oop.mini_project1.lists.hotel_room_list.HotelRoomArrayList;
import course.java_core.oop.mini_project1.model.HotelRoom;


public interface Sortable {

    HotelRoom[] sortFromMinPriceToMax();
    HotelRoom[] sortFromMaxPriceToMin();
}
