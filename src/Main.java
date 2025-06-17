import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Вывод всех транзакций для проверки
//        for (Transaction t : transactions) {
//            System.out.println(t);
//        }

//        1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
//
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
//        2. Вывести список неповторяющихся городов, в которых работают трейдеры.
//
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
//        3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
//
        transactions.stream()
                .map(t -> t.getTrader())
                .distinct()
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
//        4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
//
        transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);
//        5. Выяснить, существует ли хоть один трейдер из Милана.
//
        transactions.stream()
                .map(t -> t.getTrader())
                .filter(t -> t.getCity().equals("Milan"))
                .findAny().ifPresent(System.out::println);
//        6. Вывести суммы всех транзакций трейдеров из Кембриджа.
//
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getValue())
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
//        7. Какова максимальная сумма среди всех транзакций?
//
        transactions.stream()
                .map(t -> t.getValue())
                .reduce(Integer::max)
                .ifPresent(System.out::println);
//        8. Найти транзакцию с минимальной суммой.
        transactions.stream()
                .map(t -> t.getValue())
                .reduce(Integer::min)
                .ifPresent(System.out::println);
    }
}