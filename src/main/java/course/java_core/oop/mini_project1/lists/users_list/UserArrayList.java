package course.java_core.oop.mini_project1.lists.users_list;

import course.java_core.oop.mini_project1.lists.List;
import course.java_core.oop.mini_project1.model.User;

public class UserArrayList implements List<User> {

    private User[] userArrayList = new User[10];
    private int size = 0;

    @Override
    public void add(User user) {
        if (size == userArrayList.length){
            userArrayList = createLargerArrayList();
        }

        userArrayList[size] = user;
        size++;
    }

    @Override
    public int addAndReturnIndex(User user) {
        if (size == userArrayList.length){
            userArrayList = createLargerArrayList();
        }

        userArrayList[size] = user;
        size++;

        return size;
    }


    @Override
    public void set(int index, User user) {
        userArrayList[index] = user;
    }

    @Override
    public User get(int index) {
        return userArrayList[index];
    }

    @Override
    public User[] getList() {
        return userArrayList;
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < userArrayList.length - 1; i++) {
            userArrayList[i] = userArrayList[i+1];
        }

        userArrayList[size] = null;
        size--;

    }

    @Override
    public int size() {
        return size;
    }

    //--------- helpers ---------

    private User[] createLargerArrayList() {

        User[] newUserArrayList = new User[userArrayList.length*2];

        for (int i = 0; i < userArrayList.length; i++){
            newUserArrayList[i] = userArrayList[i];
        }

        return newUserArrayList;
    }
}
