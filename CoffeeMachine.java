package machine;
import java.util.Scanner;
import static java.lang.Math.min;

public class CoffeeMachine {

    public int amountOfWater = 0;
    public int amountOfMilk = 0;
    public int amountOfCoffee = 0;
    public int amountOfCups = 0;
    public int amountOfMoney = 0;
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //allSteps();
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        chooseAction(coffeeMachine);
    }

    public static void allSteps() {
        System.out.print("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
    }

    public CoffeeMachine(int amountOfWaterInMachine, int amountOfMilkInMachine, int amountOfCoffeeInMachine, int cupsInMachine, int moneyInMachine) {
        amountOfWater = amountOfWaterInMachine;
        amountOfMilk = amountOfMilkInMachine;
        amountOfCoffee = amountOfCoffeeInMachine;
        amountOfCups = cupsInMachine;
        amountOfMoney = moneyInMachine;
    }

    public void statusOfMachine() {
        System.out.println("The coffee machine has:");
        System.out.println(amountOfWater + " ml of water");
        System.out.println(amountOfMilk + " ml of milk");
        System.out.println(amountOfCoffee + " g of coffee beans");
        System.out.println(amountOfCups + " disposable cups");
        System.out.println("$" + amountOfMoney + " of money");
    }
    public void ingredientCalculator(int waterNeeded, int milkNeeded, int coffeeNeeded, int moneyNeeded) {
        /*System.out.println("Write how many ml of water the coffee machine has: ");
        int amountOfWaterInMachine = 400;
        //System.out.println("Write how many ml of milk the coffee machine has: ");
        int amountOfMilkInMachine = 540 ;
        //System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int amountOfCoffeeInMachine = 120 ;
        int currentCups = 9 ;
        int currentMoney = 550;
        System.out.println("The coffee machine has:");
        System.out.println(amountOfWater + " ml of water");
        System.out.println(amountOfMilk + " ml of milk");
        System.out.println(amountOfCoffee + " g of coffee beans");
        System.out.println(amountOfCups + " disposable cups");
        System.out.println("$" + amountOfMoney + " of money");*/


        if (waterNeeded > amountOfWater) {
            System.out.println("Sorry, not enough water!");
        } else if (milkNeeded > amountOfMilk) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeNeeded > amountOfCoffee) {
            System.out.println("Sorry, not enough coffee!");
        } else if (amountOfCups < 1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            amountOfWater = amountOfWater - waterNeeded;
            amountOfMilk = amountOfMilk - milkNeeded;
            amountOfCoffee = amountOfCoffee - coffeeNeeded;
            amountOfMoney = amountOfMoney + moneyNeeded;
            amountOfCups = amountOfCups - 1;
        }

        /*final double oneWater = 200;
        final double oneMilk = 50;
        final double oneCoffee = 15;
        double water = howManyCups * oneWater;
        double milk = howManyCups * oneMilk;
        double coffee = howManyCups * oneCoffee;

        int howManyPossiblePortionsOfWater = (int) Math.floor(amountOfWaterInMachine / oneWater);
        int howManyPossiblePortionsOfMilk = (int) Math.floor(amountOfMilkInMachine / oneMilk);
        int howManyPossiblePortionsOfCoffee = (int) Math.floor(amountOfCoffeeInMachine / oneCoffee);
        int portionsCanBeDone = min(min(howManyPossiblePortionsOfWater, howManyPossiblePortionsOfMilk), howManyPossiblePortionsOfCoffee);

        if (portionsCanBeDone == howManyCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (portionsCanBeDone > howManyCups) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (portionsCanBeDone - howManyCups) + " more than that)");
        } else {
            System.out.println("No, I can make only " + portionsCanBeDone + " cup(s) of coffee");
        }*/
    }

    public static void buy(CoffeeMachine coffeeMachine) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: (type back to go back");
        String choice = scanner.next();
        final int espressoWater = 250;
        final int espressoMilk = 0;
        final int espressoCoffee = 16;
        final int espressoPrice = 4;
        final int latteWater = 350;
        final int latteMilk = 75;
        final int latteCoffee = 20;
        final int lattePrice = 7;
        final int capWater = 200;
        final int capMilk = 100;
        final int capCoffee = 12;
        final int capPrice = 6;
        switch (choice) {
            case "1" -> coffeeMachine.ingredientCalculator(espressoWater, espressoMilk, espressoCoffee, espressoPrice);
            case "2" -> coffeeMachine.ingredientCalculator(latteWater, latteMilk, latteCoffee, lattePrice);
            case "3" -> coffeeMachine.ingredientCalculator(capWater, capMilk, capCoffee, capPrice);
            case "back" -> chooseAction(coffeeMachine);
        }
    }

    public static void fill(CoffeeMachine coffeeMachine) {
        System.out.println("Write how many ml of water you want to add:");
        int howManyMlOfWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int howManyMlOfMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int howManyGrOfCoffee = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int howManyCupsAdd = scanner.nextInt();
        coffeeMachine.amountOfWater = coffeeMachine.amountOfWater + howManyMlOfWater;
        coffeeMachine.amountOfMilk = coffeeMachine.amountOfMilk + howManyMlOfMilk;
        coffeeMachine.amountOfCoffee = coffeeMachine.amountOfCoffee + howManyGrOfCoffee;
        coffeeMachine.amountOfCups = coffeeMachine.amountOfCups + howManyCupsAdd;
    }

    public static void take(CoffeeMachine coffeeMachine) {
        System.out.println("I gave you $" + coffeeMachine.amountOfMoney);
        coffeeMachine.amountOfMoney = 0;
    }

    public static void chooseAction(CoffeeMachine coffeeMachine) {
        Boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: (type back to go back");
                    String choice = scanner.next();
                    final int espressoWater = 250;
                    final int espressoMilk = 0;
                    final int espressoCoffee = 16;
                    final int espressoPrice = 4;
                    final int latteWater = 350;
                    final int latteMilk = 75;
                    final int latteCoffee = 20;
                    final int lattePrice = 7;
                    final int capWater = 200;
                    final int capMilk = 100;
                    final int capCoffee = 12;
                    final int capPrice = 6;
                    switch (choice) {
                        case "1":
                            coffeeMachine.ingredientCalculator(espressoWater, espressoMilk, espressoCoffee, espressoPrice);
                            break;
                        case "2":
                            coffeeMachine.ingredientCalculator(latteWater, latteMilk, latteCoffee, lattePrice);
                            break;
                        case "3":
                            coffeeMachine.ingredientCalculator(capWater, capMilk, capCoffee, capPrice);
                            break;
                        case "back":
                            continue;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    int howManyMlOfWater = scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    int howManyMlOfMilk = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int howManyGrOfCoffee = scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add: ");
                    int howManyCupsAdd = scanner.nextInt();
                    coffeeMachine.amountOfWater = coffeeMachine.amountOfWater + howManyMlOfWater;
                    coffeeMachine.amountOfMilk = coffeeMachine.amountOfMilk + howManyMlOfMilk;
                    coffeeMachine.amountOfCoffee = coffeeMachine.amountOfCoffee + howManyGrOfCoffee;
                    coffeeMachine.amountOfCups = coffeeMachine.amountOfCups + howManyCupsAdd;
                    break;
                case "take":
                    System.out.println("I gave you $" + coffeeMachine.amountOfMoney);
                    coffeeMachine.amountOfMoney = 0;
                    break;
                case "exit":
                    keepGoing = false;
                    break;
                case "remaining":
                    coffeeMachine.statusOfMachine();
                    break;
            }
        }
    }
}
