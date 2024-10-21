package MarcoCoscarelli.Config;

import MarcoCoscarelli.entities.Drink;
import MarcoCoscarelli.entities.Pizza;
import MarcoCoscarelli.entities.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MenuConfig {
    @Bean
    public List<Pizza> pizzas() {
        List<Pizza> pizzas = new ArrayList<>();
        Pizza margherita = new Pizza("Pizza Margherita", 5.00, 1104);
        Pizza hawaiian = new Pizza("Hawaiian Pizza", 6.50, 1024);
        Pizza salami = new Pizza("Salami Pizza", 6.00, 1160);

        // Aggiunta dei toppings
        margherita.addTopping(new Topping("Cheese", 0.70, 92));
        hawaiian.addTopping(new Topping("Cheese", 0.70, 92));
        hawaiian.addTopping(new Topping("Ham", 1.00, 35));
        hawaiian.addTopping(new Topping("Pineapple", 0.80, 24));
        salami.addTopping(new Topping("Cheese", 0.70, 92));
        salami.addTopping(new Topping("Salami", 1.00, 86));

        pizzas.add(margherita);
        pizzas.add(hawaiian);
        pizzas.add(salami);
        return pizzas;
    }

    @Bean
    public List<Drink> drinks() {
        List<Drink> drinks = new ArrayList<>();
        drinks.add(new Drink("Lemonade", 1.30, 128));
        drinks.add(new Drink("Water", 1.30, 0));
        drinks.add(new Drink("Wine", 7.50, 607));
        return drinks;
    }
}
