package MarcoCoscarelli.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Pizza {
    private String name;
    private double price;
    private int calories;
    private List<Topping> toppings; // Lista di toppings

    // Costruttore
    public Pizza(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.toppings = new ArrayList<>(); // Inizializza la lista di toppings
    }

    // Metodo per aggiungere un topping
    public void addTopping(Topping topping) {
        toppings.add(topping);
        this.calories += topping.getCalories(); // Aggiorna le calorie
        this.price += topping.getPrice(); // Aggiorna il prezzo
    }

    // Metodo per ottenere la descrizione della pizza
    public String getDescription() {
        StringBuilder sb = new StringBuilder(name + " (");
        for (Topping topping : toppings) {
            sb.append(topping.getName()).append(", ");
        }
        if (!toppings.isEmpty()) {
            sb.setLength(sb.length() - 2); // Rimuovi l'ultima virgola
        }
        sb.append(") - ").append(calories).append(" Calories - ").append(getFormattedPrice());
        return sb.toString();
    }

    // Metodo per ottenere il prezzo formattato
    public String getFormattedPrice() {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(price) + "€";
    }
}
