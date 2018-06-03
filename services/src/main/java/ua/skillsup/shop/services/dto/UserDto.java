package ua.skillsup.shop.services.dto;

/**
 * Created by Aleksey on 14.04.2018.
 */
public class UserDto {

    private String firstName;
    private String lastName;
    private int age;

    public UserDto(String firstName, String lastName, int age) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public UserDto() {
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
