package newjdk8.interfac;

public interface MyFunc{
    default String getName(){
        return "HelloWorld";
    }

    static void show(){
        System.out.println("Show Static Method");
    }
}
