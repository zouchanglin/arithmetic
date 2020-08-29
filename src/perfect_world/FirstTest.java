package perfect_world;

import java.util.*;

public class FirstTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int knapsackCapacity = Integer.parseInt(input.nextLine().trim());

        String[] volumesStr = input.nextLine().split(" ");
        int[] volumes = new int[volumesStr.length];
        for (int i = 0; i < volumesStr.length; i++) {
            volumes[i] = Integer.parseInt(volumesStr[i].trim());
        }

        String[] valuesStr = input.nextLine().split(" ");
        int[] values = new int[valuesStr.length];
        for (int i = 0; i < valuesStr.length; i++) {
            values[i] = Integer.parseInt(valuesStr[i].trim());
        }

        if (volumes.length == values.length) {
            System.out.println(method(knapsackCapacity, volumes, values));
        }else {
            System.out.println("道具数量不一致。");
        }
        input.close();
    }

    // 5mm³   30￥
    private static int method(int knapsackCapacity, int[] volumes, int[] values) {
        int ret = 0;//价值
        int capa;//容量
        double[] vae = new double[values.length];
        Map<Double, X> map = new HashMap<>();
        for (int i = 0; i < volumes.length; i++) {
            vae[i] = values[i] / (volumes[i] * 1.0);
            map.put(vae[i], new X(values[i], volumes[i]));
        }
        Arrays.sort(vae);
        for (int i = vae.length - 1; i >= 0 ; i--) {
            X x = map.get(vae[i]);
            if(knapsackCapacity - x.getV() > 0){
                knapsackCapacity -= x.getV();
                ret += x.getMoney();
            }
        }
        return ret;
    }
}


class X{
    int money;
    int v;

    public X(int money, int v) {
        this.money = money;
        this.v = v;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
