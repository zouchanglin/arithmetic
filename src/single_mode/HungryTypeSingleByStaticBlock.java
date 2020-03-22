package single_mode;

//饿汉式单例
public class HungryTypeSingleByStaticBlock {
    private static HungryTypeSingleByStaticBlock hungryTypeSingleByStaticBlock;
    static {
        hungryTypeSingleByStaticBlock = new HungryTypeSingleByStaticBlock();
    }
    private HungryTypeSingleByStaticBlock(){}

    public static HungryTypeSingleByStaticBlock getInstance(){
        return hungryTypeSingleByStaticBlock;
    }
}