package ruiming;

import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class SecondTest {
    static int a = 10;
    public static void main(String[] args) {
        //System.out.println(deleteNum(10));
        a = 20;
    }

    public static int deleteNum (int n) {
        LinkedList<Integer> link = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            link.add(i);
        }
        //LinkedList<Integer> linkCopy = new LinkedList<>(link);
        int index = 0;
        //0 1 2 3 4 5 6 7 8 9 10
        for (int i = 0; i < n; i++) {
            if(index == 3){
                link.remove(index);
                index = 0;
            }else{
                index++;
            }
        }


        return deleteLink(link);
    }

    private static int deleteLink(LinkedList<Integer> link) {
        int size = link.size();
        if(link.size() <= 4) return 0;
        int index = 0;
        //0 1 2 3 4 5 6 7 8 9 10
        for (int i = 0; i < size; i++) {
            if(index == 3){
                link.remove(index);
                index = 0;
            }else{
                index++;
            }
        }
        if(link.size() == 1){
            return 100;
        }else{
            deleteLink(link);
        }
        return -1;
    }
}
