# algo-demos

状态机-确定有限自动机/自动机（deterministic finite automaton, DFA）
```text
8. 字符串转换整数 (atoi)
393. UTF-8 编码验证
65. 有效数字
```
动态规划
```text
509. 斐波那契数列（三种方法1. 递归 2. 记忆化搜索 3. 动态规划）
70. 爬楼梯(三种方法)
120. Triangle的最小路径和（三种方法1.递归 2.记忆化递归搜索 3. 动态规划）
64. 二维矩阵的最小路径和

IntegerBreak(三种方法)
279. Perfect Squares
91. Decode Ways
62. unique path
63. unique path2

198. HouseRobber(三种方法，都可以使用三种方法，还可以使用新的状态定义)
213. HouseRobber2
337. HouseRobber3
309. 股票的最佳售卖时机(含冷冻期)
121. 股票的最佳售卖时机

0-1背包问题
weight[] value[] 容量为c的背包能放下的value最大值（记忆化搜索、动态规划、空间优化）
完全背包问题(每个物品可以取无限次)
多重背包问题(每个物品可以取x次)
多维费用背包问题(比如背包要考虑 重量和体积两个维度)
其他变种问题：物品之间有排斥关系、或者依赖关系


最长子序列问题
最长上升子序列（递归、记忆化搜索、动态规划）
376. wiggle subsequence
最长公共子序列问题

dijkstra单源最短路径算法也是动态规划
```

### 广度优先搜索
1. 102.二叉树的层序遍历
2. 103.二叉树的锯齿形层序遍历

### 0-1背包问题与动态规划
解题思路
常见的背包问题有
1. 组合问题：
```
377. 组合总和 Ⅳ
494. 目标和
518. 零钱兑换 II
```
2. True、False问题：
```text
139. 单词拆分
416. 分割等和子集
```
3. 最大最小问题：
```
474. 一和零
322. 零钱兑换
```
组合问题公式
```text
dp[i] += dp[i-num]
```
True、False问题公式
```text
dp[i] = dp[i] or dp[i-num]
```

最大最小问题公式
```text
dp[i] = min(dp[i], dp[i-num]+1)或者dp[i] = max(dp[i], dp[i-num]+1)
```
以上三组公式是解决对应问题的核心公式。

动态规划
> 将原问题拆成无数的子问题，记录子问题的答案，使得每个子问题只求解一次。
```text
1. 最优子结构
2. 重复子问题

主要的技术点在：选与不选问题，以及边界上(打家劫舍2)
f(n) = n + f(n - ?) 选 
f(n) = f(n - ?)     不选

动态规划数组一维二维问题
1. 可能是1维数组即可
2. 可能是2维数组，最长公共子序列、最长重复子序列，需要二维数组，主要取决于最小子问题由2个参数决定还是1个参数决定

dp数组的最小子问题
1. 1维数组需要先填充dp[0]
2. 2维数组需要填充dp[i][0], dp[0][j], 然后迭代

for循环迭代时的end到底是end，还是end+1
1. 看循环体内使用的i的含义，到底是用的i还是i+1，或者i-1
2. for循环内，可以从i开始(循环起点 + 1)，也可以从i+1开始(循环起点是已经被赋值的i)
```
常见题型：
1. 最长重复子序列
2. 最长公共子序列
3. 最长递增子序列
3. 0-1背包问题，选与不选
   3.1 416

