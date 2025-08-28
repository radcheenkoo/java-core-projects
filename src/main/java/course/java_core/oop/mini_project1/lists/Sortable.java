package course.java_core.oop.mini_project1.lists;

import course.java_core.oop.mini_project1.lists.hotel_room_list.HotelRoomArrayList;


public interface Sortable {

    HotelRoomArrayList sortFromMinPriceToMax();
    HotelRoomArrayList sortFromMaxPriceToMin();
}
