package models.users;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends User {

    public Admin(String name, String username) {
        super(name, username);
    }

    public Admin() {
    }
}
