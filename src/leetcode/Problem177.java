package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-06 11:45
 **/
public class Problem177 {
    // https://leetcode-cn.com/problems/nth-highest-salary/solution/mysql-zi-ding-yi-bian-liang-by-luanz/

    /* test cases
{"headers": {"Employee": ["Id", "Salary"]}, "argument": 2, "rows": {"Employee": [[1, 100], [2, 200], [3, 300]]}}
{"headers": {"Employee": ["Id", "Salary"]}, "argument": 5, "rows": {"Employee": [[1, 100], [2, 200], [3, 300]]}}
{"headers": {"Employee": ["Id", "Salary"]}, "argument": 88, "rows": {"Employee": [[12, 761], [6, 1037], [87, 38], [1, 786], [39, 1762], [65, 133], [25, 2529], [96, 403], [8, 4333], [11, 3164], [5, 831], [18, 3579], [66, 4778], [26, 4826], [82, 4957], [63, 1288], [64, 2711], [73, 1842], [2, 2627], [78, 1908], [22, 4667], [77, 199], [69, 576], [32, 2638], [79, 510], [23, 622], [43, 2491], [44, 4435], [28, 4552], [86, 4646], [57, 451], [13, 1852], [62, 2835], [72, 544], [37, 2896], [89, 4699], [71, 220], [46, 2333], [95, 2261], [48, 3210], [17, 398], [20, 57], [74, 176], [54, 4272], [35, 2172], [84, 4686], [42, 2595], [76, 3631], [45, 4022], [68, 3248], [40, 571], [14, 4094], [51, 3272], [97, 2057], [30, 2505], [88, 3805], [55, 4926], [81, 3423], [7, 811], [52, 4664], [33, 1842], [41, 4645], [50, 1490], [24, 3361], [59, 4504], [99, 805], [67, 4561], [61, 4641], [38, 2542], [94, 4361], [15, 1652], [70, 1903], [10, 2109], [49, 1428], [29, 558], [60, 708], [3, 1717], [0, 3162], [75, 1450], [83, 2333], [47, 455], [9, 2360], [56, 1570], [80, 1677], [27, 508], [21, 3994], [85, 2276], [91, 1606], [90, 2269], [58, 1954], [19, 774], [4, 655], [92, 3274], [16, 333], [36, 1744], [53, 2262], [93, 3887], [31, 3521], [34, 1415], [98, 2490]]}}
{"headers": {"Employee": ["Id", "Salary"]}, "argument": 1, "rows": {"Employee": [[1, 100]]}}
     */



// Runtime: 311 ms, faster than 66.51% of MySQL online submissions for Nth Highest Salary.
//Memory Usage: 0B, less than 100.00% of MySQL online submissions for Nth Highest Salary.
    /*
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N := N - 1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT Salary
      FROM Employee
      GROUP BY Salary
      ORDER BY Salary DESC
      LIMIT N, 1
  );
END
     */



    // Runtime: 496 ms, faster than 11.72% of MySQL online submissions for Nth Highest Salary.
    //Memory Usage: 0B, less than 100.00% of MySQL online submissions for Nth Highest Salary.
    /*
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N := N - 1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT Salary
      FROM Employee
      ORDER BY Salary DESC
      LIMIT N, 1
  );
END
     */


// Runtime: 695 ms, faster than 5.34% of MySQL online submissions for Nth Highest Salary.
//Memory Usage: 0B, less than 100.00% of MySQL online submissions for Nth Highest Salary.
    /*
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT e.Salary
      FROM Employee AS e
      WHERE (SELECT COUNT(DISTINCT Salary) FROM Employee WHERE Salary > e.Salary) = N - 1
  );
END
     */



// Runtime: 287 ms, faster than 85.10% of MySQL online submissions for Nth Highest Salary.
//Memory Usage: 0B, less than 100.00% of MySQL online submissions for Nth Highest Salary.
    /*
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT Salary
      FROM (SELECT Salary, @r:=IF(@s=Salary, @r, @r+1) AS rnk, @s := Salary
          FROM Employee, (SELECT @r:=0, @s:=NULL)init
          ORDER BY Salary DESC) tmp
      WHERE rnk = N
  );
END
     */


    /*
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    # i 定义变量接收返回值
    DECLARE ans INT DEFAULT NULL;
    # ii 执行查询语句，并赋值给相应变量
    SELECT
        DISTINCT salary INTO ans
    FROM
        (SELECT
            salary, @r:=IF(@p=salary, @r, @r+1) AS rnk,  @p:= salary
        FROM
            employee, (SELECT @r:=0, @p:=NULL)init
        ORDER BY
            salary DESC) tmp
    WHERE rnk = N;
    # iii 返回查询结果，注意函数名中是 returns，而函数体中是 return
    RETURN ans;
END

作者：luanhz
链接：https://leetcode-cn.com/problems/nth-highest-salary/solution/mysql-zi-ding-yi-bian-liang-by-luanz/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
