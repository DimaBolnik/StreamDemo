package UnSynchronApi;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
    private static Random rand = new Random();

    public Future<Double> getPriceAsync(String product) {

        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//        new Thread( () -> {
//            try {
//                double price = calculatePrice(product);
//                futurePrice.complete(price);
//            } catch (Exception e) {
//                futurePrice.completeExceptionally(e);
//            }
//        }).start();
//        return futurePrice;
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private double calculatePrice(String product) {
        delay();
        return  rand.nextDouble() * product.charAt(0) + product.charAt(1);
    }

}
