package tencent;

import java.util.*;

public class FourTest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        Scanner scanner = new Scanner(System.in);
        List<String> cmdList = new ArrayList<>();
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            cmdList.add(scanner.nextLine());
        }
        for (String cmd: cmdList) {
            switch (cmd){
                case "peek":
                    Integer peek = myStack.peek();
                    if(peek != null){
                        System.out.println(peek);
                    }
                    break;
                case "poll":
                    myStack.poll();
                    break;
                default:
                    String[] cmdS = cmd.split(" ");
                    myStack.add(Integer.parseInt(cmdS[1]));
                    break;
            }
        }
        scanner.close();
    }

    static class MyStack{
        Stack<Integer> stackOne = new Stack<>();
        Stack<Integer> stackTwo = new Stack<>();

        public Integer peek(){
            if(stackTwo.isEmpty()){
                while (!stackOne.isEmpty())
                    stackTwo.add(stackOne.pop());
            }
            if(stackTwo.isEmpty()){
                return null;
            }else{
                return stackTwo.peek();
            }
        }

        public void poll(){
            if(stackTwo.isEmpty()){
                while (!stackOne.isEmpty())
                    stackTwo.add(stackOne.pop());
            }
            stackTwo.pop();
        }

        public void add(Integer i){
            stackOne.add(i);
        }
    }
}