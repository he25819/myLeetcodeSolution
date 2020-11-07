package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-07 11:20
 **/
public class Problem178 {

    // https://leetcode-cn.com/problems/rank-scores/solution/fen-cheng-liang-ge-bu-fen-xie-hui-rong-yi-hen-duo-/


    // Runtime: 719 ms, faster than 12.41% of MySQL online submissions for Rank Scores.
    //Memory Usage: 0B, less than 100.00% of MySQL online submissions for Rank Scores.
    /*
# Write your MySQL query statement below
SELECT a.Score AS score,
    (SELECT COUNT(DISTINCT b.Score)
     FROM Scores AS b
     WHERE b.Score >= a.Score) AS 'Rank'
FROM Scores AS a
ORDER BY a.score DESC;
     */


    // Runtime: 231 ms, faster than 88.41% of MySQL online submissions for Rank Scores.
    //Memory Usage: 0B, less than 100.00% of MySQL online submissions for Rank Scores.
    /*
SELECT score, DENSE_RANK() OVER (ORDER BY score DESC) AS 'Rank'
FROM Scores;
     */



// Runtime: 361 ms, faster than 28.19% of MySQL online submissions for Rank Scores.
//Memory Usage: 0B, less than 100.00% of MySQL online submissions for Rank Scores.
    /*
SELECT score,
CASE
	WHEN @prev = score THEN
		@rank+0
	WHEN @prev := score THEN
		@rank := @rank+1
    ELSE
        @rank := @rank+1
END AS 'Rank'
FROM Scores, (SELECT @prev := NULL, @rank := 0) tmp
ORDER BY score DESC;

     */


}
