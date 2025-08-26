package course.java_core.oop.mini_project1.lists;

public interface List<T> {

    void add(T t);
    void set(int index, T t);
    T get(int index);
    T[] getList();
    void remove(int index);
}
