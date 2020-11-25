package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-24 17:39
 **/
public class Problem185 {

    // 参考官方答案
    // Runtime: 1440 ms, faster than 5.01% of MySQL online submissions for Department Top Three Salaries.
    //Memory Usage: 0B, less than 100.00% of MySQL online submissions for Department Top Three Salaries.
    /*
SELECT d.Name AS 'Department', e1.Name AS 'Employee', e1.Salary
     FROM Employee e1 JOIN Department d
		 ON e1.DepartmentId = d.Id
     WHERE 3 >
(
    SELECT COUNT(DISTINCT e2.Salary)
		FROM Employee e2
		WHERE e1.Salary < e2.Salary
		    AND e1.DepartmentId = e2.DepartmentId
)
;

     */
}
