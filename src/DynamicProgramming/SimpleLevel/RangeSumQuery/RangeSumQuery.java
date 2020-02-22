package DynamicProgramming.SimpleLevel.RangeSumQuery;

/**
 303. 区域和检索 - 数组不可变

    给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。

 示例：
    给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
    sumRange(0, 2) -> 1
    sumRange(2, 5) -> -1
    sumRange(0, 5) -> -3

 说明:
    1. 你可以假设数组不可变。
    2. 会多次调用 sumRange 方法。


 【思路】
    假设我们预先计算了从数字 00 到 kk 的累积和。我们可以用这个信息得出 sum(i，j)sum(i，j) 吗？
    让我们将 sum[k]sum[k] 定义为 nums[0 ⋯ k-1]nums[0 ⋯ k−1] 的累积和（包括这两个值）：

    现在，我们可以计算 sumrange 如下：
        sumrange（i，j） = sum[j+1]−sum[i]

 */


public class RangeSumQuery {
    private int[] sum;

    public void NumArray(int[] nums){
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++){
            sum[i + 1] = sum[i] + nums[i];
        }

    }
    public int sumRange(int i, int j){
        return sum[j + 1] - sum[i];
    }

}
