import domain.Client;
import domain.Receipt;
import domain.product.Beverage;
import domain.product.Dessert;
import domain.product.Pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza("Pepperonni", 10.5));
        pizzas.add(new Pizza("Napolitana", 12.5));
        pizzas.add(new Pizza("Frutti di mare", 15.2));

        List<Dessert> desserts = new ArrayList<>();
        desserts.add(new Dessert("Tiramisu", 3.2));
        desserts.add(new Dessert("Volcan de chocolate", 4.5));
        desserts.add(new Dessert("Fresas con nata", 2.2));

        List<Beverage> beverages = new ArrayList<>();
        beverages.add(new Beverage("Coca zero", 1.2));
        beverages.add(new Beverage("Cerveza", 2.5));
        beverages.add(new Beverage("Fanta", 1.2));

        Receipt receipt = new Receipt();

        Scanner in = new Scanner(System.in);

        System.out.println("Te damos la bienvenida a DH Pizzas");

        // select pizza

        System.out.println("Que pizza te gustaría ordenar?");

        for (int i = 0; i < pizzas.size(); i++) {
            System.out.println(String.format("%d - %s: %s EUR", i + 1, pizzas.get(i).getName(), pizzas.get(i).getPrice()));
        }

        Pizza pizzaChoice = pizzas.get(in.nextInt() - 1);

        receipt.addProduct(pizzaChoice);


        // select beverage

        System.out.println("Que Bebida te gustaría ordenar?");

        for (int i = 0; i < beverages.size(); i++) {
            System.out.println(String.format("%d - %s: %s EUR", i + 1, beverages.get(i).getName(), beverages.get(i).getPrice()));
        }
        System.out.println(String.format("%d - Ninguna", beverages.size() + 1));

        int beverageOption = in.nextInt();

        if (beverageOption <= beverages.size()) {
            receipt.addProduct(beverages.get(beverageOption - 1));
        }

        // select dessert

        System.out.println("Que te gustaría ordenar de postre?");

        for (int i = 0; i < desserts.size(); i++) {
            System.out.println(String.format("%d - %s: %s EUR", i + 1, desserts.get(i).getName(), desserts.get(i).getPrice()));
        }
        System.out.println(String.format("%d - Ninguna", desserts.size() + 1));

        int dessertOption = in.nextInt();

        if (dessertOption <= desserts.size()) {
            receipt.addProduct(desserts.get(dessertOption - 1));
        }

        in.nextLine();
        // client data

        Client client = new Client();

        System.out.println("Ingrese su nombre");
        client.setName(in.nextLine());

        System.out.println("Ingrese su teléfono");
        client.setPhoneNumber(in.nextLine());

        System.out.println("Ingrese su dirección");
        client.setAddress(in.nextLine());

        receipt.setClient(client);

        receipt.print();

    }
}
