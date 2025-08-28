package course.java_core.oop.mini_project1;

import course.java_core.oop.mini_project1.lists.hotel_room_list.HotelRoomArrayList;
import course.java_core.oop.mini_project1.lists.users_list.UserArrayList;
import course.java_core.oop.mini_project1.model.HotelRoom;
import course.java_core.oop.mini_project1.model.User;

import java.time.LocalDateTime;
import java.util.Scanner;

public class HotelRoomService {

    private static UserArrayList userArrayList = new UserArrayList();
    private static HotelRoomArrayList hotelRoomArrayList = new HotelRoomArrayList();

    public static void main(String[] args) {
        addHotelsRoom();
        start();
    }

    /// *
    /// - Кімнати з різними типами та цінами.
    /// - Бронювання, скасування, пошук.
    /// */

    private static void addHotelsRoom() {
        hotelRoomArrayList.add(new HotelRoom("Martino", 1, TypeHotelRoom.SINGLE_STANDART, 500.00, false));
        hotelRoomArrayList.add(new HotelRoom("Martino", 2, TypeHotelRoom.DOUBLE_STANDART, 1000.00, false));
        hotelRoomArrayList.add(new HotelRoom("Martino", 3, TypeHotelRoom.TRIPLE_MINIMUM, 1000.00, false));
        hotelRoomArrayList.add(new HotelRoom("Martino", 4, TypeHotelRoom.DOUBLE_LUX, 2500.00, false));
        hotelRoomArrayList.add(new HotelRoom("Martino", 5, TypeHotelRoom.SINGLE_LUX, 1500.00, false));
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Доброго дня. Скажіть як вас звати.");
            String firstName = scanner.next();
            System.out.println("Скажіть вашу фамілію.");
            String lastName = scanner.next();

            User user = new User(firstName, lastName);

            System.out.println("Виберіть, як відсортувати:");
            System.out.println("1 - Від найдешевшого до найдорожчого.");
            System.out.println("2 - Від найдорожчого до найдешевшого.");
            System.out.println("3 - За типом кімнати.");
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    HotelRoom[] availableRooms = checkAndReturnAvailableRooms().sortFromMinPriceToMax();
                    userCommunication(availableRooms, scanner, user);
                }
                case 2 -> {
                    HotelRoom[] availableRooms = checkAndReturnAvailableRooms().sortFromMaxPriceToMin();
                    userCommunication(availableRooms, scanner, user);
                }
                case 3 -> filterByType(scanner, user);
                default -> System.out.println("Невірний вибір!");
            }
        }
    }

    private static void filterByType(Scanner scanner, User user) {
        System.out.println("Доступні типи:");
        for (TypeHotelRoom type : TypeHotelRoom.values()) {
            System.out.println(type.name());
        }

        System.out.println("Введіть точно так само той вид, який вам треба:");
        String type = scanner.next();

        TypeHotelRoom chosenType;
        try {
            chosenType = TypeHotelRoom.valueOf(type);
        } catch (IllegalArgumentException e) {
            System.out.println("Неправильний тип кімнати!");
            return;
        }

        HotelRoomArrayList arrayList = checkAndReturnAvailableRooms();
        if (arrayList.size() == 0) {
            System.out.println("Вільних місць немає.");
            return;
        }

        HotelRoomArrayList res = new HotelRoomArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).typeHotelRoom().equals(chosenType)) {
                res.add(arrayList.get(i));
            }
        }

        if (res.size() == 0) {
            System.out.println("Немає вільних кімнат цього типу.");
            return;
        }

        HotelRoom[] filteredRooms = new HotelRoom[res.size()];
        for (int i = 0; i < res.size(); i++) {
            filteredRooms[i] = res.get(i);
        }

        userCommunication(filteredRooms, scanner, user);
    }

    private static void userCommunication(HotelRoom[] availableRooms, Scanner scanner, User user) {
        if (availableRooms.length == 0) {
            System.out.println("Вільних кімнат немає!");
            return;
        }

        for (int i = 0; i < availableRooms.length; i++) {
            System.out.println(i + " -> " + availableRooms[i].toString());
        }

        System.out.println("Виберіть зі списку та введіть номер (починаючи з нуля):");
        int index = scanner.nextInt();

        if (index < 0 || index >= availableRooms.length) {
            System.out.println("Невірний номер!");
            return;
        }

        HotelRoom chosenRoom = availableRooms[index];
        bookRoom(user, chosenRoom, scanner);
        userArrayList.add(user);
    }

    private static void bookRoom(User user, HotelRoom room, Scanner scanner) {
        System.out.println("Введіть кількість днів на яку хочете забронювати:");
        int amountOfDays = scanner.nextInt();

        user.setHotelRoom(room);
        user.setStartOccupancy(LocalDateTime.now());
        user.setEndOccupancy(LocalDateTime.now().plusDays(amountOfDays));

        System.out.println("Ви забронювали: " + room.toString());
    }

    private static HotelRoomArrayList checkAndReturnAvailableRooms() {
        HotelRoomArrayList occupiedRooms = new HotelRoomArrayList();
        for (int i = 0; i < userArrayList.size(); i++) {
            if (userArrayList.get(i).getHotelRoom() != null) {
                occupiedRooms.add(userArrayList.get(i).getHotelRoom());
            }
        }

        HotelRoomArrayList availableRooms = new HotelRoomArrayList();
        for (int i = 0; i < hotelRoomArrayList.size(); i++) {
            HotelRoom room = hotelRoomArrayList.get(i);
            boolean isOccupied = false;
            for (int j = 0; j < occupiedRooms.size(); j++) {
                if (room.equals(occupiedRooms.get(j))) {
                    isOccupied = true;
                    break;
                }
            }
            if (!isOccupied) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}

