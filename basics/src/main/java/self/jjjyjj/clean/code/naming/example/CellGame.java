package self.jjjyjj.clean.code.naming.example;

import java.util.ArrayList;
import java.util.List;

public class CellGame {
    List<int[]> theList = new ArrayList<>();

    List<int[]> gameBoard = new ArrayList<>();

    private final int CELL_STATUS = 1;
    private final int FLAGGED = 4;

    /**
     * a method with bad names
     */
    public List<int[]> getThem() {
        List<int[]> list1 = new ArrayList<>();
        for (int[] x : theList)
            if (x[0] == 4)
                list1.add(x);
        return list1;
    }

    /**
     * update method getThem with readable names
     */
    public List<int[]> getFlaggedCells() {
        List<int[]> flaggedCells = new ArrayList<>();
        for (int[] cell : gameBoard) {
            if (cell[CELL_STATUS] == FLAGGED) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }
}
