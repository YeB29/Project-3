package Model;

public class Beroep {
        private User user;
        private String name;


        public Beroep(User user, String name) {
            this.user = user;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public User getUser() {
            return user;
        }
    }

