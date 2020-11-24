package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-07 17:43
 **/
public class Problem180 {


    // 做了4到database的题后终于独立完成一道Medium题并且一次性AC了^ ^ 而且击败90%
    // Runtime: 389 ms, faster than 90.56% of MySQL online submissions for Consecutive Numbers.
    //Memory Usage: 0B, less than 100.00% of MySQL online submissions for Consecutive Numbers.
    /*
SELECT DISTINCT num AS ConsecutiveNums
FROM (SELECT num,
				(SELECT
					CASE
						WHEN @prevNum = num THEN
							@cnt := @cnt + 1
						WHEN @prevNum := num THEN
							@cnt := 1
						ELSE
							@cnt := 1
					END
					FROM (SELECT @prevNum := NULL, @cnt := 0) tmp) AS cnt
			FROM `Logs`) tmp
WHERE cnt >= 3;
     */


    // 只是删了2行：ELSE 及其下一行
    // Runtime: 532 ms, faster than 20.60% of MySQL online submissions for Consecutive Numbers.
    //Memory Usage: 0B, less than 100.00% of MySQL online submissions for Consecutive Numbers.
    /*
SELECT DISTINCT num AS ConsecutiveNums
FROM (SELECT num,
				(SELECT
					CASE
						WHEN @prevNum = num THEN
							@cnt := @cnt + 1
						WHEN @prevNum := num THEN
							@cnt := 1
					END
					FROM (SELECT @prevNum := NULL, @cnt := 0) tmp) AS cnt
			FROM `Logs`) tmp
WHERE cnt >= 3;
     */



// Runtime: 511 ms, faster than 24.40% of MySQL online submissions for Consecutive Numbers.
//Memory Usage: 0B, less than 100.00% of MySQL online submissions for Consecutive Numbers.
    /*
SELECT DISTINCT num AS ConsecutiveNums
FROM (SELECT num,
      CASE
        WHEN @prevNum = num THEN
            @cnt := @cnt + 1
        WHEN @prevNum := num THEN
            @cnt := 1
      END AS 'cnt'
	  FROM `Logs`, (SELECT @prevNum := NULL, @cnt := 0) tmp) tmp2
WHERE cnt >= 3;
     */
}
