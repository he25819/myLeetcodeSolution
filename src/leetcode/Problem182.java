package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-07 18:35
 **/
public class Problem182 {



    // Runtime: 269 ms, faster than 96.98% of MySQL online submissions for Duplicate Emails.
    //Memory Usage: 0B, less than 100.00% of MySQL online submissions for Duplicate Emails.
    /*
SELECT Email
FROM (SELECT Email, COUNT(Email) AS cnt FROM Person
      GROUP BY Email) tmp
WHERE cnt > 1;
    */





    // Runtime: 373 ms, faster than 29.00% of MySQL online submissions for Duplicate Emails.
    //Memory Usage: 0B, less than 100.00% of MySQL online submissions for Duplicate Emails.
    /*
SELECT Email
FROM Person
GROUP BY Email
HAVING COUNT(Email) > 1;
     */
}
