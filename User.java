package Model;

import java.util.ArrayList;
import java.util.Observable;

public class User extends Observable {

    private String name;
    private String sex;
    private String dateOfBirth;
    private String username;
    private String password;
    private String email;
    private String type;
    private ArrayList<String> profession;
    private Badge badge;

    public User(String username, String password, String email, String name, String sex, String dateOfbirth, String type) {
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfbirth;
        this.username = username;
        this.password = password;
        this.email = email;
        this.type = type;
        this.profession = new ArrayList<>();
        profession.add("Villager");
        this.badge = new Badge(this);
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getType() {
        return this.type;
    }


    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public Badge getBadge(){ return badge;}
}
