package CodePlus.competition7;

import java.util.*;

/*
1
2
1 2

5
4
1 2 2 4

k=1,n=2
0 2
1 0
0 0

k=5,n=4
1 2 2 4
0 2 2 4
1 0 2 4
0 0 2 4
1 1 3 0
0 1 3 0
1 2 0 0
0 2 0 0
1 0 0 0
0 0 0 0
 */
public class ShenMiXuLie {
    public static void main(String[] args) {
        // deltaK
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        odd.add(0);
        even.add(0);
        for (int n = 1; n < 1000; n++) {
            odd.add(n * n - n);
            even.add(n * (n + 1) - n);
        }


        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int k = in.nextInt();



        }
    }
}
/*
神秘序列
时间限制： 0.5 秒

空间限制： 256 MiB

题目描述
E.Space 做了一个梦。

他梦到了一个神秘的序列，有人告诉他，这个序列和明天的考试有一些密切的关联。他决心要把这个序列记住。

可醒来之后，E.Space 发现自己没有记住这个序列，甚至连序列的长度都不记得了。不过，他记得这个序列有一个神奇的性质。

在梦中，E.Space 对它进行了一系列的操作。

记这个序列为 a1,a2,⋯,an，开始时它满足 ∀1≤i≤n, ai≥0，并且 an≠0。

之后，E.Space 在每次操作时选择一个满足 ai=i 的 i，将 ai 变为 0，并且将 a1,a2,⋯,ai−1 分别变为原来的值加 1。

E.Space 记得，在 n+k 次操作之后，这个序列变成了全 0 序列，即 a1=a2=⋯=an=0。

E.Space 知道可能有多个序列满足这个性质，但是他还是希望你告诉他一种可能的情况，因为，说不定所有满足这个性质的序列都可以在考试时派上用场呢。

他的考试成绩就交给你了。

输入格式
输入一行一个正整数 k。

输出格式
如果你找到了满足 E.Space 描述的性质的序列，那么输出两行。

第一行一个正整数 n。

第二行 n 个非负整数，a1,a2,⋯,an，其中 an≠0，表示这个神秘序列。

如果存在多种可能的神秘序列，只需输出任意一种。

如果不存在这样的神秘序列，输出一行 Daydream! 来告诉 E.Space 他在做白日梦。

样例1输入
1
样例1输出
2
1 2
样例2输入
5
样例2输出
4
1 2 2 4
子任务
子任务 1（10 分）：k≤6
子任务 2（25 分）：k≤106
子任务 3（30 分）：k≤1011，如果有解则保证存在一个解满足 ∀1≤i<n, ai≠i

子任务 4（28 分）：k≤1011
子任务 5（7 分）：k≤1012
语言及编译选项信息

#	名称	编译器	额外参数	代码长度限制（B）
0	g++ with std11	g++	-O2 -std=c++11 -DONLINE_JUDGE	65536
1	g++	g++	-O2 -DONLINE_JUDGE	65536
2	gcc with std11	gcc	-O2 -std=c11 -DONLINE_JUDGE	65536
3	gcc	gcc	-O2 -DONLINE_JUDGE	65536
4	java	javac		65536
5	python	python		65536
6	python3	python3		65536
 */