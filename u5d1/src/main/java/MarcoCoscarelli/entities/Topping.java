package MarcoCoscarelli.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;

@Data
@NoArgsConstructor
public class Topping {
    private String name;
    private double price;
    private int calories;

    // Costruttore
    public Topping(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    // Metodo per ottenere il prezzo formattato
    public String getFormattedPrice() {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(price) + "€";
    }

    // Metodo per ottenere la descrizione del topping
    public String getDescription() {
        return name + " - " + calories + " Calories - " + getFormattedPrice();
    }
}

