public class WhoIsWinner {
    public int[] winnerIs(int[] arr1, int[] arr2){
        int max = Integer. MIN_VALUE;
        int index = -1;
        boolean inFirstArray = true;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > max) {
                max = arr1[i];
                index = i;
                inFirstArray = true;
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] > max) {
                max = arr2[i];
                index = i;
                inFirstArray = false;
            }
        }


        return new int[]{index, inFirstArray ? 1 : 2};

    }
}
