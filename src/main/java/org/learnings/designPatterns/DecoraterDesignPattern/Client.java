package org.learnings.designPatterns.DecoraterDesignPattern;

interface Pizza {
    int getCost();

    void getDescription();
}

class Marghreta implements Pizza {

    @Override
    public int getCost() {
        return 10;
    }

    @Override
    public void getDescription() {
        System.out.println("This is Marghreta Pizza");
    }

}

class CountryDelight implements Pizza {

    @Override
    public int getCost() {
        return 20;
    }

    @Override
    public void getDescription() {
        System.out.println("This is CountryDelight Pizza");
    }

}

abstract class PizzaDecorator implements Pizza {
    Pizza pizza;

    PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}

class ExtraCheeseDecorator extends PizzaDecorator {

    ExtraCheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 4; /* Adding the extra cheese takes $4 */
    }

    @Override
    public void getDescription() {
        System.out.println(this.pizza + "is decorated with ExtraCheeseDecorator feature");
    }

}

class ThinCrustBaseDecorator extends PizzaDecorator {

    ThinCrustBaseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 3; /* Adding the ThinCrust takes extra $3 */
    }

    @Override
    public void getDescription() {
        System.out.println(this.pizza + "is decorated with ThinCrustBaseDecorator feature");
    }

}

class Client {
    public static void main(String[] args) {
        Marghreta marghreta = new Marghreta();
        /*
         * Add new decorator feature on Marghreta to make it marghreta with extra cheese
         */
        ExtraCheeseDecorator extraCheeseDecoratorPizza = new ExtraCheeseDecorator(marghreta);
        extraCheeseDecoratorPizza.getDescription();
        System.out.println("Total Cost of adding extra cheese: " + extraCheeseDecoratorPizza.getCost());

        /*
         * Add new feature on Marghreta with extra cheese to make marghreta with extra
         * cheese with thin crust
         */
        ThinCrustBaseDecorator thinCrustBaseDecoratorPizza = new ThinCrustBaseDecorator(extraCheeseDecoratorPizza);
        thinCrustBaseDecoratorPizza.getDescription();
        System.out.println("Total Cost of adding thin crust is:" + thinCrustBaseDecoratorPizza.getCost());

    }
}