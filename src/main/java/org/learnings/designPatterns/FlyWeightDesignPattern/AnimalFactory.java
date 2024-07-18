package org.learnings.designPatterns.FlyWeightDesignPattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnimalFactory {

    private static final HashMap<String,Animal> animalHashMap = new HashMap<>();

    private static final String[] animals = {"cat","dog"};
    public static Animal getAnimal(String animalName) throws Exception {
        List<String> matchedAnimal = Arrays.stream(animals).filter((name) -> name.equalsIgnoreCase(animalName)).toList();
        if(matchedAnimal.isEmpty()){
            throw new Exception("No animals with such name exist in factory");
        }else{
            final boolean animalExists = animalHashMap.containsKey(matchedAnimal.get(0));
            if(animalExists) {
                return animalHashMap.get(matchedAnimal.get(0));
            } else {
                String animalType = matchedAnimal.get(0);
                if (animalType.equals("cat")) {
                    final Cat cat = new Cat("cat");
                    animalHashMap.put(animals[0], cat);
                    return cat;
                } else {
                    final Dog dog = new Dog("dog");
                    animalHashMap.put(animals[0], dog);
                    return dog;
                }
            }
        }
    }
}
