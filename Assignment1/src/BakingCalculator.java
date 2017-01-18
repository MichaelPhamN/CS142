public class BakingCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cookieCount = 24;
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
		
		
		double scaleCookie = (double)cookieCount/(recipeCookieDozen * 12);
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
		
		
	}

}
