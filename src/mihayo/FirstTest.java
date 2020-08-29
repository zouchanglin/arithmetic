package mihayo;

import java.util.Scanner;

public class FirstTest {
    public static void main(String[] args) {
        // 拿数据
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strings = line.split(" ");
        int a = Integer.parseInt(strings[0].split("/")[0]);
        int b = Integer.parseInt(strings[0].split("/")[1]);
        String operator = strings[1];
        int c = Integer.parseInt(strings[2].split("/")[0]);
        int d = Integer.parseInt(strings[2].split("/")[1]);

        System.out.println(a + " " + b + " "
                + c + " " + d + " " + operator);

        // a/b + c/d
        int mu = 0;
        int zi = 0;
        String ret = null;
        // 确定底数第一步
        if(b == d){
            mu = b;
        }else{
            mu = b * d;
        }

        switch (operator){
            case "+":
                zi = a * d + c * b;
                ret = toEasy(zi, mu);
                break;
            case "-":
                zi = a * d - c * b;
                ret = toEasy(zi, mu);
                break;
            case "*":
                zi = a * c;
                mu = b * d;
                ret = toEasy(zi, mu);
                break;
            case "/":
                zi = (a * d) / (c * b);
                mu = b * d;
                ret = toEasy(zi, mu);
                break;
            default:
        }
        System.out.println(ret);
    }

    private static String toEasy(int zi, int mu) {
        //2/8
        if(zi == mu) return "1";
        String tmpRet;
        int zzi = Math.abs(zi);
        int mmu = Math.abs(mu);
        if(zzi > mmu){
            if(zzi % (double)mmu < 0.00001F)
                tmpRet = String.valueOf(zzi / mmu);//整数
            else
                tmpRet = zzi + "/" + mmu;
        }else if(zzi == mmu){
            tmpRet = "1";
        }else {
            if (mmu % (double) zzi < 0.00001F) {
                int x = mmu / zzi;
                tmpRet = toEasy(zzi, x) + "/" + toEasy(mmu, x);
            }else {
                tmpRet = zzi + "/" + mmu;
            }
        }

        if(zi * mu < 0){
            tmpRet = "-" + tmpRet;
        }
        return tmpRet;
    }
}
