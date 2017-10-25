package lamda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by shuming.wang on 2017/9/27.
 */
public class TestLamda {
    public static class Trader{
        private final String name;
        private final String city;
        public Trader(String n, String c){
            this.name = n;
            this.city = c;
        }
        public String getName(){
            return this.name;
        }
        public String getCity(){
            return this.city;
        }
        @Override
        public String toString(){
            return "Trader:"+this.name + " in " + this.city;
        }
    }
    public static class Transaction{
        private final Trader trader;
        private final int year;
        private final int value;
        public Transaction(Trader trader, int year, int value){
            this.trader = trader;
            this.year = year;
            this.value = value;
        }
        public Trader getTrader(){
            return this.trader;
        }
        public int getYear(){
            System.out.println("getYear");
            return this.year;
        }
        public int getValue(){
            System.out.println("getValue");
            return this.value;
        }
        @Override
        public String toString(){
            return "{" + this.trader + ", " +
                "year: "+this.year+", " +
                "value:" + this.value +"}";
        }
    }
    public static void test1(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );

        //1. Find all transactions in the year 2011 and sort them by value (small to high).
        transactions.parallelStream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).forEach(t -> System.out.println(t));
        //2. What are all the unique cities where the traders work?
        //transactions.stream().map(t -> t.getTrader().getCity()).distinct().forEach(t -> System.out.println(t));
        //3. Find all traders from Cambridge and sort them by name.
        //transactions.stream().map(t -> t.getTrader()).filter(t -> t.getCity().equals("Cambridge")).distinct().sorted(Comparator.comparing(Trader::getName)).forEach(t -> System.out.println(t));
        //4. Return a string of all traders’ names sorted alphabetically.
        //System.out.println(transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().reduce("", (a, b) -> a+b));
        //5. Are any traders based in Milan?
        //System.out.println(transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan")));
        //6. Print all transactions’ values from the traders living in Cambridge.
        //transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).forEach(t -> System.out.println(t.getValue()));
        //7. What’s the highest value of all the transactions?
        //System.out.println(transactions.stream().max(Comparator.comparing(Transaction::getValue)));
        //8. Find the transaction with the smallest value.
        //System.out.println(transactions.stream().map(t -> t.getValue()).reduce(Integer::min));

    }
    public static void testLang(){
        System.out.println(3.0 % 1);
        System.out.println(3.1 % 1);
        System.out.println(1.0 % 1);
        System.out.println(1.00000009 % 1);
    }
    public static void test2(){
        IntStream.rangeClosed(1, 10)
            .filter(b -> Math.sqrt(b*b) % 1 == 0).
            boxed().map(b -> new int[]{b, (int) Math.sqrt(b * b)}).forEach(t -> System.out.println(t[0] +"," + t[1]));
        String str = "123";
        Stream.of(str).map(s -> s.split("")).flatMap(Arrays::stream).forEach(t -> System.out.println(t));
        System.out.println(Stream.of(str).count());
    }
    public static boolean isPrime(int candidate) {
        return IntStream.range(2, candidate).noneMatch(i -> candidate % i  == 0);
    }
    public static long sum(long a, long b) {
        System.out.print("ab");
        return a + b;
    }
    public static void test3() {
        //Map<Boolean, List<Integer>> x = IntStream.range(2, 20).boxed().collect(Collectors.partitioningBy(TestLamda::isPrime));
        System.out.println(Stream.iterate(1L, i -> { System.out.print(Thread.currentThread().getId());return i + 1;}).limit(4).reduce(0L, TestLamda::sum));
    }
    public static  void main(String[] arg){

        TestLamda.test3();
    }
}
