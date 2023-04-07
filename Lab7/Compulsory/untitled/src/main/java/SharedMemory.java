import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SharedMemory {
    private final List<Token> tokens = new ArrayList<>();
    public SharedMemory(int n) {
        List<Token> tokens = IntStream.range(0, n)
                .mapToObj(i -> new Token(i))
                .collect(Collectors.toList());
        Collections.shuffle(tokens);
    }
    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            extracted.add(tokens.get(i));
        }
        return extracted;
    }

}
