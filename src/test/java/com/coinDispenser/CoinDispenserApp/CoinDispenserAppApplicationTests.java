package com.coinDispenser.CoinDispenserApp;

import CoinDispenserApp.exception.InternalServerException;
import CoinDispenserApp.exception.InvalidInputException;
import CoinDispenserApp.rest.CoinDispenserController;
import CoinDispenserApp.service.CoinDispenserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoinDispenserAppApplicationTests {

	CoinDispenserService dispenserService;
	CoinDispenserController coinDispenserController;

	@Test
	void contextLoads() {
	}



	@Test
	public void testCoinDispenser() throws Exception {
		int[] coins = {13,6,8};
		int amount = 12;
		try{

			int result = dispenserService.coinsDispensed(coins,amount);
			System.out.println(result);
			if(result > 0 ){

				System.out.println("The minimum combination of coins :"+ result);
			}else{
				result = 0;
				System.out.println("No combination found");
				System.out.println(result);
			}

		}catch(InvalidInputException e){
			System.out.println(e.getMessage());
			throw new Exception(e.getMessage());

		}catch(InternalServerException e){
			System.out.println(e.getMessage());
			throw new Exception(e.getMessage());
		}

	}

}
