import java.util.*;

public class CreateStone {
    public static Integer[] okeyGame() {
        final Integer[] stones = new Integer[106];
        for(int i = 0; i < 52; i++){
            stones[2 * i ] = i;
            stones[2 * i + 1] = i;
        }
        stones[104] = 52;
        stones[105] = 52;
        Collections.shuffle(Arrays.asList(stones));
        return stones;
    }

}
