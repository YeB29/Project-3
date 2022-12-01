package Model;

import java.util.ArrayList;

public class Login {


    private static Login singleton = null;
    private ArrayList<User> accounts = Database.getInstance().getUsers();;
    private Boolean isLoggedIn = false;
    private User ingelogdeUser;


    private Login() {
        Database.getInstance();
    }

    public static Login getInstance() {
        if (singleton == null) {
            singleton = new Login();
        }
        return singleton;
    }

    public void startLogin(String username, String password) {
        for (int i = 0; i < this.accounts.size(); i++) {
            if (userExist(username, password)) {
                this.isLoggedIn = true;
                this.ingelogdeUser = this.accounts.get(i);
                break;
            }
        }

    }
    public Boolean userExist(String username,String password){
        for (int i = 0; i < this.accounts.size(); i++) {
            if (this.accounts.get(i).getUsername().equals(username) && this.accounts.get(i).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public Boolean getLoggedIn() {
        return isLoggedIn;
    }

    public User getIngelogdeUser () {
        return ingelogdeUser;
    }

    public void setLogout(){
        this.isLoggedIn = false;
        this.ingelogdeUser = null;
    }


}
