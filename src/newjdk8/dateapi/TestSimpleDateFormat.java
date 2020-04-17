package newjdk8.dateapi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TestSimpleDateFormat {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Callable<LocalDate> callable = () -> LocalDate.parse("2020-04-17", dateTimeFormatter);

        List<Future<LocalDate>> futureList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            futureList.add(executorService.submit(callable));
        }

        for(Future<LocalDate> dateFuture: futureList){
            System.out.println(dateFuture.get());
        }
        executorService.shutdown();
    }

//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        Callable<Date> callable = () -> DateFormatThreadLocal.convert("2020-04-17");
//        List<Future<Date>> futureList = new ArrayList<>();
//
//        for (int i = 0; i < 20; i++) {
//            futureList.add(executorService.submit(callable));
//        }
//
//        for(Future<Date> dateFuture: futureList){
//            System.out.println(dateFuture.get());
//        }
//        executorService.shutdown();
//    }
}
