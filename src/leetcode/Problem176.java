package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-03 15:22
 **/
public class Problem176 {
    /*
    方法一：使用子查询和 LIMIT 子句
算法

将不同的薪资按降序排序，然后使用 LIMIT 子句获得第二高的薪资。

MySQL

SELECT DISTINCT
    Salary AS SecondHighestSalary
FROM
    Employee
ORDER BY Salary DESC
LIMIT 1 OFFSET 1
然而，如果没有这样的第二最高工资，这个解决方案将被判断为 “错误答案”，因为本表可能只有一项记录。为了克服这个问题，我们可以将其作为临时表。

MySQL

SELECT
    (SELECT DISTINCT
            Salary
        FROM
            Employee
        ORDER BY Salary DESC
        LIMIT 1 OFFSET 1) AS SecondHighestSalary
;
方法二：使用 IFNULL 和 LIMIT 子句
解决 “NULL” 问题的另一种方法是使用 “IFNULL” 函数，如下所示。

MySQL

SELECT
    IFNULL(
      (SELECT DISTINCT Salary
       FROM Employee
       ORDER BY Salary DESC
        LIMIT 1 OFFSET 1),
    NULL) AS SecondHighestSalary

作者：LeetCode
链接：https://leetcode-cn.com/problems/second-highest-salary/solution/di-er-gao-de-xin-shui-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    // Runtime: 178 ms, faster than 84.23% of MySQL online submissions for Second Highest Salary.
    //Memory Usage: 0B, less than 100.00% of MySQL online submissions for Second Highest Salary.
    /*
    SELECT
    (SELECT DISTINCT Salary
        FROM Employee
        ORDER BY Salary DESC
        LIMIT 1, 1) AS SecondHighestSalary;

     */
}
