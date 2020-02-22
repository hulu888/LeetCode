package DynamicProgramming.SimpleLevel.HouseRobber;

/**
 198. 打家劫舍


     你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。


 示例 1:

     输入: [1,2,3,1]
     输出: 4
     解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
          偷窃到的最高金额 = 1 + 3 = 4 。


 示例 2:

     输入: [2,7,9,3,1]
     输出: 12
     解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
          偷窃到的最高金额 = 2 + 9 + 1 = 12 。

 【思路】
        考虑所有可能的打劫方案过于困难，一个自然而然的方法是从最简单的情况开始。
        记：
            f(k)=从当前k个房屋中能打劫到的最大数额， A(i)=第i个房屋的钱数
        首先看n=1的情况，显然f(1)=A(1)
             n=2, f(2)=max(A(1), A(2))
             n=3, 有以下两个选项：
                1. 抢第三个房子，将数额与第一个房子相加；
                2. 不强第三个房子， 保持现有数额
        显然，你想选择数额更大的选项，于是，可以总结出公式：
            f(k) = max(f(k-2) + A(k), f(k-1))
        我们可以令f(-1) = f(0) = 0 为初始情况，可以极大的简化代码

 *
 */


public class HouseRobber {

    public static int houseRobber(int[] nums){
        int preMax = 0;
        int curMax = 0;
        for (int num : nums){
            int temp = curMax;
            curMax = Math.max(preMax + num, curMax);
            preMax = temp;
        }
        return curMax;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,9,3,1};
        System.out.println(houseRobber(arr));
    }
}
