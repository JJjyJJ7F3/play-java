package self.jjjyjj.clean.code.naming.example;

import lombok.Setter;

/**
 * Class represents a cell in game board.
 */
public class Cell {
    private final int CELL_STATUS = 1;

    @Setter
    private int status = CELL_STATUS;

    public boolean isFlagged() {
        int FLAGGED = 4;
        return status == FLAGGED;
    }
}
