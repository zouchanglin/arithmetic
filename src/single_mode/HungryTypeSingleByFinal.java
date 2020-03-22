package single_mode;

//饿汉式单例
public class HungryTypeSingleByFinal {
    private static final HungryTypeSingleByFinal hungryTypeSingle = new HungryTypeSingleByFinal();

    public static HungryTypeSingleByFinal getInstance(){
        return hungryTypeSingle;
    }

    private HungryTypeSingleByFinal(){}
}