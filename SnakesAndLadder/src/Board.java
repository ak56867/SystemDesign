import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[][] cells;

    public Board(int size, int numOfSnakes, int numOfLadders) {
        Initialize(size);
        addSnakesAndLadders(numOfSnakes, numOfLadders);
    }

    public void Initialize(int size) {

        cells = new Cell[size][size];

        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
            }
        }
    }

    public void addSnakesAndLadders(int numOfSnakes, int numOfLadders) {

        while(numOfLadders > 0) {
            int start = ThreadLocalRandom.current().nextInt(1,cells.length * cells.length-1);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length-1);

            if(end <= start)    continue;

            Jump ladderObj = new Jump();
            ladderObj.start = start;
            ladderObj.end = end;

            Cell cell = getCell(start);
            cell.nextCell = ladderObj;

            numOfLadders--;
        }

        while(numOfSnakes > 0) {
            int start = ThreadLocalRandom.current().nextInt(1,cells.length * cells.length-1);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length-1);

            if(start <= end)    continue;

            Jump ladderObj = new Jump();
            ladderObj.start = start;
            ladderObj.end = end;

            Cell cell = getCell(end);
            cell.nextCell = ladderObj;

            numOfSnakes--;
        }

    }

    Cell getCell(int position) {
        int row = position/cells.length;
        int col = position% cells.length;
        return cells[row][col];
    }
}
