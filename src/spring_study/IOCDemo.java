package spring_study;

public class IOCDemo {
    public static void main(String[] args) {
        Luggage luggage = new Luggage();
    }
}

//行李箱
class Luggage{
    private Framework framework;
    public Luggage(){
        this.framework = new Framework();
    }
}

//箱体
class Framework{
    private Bottom bottom;
    public Framework(){
        this.bottom = new Bottom();
    }
}

//底盘
class Bottom{
    private Tire tire;
    public Bottom(){
        this.tire = new Tire();
    }
}

//轮子
class Tire{
    private int size;
    public Tire(){
        this.size = 20;
    }
}