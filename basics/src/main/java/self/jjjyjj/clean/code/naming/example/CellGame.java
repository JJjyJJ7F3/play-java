package self.jjjyjj.clean.code.naming.example;

import java.util.ArrayList;
import java.util.List;

public class CellGame {
    private final List<Cell> gameBoard = new ArrayList<>();

    public List<Cell> getFlaggedCells() {
        ArrayList<Cell> flaggedCells = new ArrayList<>();
        for (Cell cell : gameBoard) {
            if (cell.isFlagged()) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }

    public void addCell(Cell cell) {
        gameBoard.add(cell);
    }
}
