package org.learnings.designPatterns.PrototypeDesignPattern;

import java.util.Hashtable;

public class ProfessionCache {
    private static final Hashtable<Integer,Profession> professionHashtable = new Hashtable<>();

    /*
        return the cloned instance using clone() method of object class
     */
    public static Profession getClonedProfessionInstance(int id){
        Profession  professionCache = professionHashtable.get(id);
        return professionCache.clone();
    }

    /*
        initialize all types in memory once we load the application lets suppose. So afterward we don't need new keyword again
     */
    public static void initializeProfessionCache(){
        Engineer engineer = new Engineer();
        engineer.setId(1);
        engineer.setName("Sample Engineer 1");

        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("Sample Teacher 1");

        professionHashtable.put(1,engineer);
        professionHashtable.put(2,teacher);
    }
}
