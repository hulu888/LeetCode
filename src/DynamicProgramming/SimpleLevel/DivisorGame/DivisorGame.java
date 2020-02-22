package DynamicProgramming.SimpleLevel.DivisorGame;

/**
 * 1025. 除数博弈

 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
    选出任一 x，满足 0 < x < N 且 N % x == 0 。
    用 N - x 替换黑板上的数字 N 。
    如果玩家无法执行这些操作，就会输掉游戏。
    只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。

  

 示例 1：

     输入：2
     输出：true
     解释：爱丽丝选择 1，鲍勃无法进行操作。


 示例 2：

 输入：3
     输出：false
     解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
  

 提示：

 1 <= N <= 1000

 【思路】
    利用动态规划的思路从后往前推，缓存重叠子问题的结果
    当输入是N，就从1开始推算，一直推算到N的结果，中间结果用数组缓存起来

 */

public class DivisorGame {
    public static boolean divisorGame(int n){
        boolean[] result = new boolean[n + 1];
        result[0] = false;
        for (int i = 1; i < n + 1; i++){
            result[i] = false;
            for (int j = 1; j < i; j++){
                if (i % j == 0 && !result[i - j]){
                    result[i] = true;
                    break;
                }
            }
        }
        return result[n];
    }
}
