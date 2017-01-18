public class BakingCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cookieCount = 24;
		int loafCount = 1;
		
		double recipeCookieDozen = 4;
		
		double recipeCookieAllPurposeFlourCup = 9/4;
		//Change Cup to Lb of flour
		double recipeCookieAllPurposeFlourLb = recipeCookieAllPurposeFlourCup/(10/3);		
		
		double recipeCookieBakingSodaTeaspoon = 1;
		//Change teaspoon to oz of baking soda
		double recipeCookieBakingSodaOz = recipeCookieBakingSodaTeaspoon/6;
		
		double recipeCookieSaltTeaspoon = 1;
		//Change teaspoon to oz of Salt
		double recipeCookieSaltOz = recipeCookieSaltTeaspoon/6;
		
		double recipeCookieButterCup = 1;
		
		double recipeCookieSugarCup = 3/2;
		//Change teaspoon to Lb of Sugar
		double recipeCookieSugarLb = recipeCookieSugarCup/2;
		
		double recipeCookieVanillaExtractTeaspoon = 1;
		//Change teaspoon to a liquid ounce of VanillaExtract
		double recipeCookieVanillaExtractOz = recipeCookieVanillaExtractTeaspoon/6;
		
		double recipeCookieEgg = 2;
		double recipeCookieChocolateChipCup = 5/2;
		
		double recipeBananaBreadLoaf = 1;
		double recipeBananaBreadAllPurposeFlourCup = 3/2;
		//Change cup to Lb of flour
		double recipeBananaBreadAllPurposeFlourLb = recipeBananaBreadAllPurposeFlourCup/(10/3);
		
		//Change cup to Lb of flour
		double recipeBananaBreadBakingSodaTeaspoon = 1;
		
		//Change cup to Lb of flour
		double recipeBananaSaltTeaspoon = 1/8;
		
		//Change cup to Lb of flour
		double recipeBananaBreadButterCup = 1/3;
		
		//Change cup to Lb of flour
		double recipeBananaBreadSugarCup = 3/4;
		
		//Change cup to Lb of flour
		double recipeBananaBreadVanillaExtractTeaspoon = 1;
		
		double recipeBananaBreadEgg = 1;
		double recipeBananaBreadBanana = 2;
		
		
		double scaleCookie = (double)cookieCount/(recipeCookieDozen * 12);
		double scaleBananaBread = (double)loafCount/recipeBananaBreadLoaf;
		
		
	}

}
