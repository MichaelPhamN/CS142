public class BakingCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cookieCount = 39;
		int loafCount = 1;
		
		//================================ recipe and change value of cookie
		double recipeCookieDozen = 4;		
		double recipeCookieAllPurposeFlourCup = 9.0/4.0;
		//Change Cup to Lb of flour
		double recipeCookieAllPurposeFlourLb = (double)recipeCookieAllPurposeFlourCup * 3.0/10.0;
		
		double recipeCookieBakingSodaTeaspoon = 1;
		//Change teaspoon to oz of baking soda
		double recipeCookieBakingSodaOz = (double)recipeCookieBakingSodaTeaspoon/6;
		
		
		double recipeCookieSaltTeaspoon = 1;
		//Change teaspoon to oz of Salt
		double recipeCookieSaltOz = (double)recipeCookieSaltTeaspoon/6;
		
		
		double recipeCookieButterCup = 1;
		//Change cup to lb of butter
		double recipeCookieButterLb = (double)recipeCookieButterCup/2;
		
		
		double recipeCookieSugarCup = 3.0/2.0;
		//Change Cup to Lb of Sugar
		double recipeCookieSugarLb = (double)recipeCookieSugarCup/2;
		
		
		double recipeCookieVanillaExtractTeaspoon = 1;
		//Change teaspoon to a liquid ounce of VanillaExtract
		double recipeCookieVanillaExtractOz = (double)recipeCookieVanillaExtractTeaspoon/6;
		
		
		double recipeCookieEgg = 2;		
		double recipeCookieChocolateChipCup = 5.0/2.0;

		//================================ recipe and change value of a loaf of banana bread
		double recipeBananaBreadLoaf = 1;
		double recipeBananaBreadAllPurposeFlourCup = 3.0/2.0;
		//Change cup to Lb of flour
		double recipeBananaBreadAllPurposeFlourLb = (double)recipeBananaBreadAllPurposeFlourCup * 3.0/10.0;
		
		
		double recipeBananaBreadBakingSodaTeaspoon = 1;
		//Change teaspoon to oz of baking soda
		double recipeBananaBreadBakingSodaOz = (double)recipeBananaBreadBakingSodaTeaspoon/6;
		
				
		double recipeBananaBreadSaltTeaspoon = 1.0/8.0;
		//Change teaspoon to oz of Salt
		double recipeBananaBreadSaltOz = (double)recipeBananaBreadSaltTeaspoon/6;		
		
		double recipeBananaBreadButterCup = 1.0/3.0;
		//Change cup to lb of butter
		double recipeBananaBreadButterLb = (double)recipeBananaBreadButterCup/2;
		
		
		double recipeBananaBreadSugarCup = 3.0/4.0;
		//Change Cup to Lb of Sugar
		double recipeBananaBreadSugarLb = (double)recipeBananaBreadSugarCup/2;
		
				
		double recipeBananaBreadVanillaExtractTeaspoon = 1;
		//Change teaspoon to a liquid ounce of VanillaExtract
		double recipeBananaBreadVanillaExtractOz = (double)recipeBananaBreadVanillaExtractTeaspoon/6;
		
		
		double recipeBananaBreadEgg = 1;
		double recipeBananaBreadBanana = 2;		
		
		double scaleCookie = (double)Math.ceil(cookieCount/12.0)/(recipeCookieDozen);		
		
		//============================ ingredients for x cookieCount
		double desiredCookieAllPurposeFlourLb = scaleCookie * recipeCookieAllPurposeFlourLb;
		double desiredCookieBakingSodaOz = scaleCookie * recipeCookieBakingSodaOz;		
		double desiredCookieSaltOz = scaleCookie * recipeCookieSaltOz;		
		double desiredCookieButterLb = scaleCookie * recipeCookieButterLb;		
		double desiredCookieSugarLb = scaleCookie * recipeCookieSugarLb;		
		double desiredCookieVanillaExtractOz = scaleCookie * recipeCookieVanillaExtractOz;		
		double desiredCookieEgg = scaleCookie * recipeCookieEgg;		
		double desiredCookieChocolateChipCup = scaleCookie * recipeCookieChocolateChipCup;
		
		
		double scaleBananaBread = (double)loafCount/recipeBananaBreadLoaf;
		//============================ ingredients for x loaf of Banana Bread
		double desiredBananaBreadAllPurposeFlourLb = scaleBananaBread * recipeBananaBreadAllPurposeFlourLb;
		double desiredBananaBreadBakingSodaOz = scaleBananaBread * recipeBananaBreadBakingSodaOz;
		double desiredBananaBreadSaltOz = scaleBananaBread * recipeBananaBreadSaltOz;
		double desiredBananaBreadButterLb = scaleBananaBread * recipeBananaBreadButterLb;
		double desiredBananaBreadSugarLb = scaleBananaBread * recipeBananaBreadSugarLb;
		double desiredBananaBreadVanillaExtractOz = scaleBananaBread * recipeBananaBreadVanillaExtractOz;
		double desiredBananaBreadEgg = scaleBananaBread * recipeBananaBreadEgg;
		double desiredBananaBreadBanana = scaleBananaBread * recipeBananaBreadBanana;
		
		//============================ total ingredients for cookies and banana bread
		double desiredAllPurposeFlourLb = desiredCookieAllPurposeFlourLb + desiredBananaBreadAllPurposeFlourLb;
		double desiredBakingSodaOz = desiredCookieBakingSodaOz + desiredBananaBreadBakingSodaOz;
		double desiredSaltOz = desiredCookieSaltOz + desiredBananaBreadSaltOz;
		double desiredButterLb = desiredCookieButterLb + desiredBananaBreadButterLb;
		double desiredSugarLb = desiredCookieSugarLb + desiredBananaBreadSugarLb;
		double desiredVanillaExtractOz = desiredCookieVanillaExtractOz + desiredBananaBreadVanillaExtractOz;
		double desiredEgg = desiredCookieEgg + desiredBananaBreadEgg;
		double desiredChocolateChipCup = desiredCookieChocolateChipCup;
		double desiredBanana = desiredBananaBreadBanana;
		
		//=============================		
		double bagOfFlour = Math.ceil(desiredAllPurposeFlourLb/5);
		double costAllPurposeFlourLb =  bagOfFlour * 4.49;
		
		double boxOfBakingSoda = Math.ceil(desiredBakingSodaOz/16);
		double costBakingSodaOz = boxOfBakingSoda * 1.09;
		
		double packageOfSalt = Math.ceil(desiredSaltOz/26);
		double costSaltOz = packageOfSalt * 1.09;
		
		double packageOfButter = Math.ceil(desiredButterLb);
		double costButterLb = packageOfButter * 3.79;
		
		double bagOfSugar = Math.ceil(desiredSugarLb);		
		double costSugarLb = bagOfSugar * 1.99;
		
		double bottleOfVanillaExtract = Math.ceil(desiredVanillaExtractOz);
		double costVanillaExtractOz = bottleOfVanillaExtract * 5.09;
		
		double cartonOfEgg = Math.ceil(desiredEgg/12);
		double costEgg = cartonOfEgg * 1.79;
		
		double banana = Math.ceil(desiredBanana);
		double costBanana = banana * 0.32;
		
		double bagOfChocolateChip = Math.ceil(desiredChocolateChipCup/2);
		double costChocolateChipCup = bagOfChocolateChip * 4.19;
		double totalCost = costAllPurposeFlourLb + costBakingSodaOz + costSaltOz 
				+ costButterLb + costSugarLb + costVanillaExtractOz + costEgg 
				+ costBanana + costChocolateChipCup;
		System.out.println("Shopping list for " + cookieCount + " cookie(s) and " + loafCount + " loaf(s) of bread:");
		System.out.println( (int)bagOfFlour + " bag(s) of flour");
		System.out.println( (int)packageOfSalt + " package(s) of salt");
		System.out.println( (int)boxOfBakingSoda + " box(s) of baking soda");
		System.out.println( (int)bottleOfVanillaExtract + " bottle(s) of vanilla extract");
		System.out.println( (int)cartonOfEgg + " carton(s) of eggs");
		System.out.println( (int)bagOfSugar + " bag(s) of sugar");
		System.out.println( (int)packageOfButter + " package(s) of butter");
		System.out.println( (int)banana + " banana(s)");
		System.out.println( (int)bagOfChocolateChip + " bag(s) of chocolate chips");
		System.out.println("Total cost: $" + totalCost);
	}

}
