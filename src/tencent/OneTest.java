package tencent;

import java.util.*;

public class OneTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> out = new ArrayList<>();

        //t组测试数据
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < t; i++) {
            Queue<Integer> queue = new LinkedList<>();
            //q次操作
            int q = Integer.parseInt(scanner.nextLine());
            for (int j = 0; j < q; j++) {
                String cmd = scanner.nextLine();
                switch (cmd){
                    case "TOP":
                        if(queue.isEmpty()) {
                            out.add("-1");
                        }else{
                            out.add(String.valueOf(queue.peek()));
                        }
                        break;
                    case "POP":
                        if(queue.isEmpty()){
                            out.add("-1");
                        }else {
                            queue.poll();
                        }
                        break;
                    case "SIZE":
                        out.add(String.valueOf(queue.size()));
                        break;
                    case "CLEAR":
                        queue.clear();
                        break;
                    default:
                        String[] split = cmd.split(" ");
                        queue.add(Integer.parseInt(split[1]));
                }
            }
        }
        out.forEach(System.out::println);
    }



}