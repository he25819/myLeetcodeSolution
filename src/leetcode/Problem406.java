package leetcode;

import java.util.*;

public class Problem406 {
    // https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89345/Easy-concept-with-PythonC%2B%2BJava-Solution
    // LinkedList:
    //Runtime: 38 ms, faster than 23.44% of Java online submissions for Queue Reconstruction by Height.
    //Memory Usage: 39.6 MB, less than 100.00% of Java online submissions for Queue Reconstruction by Height.
    // ArrayList:
    //Runtime: 36 ms, faster than 44.74% of Java online submissions for Queue Reconstruction by Height.
    //Memory Usage: 39.2 MB, less than 100.00% of Java online submissions for Queue Reconstruction by Height.
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length <= 1) {
            return people;
        }
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        List<int[]> res = new ArrayList<>();
        for (int[] person : people) {
            res.add(person[1], person);
        }

        return res.toArray(new int[people.length][]);
    }

    // copy from sample 6 ms submission
    //Runtime: 6 ms, faster than 87.32% of Java online submissions for Queue Reconstruction by Height.
    //Memory Usage: 44.9 MB, less than 68.08% of Java online submissions for Queue Reconstruction by Height.
    public int[][] reconstructQueue2(int[][] people) {
        int [][]result=new int[people.length][2];
        ArrayList<int[]> r=new ArrayList<int[]>(people.length);
        Arrays.sort(people,new Comparator<int[]>(){
            public int compare(int[] firstIndex,int[] secondIndex){
                if(firstIndex[0]==secondIndex[0]){
                    return firstIndex[1]-secondIndex[1];
                }
                else{
                    return secondIndex[0]-firstIndex[0];
                }
            }
        });
        for(int i=0;i<people.length;i++){
            r.add(people[i][1], people[i]);
        }
        for(int i=0;i<r.size();i++){
            result[i]=r.get(i);
        }
        return result;
    }

    // lambda 表达式性能会变差？
    //Runtime: 6 ms, faster than 87.32% of Java online submissions for Queue Reconstruction by Height.
    //Memory Usage: 45 MB, less than 68.08% of Java online submissions for Queue Reconstruction by Height.
    public int[][] reconstructQueue3(int[][] people) {
        if (people == null || people.length <= 1) {
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        for (int[] person : people) {
            res.add(person[1], person);
        }

        return res.toArray(new int[people.length][]);
    }
}
