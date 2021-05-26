package CoinDispenserApp.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CoinDispenserService {


    public  int coinsDispensed(int coins[], int amauntValue) {
        //Sort the array before finding the combination
        Arrays.sort(coins);

        //base case
        if (amauntValue == 0)
            return 0;

        //initialize results
        int result = Integer.MAX_VALUE;

        //loop through every coin that is smaller than amount value
        for (int x = 0; x < coins.length ; x++) {
               if(amauntValue >= coins[x]){
                   int result1 = coinsDispensed(coins, amauntValue-coins[x]);

                   //check for int result to avoid overflow and see if result can be minimised
                   if(result1 != result && result1 +1 < result){
                       result = result1 + 1;
                   }
               }
         }
        return result;
    }
}
