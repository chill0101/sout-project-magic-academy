package users;

import academy.SkillLevel;

public class Director extends Person {
     private static Director instance = null;

     private Director(String fullName, SkillLevel skillLevel) {
         super(fullName, skillLevel);
     }

        public static Director getInstance(String fullName) {
            if (instance == null) {
                instance = new Director(fullName, SkillLevel.ISTARI);
                System.out.println(">>>>>>>>>>> Director instance created");
            } else {
                System.out.println(">>>>>>>>>>> Director instance already exists");
            }
            return instance;
        }


// This class is a singleton, so the constructor is private









}
