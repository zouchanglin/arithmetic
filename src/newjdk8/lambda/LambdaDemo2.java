package newjdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaDemo2 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("And", "Animal", "Basic", "ABC");
        List<String> retList = predication(stringList, (x) -> x.startsWith("A"));
        for(String str: retList) System.out.print(str + " ");
    }

    private static List<String> predication(List<String> stringList, Predicate<String> predicate) {
        return stringList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

//    public static void main(String[] args) {
//        Integer length = calcLength("Hello", (x) -> x.length());
//        System.out.println(length);
//    }
//
//    private static Integer calcLength(String string, Function<String, Integer> function) {
//        return function.apply(string);
//    }


//    public static void main(String[] args) {
//        List<Integer> integerList = supply(10, () -> (int) (Math.random() * 100));
//        integerList.forEach(System.out::println);
//    }
//
//    private static List<Integer> supply(int length, Supplier<Integer> supplier) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < length; i++)
//            list.add(supplier.get());
//        return list;
//    }


//    public static void main(String[] args) {
//        consume(100.0, (m)-> System.out.println("旅游消费金额：" + m + "元"));
//    }
//
//
//    private static void consume(double money, Consumer<Double> consumer) {
//        consumer.accept(money);
//    }
}
