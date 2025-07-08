import java.util.List;

public class Board {
    Cell[][] board;

    public Board(int boardSize) {
        board = new Cell[boardSize][boardSize];

        for(int i=0;i<boardSize;i++) {
            for(int j=0;j<boardSize;j++) {
                Cell cell = new Cell();
                board[i][j] = cell;
            }
        }
    }

    public void addSnakes(List<Jump> snakes)  {
        for(Jump snake: snakes) {
            Cell cell = getCell(snake.start);
            cell.jump = snake;
        }
    }

    public void addLadders(List<Jump> ladders) {
        for(Jump ladder: ladders) {
            Cell cell = getCell(ladder.start);
            cell.jump = ladder;
        }
    }

    public Cell getCell(int position) {
        int row = position / board.length;
        int col = position % board.length;

        return board[row][col];
    }
}
