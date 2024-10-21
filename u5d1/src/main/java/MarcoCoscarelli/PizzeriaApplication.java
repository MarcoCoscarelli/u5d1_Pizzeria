package MarcoCoscarelli;

import MarcoCoscarelli.entities.Drink;
import MarcoCoscarelli.entities.Pizza;
import MarcoCoscarelli.entities.Topping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class PizzeriaApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(PizzeriaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Pizza> pizzas = context.getBean("pizzas", List.class);
        List<Drink> drinks = context.getBean("drinks", List.class);
        Scanner scanner = new Scanner(System.in);

        // Mostra il menù delle pizze
        System.out.println("Pizze:");
        for (Pizza pizza : pizzas) {
            System.out.println(pizza);
        }

        // Mostra il menù delle bevande
        System.out.println("\nBevande:");
        for (Drink drink : drinks) {
            System.out.println(drink.getName() + " - " + drink.getCalories() + " Calories - " + drink.getPrice() + "€");
        }

        // Simula un ordine
        System.out.print("Scegli una pizza (1-" + pizzas.size() + "): ");
        int pizzaChoice = scanner.nextInt();
        Pizza orderedPizza = pizzas.get(pizzaChoice - 1);

        System.out.print("Scegli una bevanda (1-" + drinks.size() + "): ");
        int drinkChoice = scanner.nextInt();
        Drink orderedDrink = drinks.get(drinkChoice - 1);

        // Aggiunta di toppings
        boolean moreToppings = true;
        while (moreToppings) {
            System.out.print("Vuoi aggiungere un topping? (1: Si, 2: No): ");
            int addTopping = scanner.nextInt();
            if (addTopping == 1) {
                System.out.print("Scegli un topping (1: Cheese, 2: Ham, 3: Onions, 4: Pineapple, 5: Salami): ");
                int toppingChoice = scanner.nextInt();
                orderedPizza.addTopping(getToppingByChoice(toppingChoice)); // Aggiungi il topping alla pizza
            } else {
                moreToppings = false;
            }
        }

        // Calcola e stampa il totale
        double totalPrice = orderedPizza.getPrice() + orderedDrink.getPrice();
        System.out.println("Hai ordinato: " + orderedPizza.getName() + " e " + orderedDrink.getName());
        System.out.println("Totale: " + totalPrice + "€");
    }

    private Topping getToppingByChoice(int choice) {
        switch (choice) {
            case 1:
                return new Topping("Cheese", 0.70, 92);
            case 2:
                return new Topping("Ham", 1.00, 35);
            case 3:
                return new Topping("Onions", 0.70, 22);
            case 4:
                return new Topping("Pineapple", 0.80, 24);
            case 5:
                return new Topping("Salami", 1.00, 86);
            default:
                throw new IllegalArgumentException("Scelta non valida");
        }
    }
}
