package za.co.walter.rest;


import za.co.walter.exception.InternalServerException;
import za.co.walter.exception.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.co.walter.service.CoinDispenserService;

import javax.validation.constraints.Min;

@Controller
public class CoinDispenserController {

    protected CoinDispenserService coinDispenserService;

    @Autowired
    public CoinDispenserController(CoinDispenserService coinDispenserService){
        this.coinDispenserService = coinDispenserService;
    }

    @RequestMapping(value = "/home")
    public static String welcome(){
    return "home";
    }

    //create a post method to accept amount to change and denominators of coins
    //pass Model as parameter to add the attribute being returned (combination)
    @RequestMapping(value = "/dispanseCoin")
    public String dispanseCoin(@RequestParam  @Min(1) int amount, @RequestParam @Min(1)int[] coins, Model model) throws Exception {
        String answer = "";

        //check if input amount and coins length is greater than 0
            try {

                if (amount > 0 || coins.length > 0) {

                     int combinedCoin = coinDispenserService.coinsDispensed(coins, amount);

                    //check if a combination is found
                     if(combinedCoin < amount && combinedCoin > 0 ){
                        answer = "The minimum combination of coins  :" + combinedCoin;

                     }else if( combinedCoin < 0){
                         combinedCoin = 0;//if no combination of coins found return 0
                         answer = "No combination  found : "+combinedCoin;
                     }
                     model.addAttribute("coin", answer);
                 }
                 return "home";

            }catch(InvalidInputException e){

                throw new Exception(e.getMessage());

            }catch(InternalServerException e){

                throw new Exception(e.getMessage());
            }
    }
}
