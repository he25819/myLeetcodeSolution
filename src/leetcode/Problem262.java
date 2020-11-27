package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-27 10:43
 **/
public class Problem262 {


    // 答案：https://leetcode-cn.com/problems/trips-and-users/solution/san-chong-jie-fa-cong-nan-dao-yi-zong-you-gua-he-n/
    // Runtime: 319 ms, faster than 84.18% of MySQL online submissions for Trips and Users.
    //Memory Usage: 0B, less than 100.00% of MySQL online submissions for Trips and Users.
    /*
SELECT Request_at AS 'Day',
ROUND(
	SUM(IF(Status = 'completed',0,1))/COUNT(Status), 2) AS 'Cancellation Rate'
FROM
	Trips
	JOIN Users u1 ON ( Trips.Client_Id = u1.Users_Id AND u1.Banned = 'No' )
	JOIN Users u2 ON ( Trips.Driver_Id = u2.Users_Id AND u2.Banned = 'No' )
WHERE Request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY Request_at;
     */
}
