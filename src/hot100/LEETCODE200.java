package hot100;

public class LEETCODE200 {

//    给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//    岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
//    此外，你可以假设该网格的四条边均被水包围。


    public int numIslands(char[][] grid) {
        int numIslands = 0;

        // 思路：
        // 遍历每个 地块，如果遇到了 1 就说明是陆地，并且将周围陆地(如果有)传染为 2

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    travel(grid, i, j);
                }
            }
        }
        return numIslands;
    }


    public static void travel(char[][] grid, int row, int col) {

        // 递归，遇到边界return
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return;
        }

        // 否则说明是其他地块
        // 如果是1 则为没有传染的陆地，标记为2
        if (grid[row][col] == '1') {
            // 需要传染
            grid[row][col] = '2';

            // 注意
            // 然后分别向上 下 左 右 递归
            travel(grid, row + 1, col);
            travel(grid, row - 1, col);
            travel(grid, row, col + 1);
            travel(grid, row, col - 1);
        }



    }





}
