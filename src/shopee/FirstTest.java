package shopee;

import java.util.Scanner;

public class FirstTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(handle(sc.nextLine()));
    }

    private static String handle(String nextLine) {
        char[] strChar = nextLine.toCharArray();
        char firstChar = strChar[0];
        if('a' <= firstChar && firstChar <= 'z'){
            //hello_world -> helloWorld
            StringBuilder builder = new StringBuilder();
            boolean change = false;
            for (int i = 0; i < strChar.length; i++) {
                if(i == 0){
                    builder.append(strChar[i]);
                }else{
                    switch (getType(strChar[i])){
                        case X: {
                            if(change){
                                builder.append(Character.toUpperCase(strChar[i]));
                                change = false;
                            }else {
                                builder.append(strChar[i]);
                            }
                        } break;

                        case Q: {
                            change = true;
                        } break;

                        case S: {
                            builder.append(strChar[i]);
                        } break;
                    }
                }
            }
            return builder.toString();
        }else if('A' <= firstChar && firstChar <= 'Z'){
            // CapitalizedWords -> capitalizedwords
            // This is a Demo! -> thisIsADemo
            // This is 5th example -> thisIs5thExample
            StringBuilder builder = new StringBuilder();
            boolean change = false;
            for (int i = 0; i < strChar.length; i++) {
                if(i == 0){
                    builder.append(Character.toLowerCase(strChar[0]));
                }else {
                    switch (getType(strChar[i])){
                        case X: {
                            if(change){
                                builder.append(Character.toUpperCase(strChar[i]));
                                change = false;
                            }else {
                                builder.append(strChar[i]);
                            }
                        } break;

                        case Q: {
                            change = true;
                        } break;

//                        case S: {
//                            builder.append(strChar[i]);
//                        } break;

                        case D:{
                            builder.append(strChar[i]);
                            change = false;
                        }
                    }
                }

            }
            return builder.toString();
        }else if('_' == firstChar){
            //__UPPER__CASE__ -> upperCase
            StringBuilder builder = new StringBuilder();
            boolean change = false;
            boolean flag = false;
            int index = 0;
            for (int i = 1; i < strChar.length; i++) {
                switch (getType(strChar[i])){
                    case X: {
                        if(change){
                            builder.append(Character.toUpperCase(strChar[i]));
                            index++;
                            change = false;
                        }else {
                            builder.append(strChar[i]);
                            index++;
                        }
                    } break;
                    case D:{
                        if(index == 0){
                            builder.append(Character.toLowerCase(strChar[i]));
                            index++;
                        }else {
                            if(flag && change){
                                builder.append(strChar[i]);
                                index++;
                                flag = false;
                            }else{
                                builder.append(Character.toLowerCase(strChar[i]));
                                change = true;
                                index++;
                            }
                        }
                    } break;
                    case Q:{
                        if(index != 0){
                            change = true;
                            flag = true;
                        }
                    } break;
                }
            }
            return builder.toString();
        }else {
            return "";
        }
    }

    private static CharType getType(char c){
//        if('A' <= c && c <= 'Z'){
//            return CharType.D;
//        }else if('a' <= c && c <= 'z'){
//            return CharType.X;
//        }else if(c == '_'){
//            return CharType.G;
//        }else if (c == ' '){
//            return CharType.K;
//        }else{
//            return CharType.Q;
//        }

        if('A' <= c && c <= 'Z'){
            return CharType.D;
        }else if('a' <= c && c <= 'z') {
            return CharType.X;
        }else if('0' <= c && c <= '9'){
            //return CharType.S;
            return CharType.X;
        }else{
            return CharType.Q;
        }
    }
}

enum CharType{
    // 大写、小写、杠、空格、其它、数字
    D, X, G, K, Q, S;
}
