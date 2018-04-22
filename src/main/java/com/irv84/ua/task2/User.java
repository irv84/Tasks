
//Refactor the code fix error, make sure code complies with Java coding standards.
// Send refactored code and add comments in code explaining each change.

//comments on refactoring
//1. Changed the names of variables
//2. Default constructor deleted (User, Hobby)
//3. Changed constructor User (String name)
//4. Data encapsulation (public changed to private, added Setters and Getters)
//5. double changed to int
//6. changed method calculateHobbyCosts
//7. Override method equals
//8. Override method hashCode


package com.irv84.ua.task2;

import org.apache.log4j.Logger;

import java.util.*;

public class User {

    private Logger logger = Logger.getLogger(User.class.toString());

    private String userName; //public String USER_NAME;
    private String userSurname; //public String USER_SURNAME;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    //deleted
//    public User() {
//    }

//    public User(String userName) {
//        this.USER_NAME = userName;
//        }

        public User(String userName) {
        this.userName = userName;
        this.userSurname=null;
        }

//    public User(String USER_NAME, String USER_SURNAME) {
//        this.USER_NAME = USER_NAME;
//        this.USER_SURNAME = USER_SURNAME;
//    }

    public User(String userName, String userSurname) {
        this.userName = userName;
        this.userSurname = userSurname;
    }

    Collection<Hobby> getUserHobbies(DummyDao dao) {
        logger.debug("Get " + userName + "'s hobbies from database");
        TreeSet<Hobby> hobbiesList = dao.getHobbies(userName);//List<Hobby> hobbiesList = dao.getHobbies(userName);
        logger.debug("No. of hobby: " + hobbiesList.size());
        return hobbiesList;//return new TreeSet<>(hobbiesList);
    }

    double calculateHobbyCosts(DummyDao dao) {
        logger.debug("Get " + userName + "'s hobbies from database");
        Collection<Hobby> userHobbies = getUserHobbies(dao);

//        List<Double> allCosts = new ArrayList<>();
//        for (Hobby hobby : userHobbies) {
//            allCosts.add(dao.getHobbyAverageCost(hobby));
//        }
//
//        double totalCosts = 0;
//        for (Double cost : allCosts) {
//            totalCosts = totalCosts + cost;
//        }
        logger.debug("Calculate hobbies coast for user name " + userName );
        double totalCosts=0;
        for (Hobby hobby:userHobbies){
            totalCosts=totalCosts+dao.getHobbyAverageCost(hobby);
        }
        logger.debug("Hobbies for user name " + userName + " coasts "+totalCosts);
        return totalCosts;
    }


//    public boolean equals(User user) {
//        return user.USER_NAME == USER_NAME && user.USER_SURNAME == USER_SURNAME;
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)return true;
        if (obj == null)return false;
        if (!(obj instanceof User))return false;
        User other = (User) obj;
        return
                Objects.equals(userName, other.userName) &&
                Objects.equals(userSurname, other.userSurname);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (userName == null ? 0 : userName.hashCode());
        result = 37 * result + (userSurname == null ? 0 : userSurname.hashCode());
        return result;
    }


    public class Hobby {
        private String name;//String name;

        public Hobby(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        // Deleted
// public Hobby() {
//        }
    }

    public abstract class DummyDao {

        abstract TreeSet<Hobby> getHobbies(String name);// abstract List<User.Hobby> getHobbies(String name);

        abstract Double getHobbyAverageCost(User.Hobby name);
    }
}

