package course.java_core.basics.project5;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        EventStore store = new EventStore();
        start(store);
    }

    public static void start(EventStore eventStore){
        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.println("1 - Переглянути поточні івенти");
            System.out.println("2 - Переглянути завершені івенти");
            System.out.println("3 - Редагувати івенти");
            int option = scanner.nextInt();

            switch (option){

                case 1 -> {

                    showEvents(eventStore.events);

                }case 2 -> {

                    showEvents(eventStore.finishedEvents);

                }case 3 -> {

                    systemMenu(scanner, eventStore);

                }

            }


            System.out.println("Бажаєте продовжити? yes/no");

            if (scanner.next().equalsIgnoreCase("yes")){
                break;
            }

        }

    }

    public static void systemMenu(Scanner scanner, EventStore store){

        System.out.println("Виберіть опцію.");

        System.out.println("1 - Додати новий івент.");
        System.out.println("2 - Оновити новий івент за назвой.");
        System.out.println("3 - Видалити івент за назвой.");

        int option = scanner.nextInt();

        switch (option){
            case 1 -> {
                System.out.println("Введіть назву івенту та інформацію, яка треба для нього через кому.");
                String event = scanner.nextLine();

                store.events.add(event);
                System.out.println("Івент успішно додано.");
            }
            case 2 -> {
                System.out.println("Введіть назву івенту");
                String eventName = scanner.nextLine();

                System.out.println("Введіть дані для нового івенту.");
                String newEventData = scanner.nextLine();

                store.updateEventByName(eventName, newEventData);

            }
            case 3 -> {

                System.out.println("Введіть назву івенту.");
                String eventName = scanner.next();

                store.deleteEventByName(eventName);

            }

        }

    }

    private static void showEvents(List<String> list){
        list.forEach(System.out::println);
    }

}
