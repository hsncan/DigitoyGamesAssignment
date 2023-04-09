import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class ScoreCalculation {


    public int calculate(int[] istaka,
                         int indicator,
                         int okey){
        int point = 0;
        Set<Integer> seriSet = new HashSet<Integer>();
        Set<Integer> repetitive = new HashSet<Integer>();
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        int existOkey = 0;
        int okeyUsed = 0;
        int maxSeri = 0;
        int currentSeri = 0;
        if(IntStream.of(istaka).anyMatch(x -> x == okey))existOkey = 1;
    for(int i=1; i < istaka.length;i++){
        repetitive.add(istaka[i-1] % 13);
        if(istaka[i] == istaka[i-1]+1){
            currentSeri++;
        }else {
            maxSeri= Math.max(maxSeri,currentSeri);
            if(existOkey == 1 &&
                    okeyUsed == 0 &&
                    currentSeri > 1 &&
                    currentSeri <3 ){
                currentSeri++;
                okeyUsed = 1;
                continue;
            }
            if (currentSeri >2)seriSet.add(currentSeri);
            currentSeri = 0;
            repetitive.add(istaka[i-1] % 13);

        }


        }
        repetitive.add(istaka[14] % 13);
    for(Integer item:seriSet){
        point += 30 + (item %3)*10;
    }
    for(Integer num:repetitive){
        if(frequencyMap.containsKey(num)){
            frequencyMap.put(num,frequencyMap.get(num)+1);
        }else{
            frequencyMap.put(num,1);
        }
    }
    for(Integer num:frequencyMap.keySet()){
        int frequency = frequencyMap.get(num);
        if(existOkey == 1 &&
                okeyUsed == 0 &&
                frequency > 1){
            frequency++;
        }
        if(frequency == 3)point += 35;
        if(frequency == 4)point += 45;
    }


return point;
    }
    public int calculateCift(int[] istaka,
                             int indicator,
                             int okey){
        int point = 0;
        Set<Integer> ciftSet = new HashSet<Integer>();

        for(int i : istaka){
            if(!ciftSet.add(i)){
                point += 10;
            }
        }
        if(IntStream.of(istaka).anyMatch(x -> x == indicator))point += 10;
        if(IntStream.of(istaka).anyMatch(x -> x == okey))point += 10;


        return point;
    }
}


