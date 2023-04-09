
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Players {
    private final int[] allPlayer = {1, 2, 3, 4};
    int[][] players = new int[4][15];
    private int okey;
    private int indicator;

    private int[] playerPointsSeri = new int[4];
    private int[] playerPointsCift = new int[4];
    private String winner;
}
