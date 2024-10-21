package MarcoCoscarelli.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Menu {
    private List<Pizza> pizzas;
    private List<Drink> drinks;
    private List<Topping> toppings;

    public void printMenu() {
        System.out.println("Pizzas:");
        for (Pizza pizza : pizzas) {
            System.out.printf("%s - %d Calories - %s\n", pizza.getDescription(),
                    pizza.getCalories(), pizza.getFormattedPrice());
        }

        System.out.println("\nDrinks:");
        for (Drink drink : drinks) {
            System.out.printf("%s - %d Calories - %s\n", drink.getName(),
                    drink.getCalories(), drink.getFormattedPrice());
        }

        // Sezione per i toppings
        System.out.println("\nToppings:");
        for (Topping topping : toppings) {
            System.out.printf("%s - %d Calories - %s\n", topping.getName(),
                    topping.getCalories(), topping.getFormattedPrice());
        }
    }
}


