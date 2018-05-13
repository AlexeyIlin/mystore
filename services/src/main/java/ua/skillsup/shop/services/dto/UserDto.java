package ua.skillsup.shop.services.dto;

/**
 * Created by Aleksey on 14.04.2018.
 */
public class UserDto {

    private String FirstName;
    private String LastName;
    private int age;

    public UserDto(String firstName, String lastName, int age) {

        FirstName = firstName;
        LastName = lastName;
        this.age = age;
    }


    @Override
    public String toString() {
        return "UserDto{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getAge() {
        return age;
    }



    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
