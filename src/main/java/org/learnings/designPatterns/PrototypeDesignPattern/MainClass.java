package org.learnings.designPatterns.PrototypeDesignPattern;
/*
    ref:- https://www.geeksforgeeks.org/prototype-design-pattern/
    Prototype design pattern allow us to load the objects we want into the cache and return us the cloned object every time instead of creating the new object with NEW operator
    Sometime new operator is costly while creating objects , so we simply load all object we want into cache with created with new keyword
    and from cache we get the cloned copy of it every time.
 */
public class MainClass {
    public static void main(String[] args) {

        //cache has been initialized with key(object key) and value(different object types)

        ProfessionCache.initializeProfessionCache();

        //calling getClonedProfessionInstance will return appropriate record i.e the given type but instance of new keyword we simply clone it from the existing one loaded in first step
        Profession profession = ProfessionCache.getClonedProfessionInstance(1);

        System.out.println("Hashcode of profession "+profession);
        profession.printProfession();

        Profession profession1 = ProfessionCache.getClonedProfessionInstance(2);
        System.out.println("Hashcode of profession1 "+profession1);

        profession1.printProfession();

        Profession profession2 = ProfessionCache.getClonedProfessionInstance(1);
        // once again we want Engineer object so now ,the hash code will be different which proves we get cloned object
        System.out.println("Hashcode of profession2 "+profession2);

        profession2.printProfession();

        Profession profession3 = ProfessionCache.getClonedProfessionInstance(2);
        System.out.println("Hashcode of profession3 "+profession3);

        profession3.printProfession();
    }
}
