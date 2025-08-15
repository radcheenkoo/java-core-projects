package course.java_core.basics.project4;

import java.util.HashMap;
import java.util.Map;

public class CafeDB {

    private Map<String, Double> menu = new HashMap<>();

    public void addDish(String name, Double price){

        if (menu.containsKey(name)){
            System.err.println("Such a dish already exists.");
        }else {
            menu.put(name, price);
        }
    }

    public void updateDish(String oldName, String newName, Double price){

        if (oldName.contains(oldName)){
            menu.remove(oldName);
            menu.put(newName, price);
        }else {
            System.err.println("There is no such record.");
        }
    }

    public void deleteDish(String name){

        if(menu.containsKey(name)){
            menu.remove(name);
        }else {
            System.err.println("Entry with this name: " + name +  " none");
        }
    }

    public Double getDishPriceByName(String name){

        if (menu.containsKey(name)){
            return menu.get(name);
        }else {
            System.err.println("Entry with this name: " + name +  " none");
            return null;
        }
    }

    public boolean existsDishByName(String name){
        return menu.containsKey(name);
    }

    public Map<String, Double> getMenu(){
        return menu;
    }

}
