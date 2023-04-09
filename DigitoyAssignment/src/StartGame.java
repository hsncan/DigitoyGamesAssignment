import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class StartGame {
    public String gameOpening() {
        ArrayList<Players> myGames = new ArrayList<>();
        Players players = new Players();
        Random random = new Random();

        CreateStone createStone = new CreateStone();
        ScoreCalculation scoreCalculation = new ScoreCalculation();
        WhoIsWinner whoIsWinner = new WhoIsWinner();
        int[][] istakalar = new int[4][15];
        int[] playerPointsSeri = new int[4];
        int[] playerPointsCift = new int[4];
        int[] winnerIs = new int[2];
        int[] allPlayers = players.getAllPlayer();
        Integer[] stones = createStone.okeyGame();

        for (int i = 0; i < 43; i++) {
            int  stoneIndex = i % 14;
            for (int j = 0; i < 4; i++) {
            istakalar[j][stoneIndex] = stones[i];
            }
        }


        for (int i = 0; i < 4; i++){
            for(int j=0; j < 14 ;j++){
               int stoneIndex = j + i * 14;
                istakalar[i][j] = stones[stoneIndex];
            }

        }

        int randomIndex = random.nextInt(3);
        for (int i = 0; i < 4; i++) {
            if (allPlayers[randomIndex] == i + 1) {
                istakalar[i][14] = stones[43];
            } else {
                istakalar[i][14] = 999;
            }
            Arrays.sort(istakalar[i]);
            playerPointsSeri[i] = scoreCalculation.calculate(istakalar[i], players.getIndicator(), players.getOkey());
            playerPointsCift[i] = scoreCalculation.calculateCift(istakalar[i], players.getIndicator(), players.getOkey());
        }
        winnerIs = whoIsWinner.winnerIs(playerPointsSeri,playerPointsCift);
        String strWinner = allPlayers[winnerIs[0]] + ". player is winner in this game" + ((winnerIs[1] == 1) ? " with serialization!":" with double order!");

        players.setPlayers(istakalar);
        players.setIndicator(stones[43]);
        players.setOkey((stones[43] == 13 || stones[43] == 26 || stones[43] == 39 || stones[43] == 52) ? stones[43] : stones[43] + 1);
        players.setPlayerPointsSeri(playerPointsSeri);
        players.setPlayerPointsCift(playerPointsCift);
        players.setWinner(strWinner);

        myGames.add(players);
        return strWinner;
    }
}
