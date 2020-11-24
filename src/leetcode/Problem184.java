package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-09 17:56
 **/
public class Problem184 {




    // Runtime: 500 ms, faster than 91.07% of MySQL online submissions for Department Highest Salary.
    //Memory Usage: 0B, less than 100.00% of MySQL online submissions for Department Highest Salary.
    /*
SELECT d.`Name` AS 'Department', e.`Name` AS 'Employee', Salary
FROM Department d JOIN Employee e
ON d.Id = e.DepartmentId
WHERE (d.Id, Salary)
	IN (SELECT DepartmentId, MAX(Salary)
			FROM Employee
			GROUP BY DepartmentId);
     */
}
