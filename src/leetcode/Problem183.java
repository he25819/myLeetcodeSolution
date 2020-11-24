package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-09 13:44
 **/
public class Problem183 {


    // Runtime: 353 ms, faster than 99.79% of MySQL online submissions for Customers Who Never Order.
    //Memory Usage: 0B, less than 100.00% of MySQL online submissions for Customers Who Never Order.
    /*
SELECT Name AS Customers
FROM Customers c LEFT JOIN Orders o
ON c.Id = o.CustomerId
WHERE o.CustomerId IS NULL;
     */


    // Runtime: 836 ms, faster than 5.00% of MySQL online submissions for Customers Who Never Order.
    //Memory Usage: 0B, less than 100.00% of MySQL online submissions for Customers Who Never Order.
    /*
SELECT Name AS Customers
FROM Customers
WHERE Id NOT IN (SELECT CustomerId FROM Orders);
     */


    // Runtime: 580 ms, faster than 16.75% of MySQL online submissions for Customers Who Never Order.
    //Memory Usage: 0B, less than 100.00% of MySQL online submissions for Customers Who Never Order.
    /*
SELECT Name AS Customers
FROM (SELECT Name, CustomerId
			FROM Customers c LEFT JOIN Orders o
			ON c.Id = o.CustomerId) tmp
WHERE CustomerId IS NULL;
     */

}
