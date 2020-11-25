package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-25 13:44
 **/
public class Problem197 {


    // Runtime: 452 ms, faster than 38.04% of MySQL online submissions for Rising Temperature.
    //Memory Usage: 0B, less than 100.00% of MySQL online submissions for Rising Temperature.
    /*
SELECT w1.id
FROM Weather w1, Weather w2
WHERE DATEDIFF(w1.recordDate, w2.recordDate) = 1
    AND w1.Temperature > w2.Temperature;
     */
}
