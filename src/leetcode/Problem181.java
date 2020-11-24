package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-07 18:21
 **/
public class Problem181 {


    // Runtime: 282 ms, faster than 97.83% of MySQL online submissions for Employees Earning More Than Their Managers.
    //Memory Usage: 0B, less than 100.00% of MySQL online submissions for Employees Earning More Than Their Managers.
    /*
SELECT a.name AS Employee
FROM Employee a, Employee b
WHERE a.ManagerId = b.Id
    AND a.Salary > b.Salary;
     */



    // Runtime: 339 ms, faster than 62.87% of MySQL online submissions for Employees Earning More Than Their Managers.
    //Memory Usage: 0B, less than 100.00% of MySQL online submissions for Employees Earning More Than Their Managers.
    /*
SELECT a.name AS Employee
FROM Employee a JOIN Employee b
ON a.ManagerId = b.Id
    AND a.Salary > b.Salary;
     */
}
