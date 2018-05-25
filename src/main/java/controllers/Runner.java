package controllers;

import db.DBHelper;
import models.users.Customer;

public class Runner {


    public static void main(String[] args) {

        Customer customer1 = new Customer("Daniel", "User1");
        DBHelper.save(customer1);
    }
}
