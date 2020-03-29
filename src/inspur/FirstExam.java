package inspur;

import java.util.Scanner;

public class FirstExam {
    //调整石头位置问题
    public static void main1(String[] args) {
        int n, num  =  1, ret  =  1;
        Scanner scanner  =  new Scanner(System.in);
        n  =  scanner.nextInt();

        int[] r  =  new int[n];
        int[] r1  =  new int[n];

        scanner.nextLine();
        String[] split  =  scanner.nextLine().split(" ");
        for (int i  =  0; i < split.length; i++) {
            r[i]  =  Integer.parseInt(split[i]);
        }

        for (int i  =  0; i < n; i++) {
            r1[i]  =  r[i];
            for (int j  =  i + 1; j < n; j++) {
                r1[j]  =  r[j];
                if (r1[i] + 1  ==  r1[j]) {
                    num  =  num + 1;
                    r1[i]  =  r1[j];
                }
            }
            if (num > ret) {
                ret  =  num;
            }
            num  =  1;
        }
        System.out.println(n - ret);
    }

    //道路两边的树的问题
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[101];
        for(int i = 1; i <= 100; i++) {
            arr2[i] =  1;
        }
        for(int i = 0; i<n; i++) {
            arr1[i]  =  scanner.nextInt();
            arr2[arr1[i]]  =  0;
        }
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for(int i = 1;i <= 100;i++) {
            if(i%2 != 0) {
                if(arr2[i] == 0) {
                    sb1.append(" ");
                }else{
                    if(i<10) {
                        sb1.append("00");
                        sb1.append(i);
                    } else if(i<100){
                        sb1.append("0");
                        sb1.append(i);
                    } else sb1.append(i);
                }
            } else {
                if(arr2[i] == 0) {
                    sb2.append(" ");
                } else {
                    if(i < 10) {
                        sb2.append("00");
                        sb2.append(i);
                    } else if(i < 100){
                        sb2.append("0");
                        sb2.append(i);
                    } else sb2.append(i);
                }
            }
        }

        int max = 0;
        String start = "";
        String[] s1 = sb1.toString().split(" ");
        String[] s2 = sb2.toString().split(" ");
        for(int i = 0; i<s1.length; i++) {
            if(max < s1[i].length()) {
                max = s1[i].length();
                start = s1[i].substring(0, 3);
            }
        }
        for(int i = 0; i<s2.length; i++) {
            if(max<s2[i].length()) {
                max = s2[i].length();
                start = s2[i].substring(0, 3);
            }
        }
        String ret = Integer.parseInt(start) + " " + max / 3;
        System.out.println(ret);
    }
}