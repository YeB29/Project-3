package Model;

import java.util.ArrayList;

public class Database {

    private static Database singleton = null;
    private ArrayList<User> Users;

    private Database() {
        ArrayList<String> professions = new ArrayList<>();
        professions.add("woodworking");
        professions.add("painting");
        this.Users = new ArrayList<>();

        User Admin = new User("Admin", "Admin", "Admin@Admin.com", "Admin", "M","01/01/2000", "User");
        User toon = new User("antonio", "hallo1", "toontje@toon.com", "Toon Langendam", "M", "23/05/1998", "User");
        User jan = new User("jantje","hallo1", "jantje@jan.com", "Jan Glazenborg","M","23/08/1998", "User");


        this.Users.add(Admin);
        this.Users.add(toon);
        this.Users.add(jan);



    }

    public static Database getInstance() {
        if (singleton == null) {
            singleton = new Database();
        }
        return singleton;
    }


    public ArrayList<User> getUsers(){
        return Users;
    }

    public void addUser(User user){
        this.Users.add(user);
    }
}
