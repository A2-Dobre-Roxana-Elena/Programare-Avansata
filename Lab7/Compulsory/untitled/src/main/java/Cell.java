

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<Token> tokens;
    private boolean visited;

    public Cell() {
        this.tokens = new ArrayList<>();
        this.visited = false;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
