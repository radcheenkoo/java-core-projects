package course.java_core.basics.project4;

import java.util.HashMap;
import java.util.Map;

public class CafeDB {

    private Map<String, Double> menu = new HashMap<>();

    public void addDish(String name, Double price){

        if (menu.containsKey(name)){
            System.err.println("Така страва вже існує.");
        }else {
            menu.put(name, price);
        }
    }

    public void updateDish(String oldName, String newName, Double price){

        if (oldName.contains(oldName)){
            menu.remove(oldName);
            menu.put(newName, price);
        }else {
            System.err.println("Такого запису не існує.");
        }
    }

    public void deleteDish(String name){

        if(menu.containsKey(name)){
            menu.remove(name);
        }else {
            System.err.println("Запису з таким іменем: " + name +  " немає");
        }
    }

    public Double getDishByName(String name){

        if (menu.containsKey(name)){
            return menu.get(name);
        }else {
            System.err.println("Запису з таким іменем: " + name +  " немає");
            return null;
        }
    }

    public Map<String, Double> getMenu(){
        return menu;
    }

}
