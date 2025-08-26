package course.java_core.oop.mini_project1.model;

import java.util.Objects;

public class User {

    private String firstName;
    private String lastName;
    private HotelRoom hotelRoom;
    private String feedback;

    public User() {}

    public User(String firstName, String lastName, HotelRoom hotelRoom, String feedback) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hotelRoom = hotelRoom;
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hotelRoom=" + hotelRoom +
                ", feedback='" + feedback + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(hotelRoom, user.hotelRoom) && Objects.equals(feedback, user.feedback);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, hotelRoom, feedback);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public HotelRoom getHotelRoom() {
        return hotelRoom;
    }

    public void setHotelRoom(HotelRoom hotelRoom) {
        this.hotelRoom = hotelRoom;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
