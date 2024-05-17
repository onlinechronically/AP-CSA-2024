public class QuestionFour {
    public static class Location {
        private int theRow;
        private int theCol;

        public Location(int r, int c) {
            theRow = r;
            theCol = c;
        }

        public int getRow() {
            return theRow;
        }

        public int getCol() {
            return theCol;
        }
    }

    public static class GridPath {
        /** Initialized in the constructor with distinct values that never change */
        private int[][] grid;

        /**
         * Returns the Location representing a neighbor of the grid element at row and
         * col,
         * as described in part (a)
         * Preconditions: row is a valid row index and col is a valid column index in
         * grid.
         * row and col do not specify the element in the last row and last column of
         * grid.
         */
        public Location getNextLoc(int row, int col) {
            if (row == grid.length - 1) {
                return new Location(row, col + 1); // then an item below does not exist
            } else if (col == grid[row].length - 1) {
                return new Location(row + 1, col); // then an item to the right does not exist
            } else {
                int itemOne = grid[row][col + 1];
                int itemTwo = grid[row + 1][col];
                if (itemOne <= itemTwo)
                    return new Location(row, col + 1);
                else
                    return new Location(row + 1, col);
            }
        }

        /**
         * Computes and returns the sum of all values on a path through grid, as
         * described in
         * part (b)
         * Preconditions: row is a valid row index and col is a valid column index in
         * grid.
         * row and col do not specify the element in the last row and last column of
         * grid.
         */
        public int sumPath(int row, int col) {
            int total = grid[row][col];
            while (row != grid.length - 1 || col != grid[0].length - 1) {
                Location next = getNextLoc(row, col);
                row = next.getRow();
                col = next.getCol();
                total += grid[row][col];
            }
            return total;
        }
        // There may be instance variables, constructors, and methods that are not
        // shown.
    }

    public static void main(String[] args) {
        int[][] g = new int[][] { { 12, 3, 4, 13, 5 }, { 11, 21, 2, 14, 16 }, { 7, 8, 9, 15, 0 },
                { 10, 17, 20, 19, 1 }, { 18, 22, 30, 25, 6 } };
        GridPath gp = new GridPath();
        gp.grid = g;
        Location testOne = gp.getNextLoc(0, 0);
        Location testTwo = gp.getNextLoc(1, 3);
        Location testThree = gp.getNextLoc(2, 4);
        Location testFour = gp.getNextLoc(4, 3);
        System.out.println(gp.grid[testOne.getRow()][testOne.getCol()]);
        System.out.println(gp.grid[testTwo.getRow()][testTwo.getCol()]);
        System.out.println(gp.grid[testThree.getRow()][testThree.getCol()]);
        System.out.println(gp.grid[testFour.getRow()][testFour.getCol()]);

        GridPath altGP = new GridPath();
        altGP.grid = new int[][] { { 12, 30, 40, 25, 5 }, { 11, 3, 22, 15, 43 }, { 7, 2, 9, 4, 0 },
                { 8, 33, 18, 6, 1 } };
        System.out.println(altGP.sumPath(1, 1));
    }
}
