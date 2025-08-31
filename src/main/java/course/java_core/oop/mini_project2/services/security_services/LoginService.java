package course.java_core.oop.mini_project2.services.security_services;

public interface LoginService<T> {

    T login(String username, String password);


}
