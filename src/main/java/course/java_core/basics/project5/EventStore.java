package course.java_core.basics.project5;

import java.util.ArrayList;
import java.util.List;

public class EventStore {

    public List<String> events = new ArrayList<>();
    public List<String> finishedEvents = new ArrayList<>();


    public boolean  updateEventByName(String eventName, String newEvent) {
        String res = "";

        for (String event: events){
            if (event.contains(eventName)){
                res = event;
            }
        }

        if (res.isEmpty()){
            System.err.println("Такого івенту немає.");
            return false;
        }else {
            events.remove(res);
            events.add(newEvent);
            System.out.println("Івент успішно оновлено.");
            return true;
        }



    }

    public void deleteEventByName(String eventName) {

        for (String event: events){
            if (event.contains(eventName)){
                events.remove(event);
                System.out.println("Івент успішно видалено.");
            }
        }
    }
}
