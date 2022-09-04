package domain;

import domain.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Receipt {
    private Client client;
    private long totalPriceInCents = 0;
    private List<Product> products = new ArrayList<>();

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getTotalPrice() {
        return Double.valueOf(totalPriceInCents) / 100;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
        int productPriceInCents = (int) (product.getPrice() * 100);
        totalPriceInCents += productPriceInCents;
    }

    public void print() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("");
        joiner.add("Datos del cliente:");
        joiner.add(String.format("Nombre: %s", client.getName()));
        joiner.add(String.format("Teléfono: %s", client.getPhoneNumber()));
        joiner.add(String.format("Dirección: %s", client.getAddress()));
        joiner.add("");

        joiner.add("Pedido:");

        for (Product product : products) {
            joiner.add(String.format("%s --------------- %4.2f EUR", product.getName(), product.getPrice()));
        }
        joiner.add("");

        joiner.add(String.format("TOTAL: %4.2f EUR", getTotalPrice()));

        System.out.println(joiner);
    }
}
