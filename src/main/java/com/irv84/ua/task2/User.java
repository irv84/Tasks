
//Refactor the code fix error, make sure code complies with Java coding standards.
// Send refactored code and add comments in code explaining each change.

//comments on refactoring
//1. Data encapsulation
//2. Default constructor deleted
//3. Changed the names of variables
//4. Changed constructor User
//5. double changed to int



package com.irv84.ua.task2;


import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class User {

    Logger logger = Logger.getLogger(User.class.toString());

    public String USER_NAME;

    public String USER_SURNAME;


    public User() {
    }

    public User(String userName) {
        this.USER_NAME = userName;
    }

    public User(String USER_NAME, String USER_SURNAME) {
        this.USER_NAME = USER_NAME;
        this.USER_SURNAME = USER_SURNAME;
    }

    Collection<Hobby> getUserHobbies(DummyDao dao) {
        logger.debug("Get " + USER_NAME + "'s hobbies from database");
        List<Hobby> hobbiesList = dao.getHobbies(USER_NAME);
        return new TreeSet<>(hobbiesList);
    }

    double calculateHobbyCosts(DummyDao dao) {
        Collection<Hobby> userHobbies = getUserHobbies(dao);

        List<Double> allCosts = new ArrayList<>();
        for (Hobby hobby : userHobbies) {
            allCosts.add(dao.getHobbyAverageCost(hobby));
        }

        double totalCosts = 0;
        for (Double cost : allCosts) {
            totalCosts = totalCosts + cost;
        }
        return totalCosts;
    }


    public boolean equals(User user) {
        return user.USER_NAME == USER_NAME && user.USER_SURNAME == USER_SURNAME;
    }

    public class Hobby {
        String name;

        public Hobby(String name) {
            this.name = name;
        }

        public Hobby() {
        }
    }

    public abstract class DummyDao {

        abstract List<User.Hobby> getHobbies(String name);

        abstract Double getHobbyAverageCost(User.Hobby name);
    }
}
