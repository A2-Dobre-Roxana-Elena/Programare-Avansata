
import java.util.Arrays;
import java.util.List;

public class ExplorationMap {
    private final Cell[][] matrix;
    private final SharedMemory mem = new SharedMemory(10);

    public ExplorationMap(int n)
    {
        this.matrix = new Cell[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.matrix[i][j] = new Cell();
            }
        }
    }
    public Cell[][] getMatrix() {
        return matrix;
    }

    //Cell should be a wrapper or alias for List<Token>
    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (!matrix[row][col].isVisited()) {
                List<Token> tokens = mem.extractTokens(1);
                matrix[row][col].setTokens(tokens);
                matrix[row][col].setVisited(true);
                System.out.println("Robotul " + robot.getName() + " a vizitat casuta [" + row + "][" + col + "] din matrice. ");
                return true;
            } else {
                System.out.println("Robotul " + robot.getName() + " NU a reusit sa vizitze casuta [" + row + "][" + col + "] din matrice. ");
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return "ExplorationMap{" +
                "matrix=" + Arrays.toString(matrix) +
                ", mem=" + mem +
                '}';
    }
}
