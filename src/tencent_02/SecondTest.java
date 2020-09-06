package tencent_02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SecondTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] firstLine = sc.nextLine().split(" ");
        int people = Integer.parseInt(firstLine[0]);
        int group = Integer.parseInt(firstLine[1]);

        Group[] groups = new Group[group];



        for (int i = 0; i < group; i++) {
            String[] groupPeoples = sc.nextLine().split(" ");
            int peoples = Integer.parseInt(groupPeoples[0]);
            int[] peopleArr = new int[peoples];
            for (int j = 1, k = 0; j < groupPeoples.length && k < peoples; j++, k++) {
                peopleArr[k] = Integer.parseInt(groupPeoples[j]);
            }
            groups[i] = new Group(peoples, peopleArr);
        }
        int ret = handGroup(groups, people);
        System.out.println(ret);
    }

    private static int handGroup(Group[] groups, int count) {
        int call = 0;
        HashSet<Integer> set = new HashSet<>();
        for(Group group: groups){
            int[] peopleArr = group.peopleArr;
            for(int people: peopleArr) {
                if(people == 0){
                    findGroup(set, peopleArr, people, call, count);
                }
            }
        }

        for(Group group: groups){
            int[] peopleArr = group.peopleArr;
            for (Integer i: set){
                for(int de : peopleArr){
                    if(i == de){
                        findGroup(set, peopleArr, de, call, count);
                    }
                }
            }
        }
        return set.size();
    }

    private static void findGroup(Set<Integer> retSet, int[] arr, int desc, int call, int counts){
        call++;
        if(call > counts){
            return;
        }
        boolean flag = false;
        for (int i: arr){
            if (i == desc) {
                flag = true;
                break;
            }
        }
        if(flag){
            for (int i: arr) retSet.add(i);
            int[] ints = new int[retSet.size()];
            int index = 0;
            for(Integer i: retSet){
                ints[index++] = i;
            }
            for(int d: ints){
                if(retSet.contains(d)) break;
                findGroup(retSet, ints, d, call, counts);
            }
        }
    }

    static class Group {
        int peoples;
        int[] peopleArr;
        public Group(int peoples, int[] peopleArr) {
            this.peoples = peoples;
            this.peopleArr = peopleArr;
        }
    }
}
