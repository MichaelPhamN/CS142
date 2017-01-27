
public class FarmerSolver1 {

	public static void main(String[] args) {
		// True if on left bank, false on right bank
		// The testing/grading program will modify these to try out
		// different starting positions!
		// You can test your code by temporarily modifying them yourself.
		boolean currentFarmerPosition = true;
		boolean currentWolfPosition = true;
		boolean currentGoatPosition = true;
		boolean currentCabbagePosition = true;

		// Print out the starting positions
		if (currentFarmerPosition) {
			System.out.println("Farmer begins on left bank");
		} else {
			System.out.println("Farmer begins on right bank");
		}
		if (currentWolfPosition) {
			System.out.println("Wolf begins on left bank");
		} else {
			System.out.println("Wolf begins on right bank");
		}
		if (currentGoatPosition) {
			System.out.println("Goat begins on left bank");
		} else {
			System.out.println("Goat begins on right bank");
		}
		if (currentCabbagePosition) {
			System.out.println("Cabbage begins on left bank");
		} else {
			System.out.println("Cabbage begins on right bank");
		}
		
		
		
		// As long as something is still on the left bank,
		// we will keep looping (until we solve the game!)
		while (currentFarmerPosition || currentWolfPosition || currentGoatPosition || currentCabbagePosition) {
			// This represents the move that the player wants to make
			
			/* Write code below to modify the positions */

			// The code currently here is an example!
			// You will want to set up the nextPosition variables
			// to move based on the currentPosition variables and the rules.
			// This code will involve if statements!
			// You can define additional variables yourself if you'd like.
			// You should not have to write any loops!
			boolean nextFarmerPosition = false;
			boolean nextWolfPosition = false;
			boolean nextGoatPosition = true;
			boolean nextCabbagePosition = false;

			if(currentFarmerPosition && currentWolfPosition && currentGoatPosition && currentCabbagePosition){				
				nextFarmerPosition = false;
				nextWolfPosition = true;
				nextGoatPosition = false;
				nextCabbagePosition = true;
			}
			
			if(!currentFarmerPosition && currentWolfPosition && !currentGoatPosition && currentCabbagePosition){
				nextFarmerPosition = true;
				nextWolfPosition = true;
				nextGoatPosition = false;
				nextCabbagePosition = true;
			}
			
			if(currentFarmerPosition && currentWolfPosition && !currentGoatPosition && currentCabbagePosition){
				nextFarmerPosition = false;
				nextWolfPosition = true;
				nextGoatPosition = false;
				nextCabbagePosition = false;
			}
			
			if(!currentFarmerPosition && currentWolfPosition && !currentGoatPosition && !currentCabbagePosition){
				nextFarmerPosition = true;
				nextWolfPosition = true;
				nextGoatPosition = true;
				nextCabbagePosition = false;
			}
			
			if(currentFarmerPosition && currentWolfPosition && currentGoatPosition && !currentCabbagePosition){
				nextFarmerPosition = false;
				nextWolfPosition = false;
				nextGoatPosition = true;
				nextCabbagePosition = false;
			}
			
			if(!currentFarmerPosition && !currentWolfPosition && currentGoatPosition && !currentCabbagePosition){
				nextFarmerPosition = true;
				nextWolfPosition = false;
				nextGoatPosition = true;
				nextCabbagePosition = false;
			}
			
			if(currentFarmerPosition && !currentWolfPosition && currentGoatPosition && !currentCabbagePosition){
				nextFarmerPosition = false;
				nextWolfPosition = false;
				nextGoatPosition = false;
				nextCabbagePosition = false;
			}
			/* Write code above to modify the positions */
			
			// Counts how many object position variables differ in next vs current.
			int numberOfObjectsMoving = 0;
			
			// Keeps track of whether an error occurred (so the move won't be allowed)
			// Your code above shouldn't cause errors to occur!
			boolean didErrorOccur = false;
			
			// Farmer
			if (currentFarmerPosition == nextFarmerPosition) {
				System.out.println("Farmer must move!");
				didErrorOccur = true;
			}
			// Wolf
			if (currentWolfPosition != nextWolfPosition) {
				// Make sure the farmer is on the same side
				if (currentFarmerPosition != currentWolfPosition) {
					System.out.println("Wolf and farmer must move together!");
					didErrorOccur = true;
				}
				numberOfObjectsMoving = numberOfObjectsMoving + 1;
			}
			// Goat
			if (currentGoatPosition != nextGoatPosition) {
				// Make sure the farmer is on the same side
				if (currentFarmerPosition != currentGoatPosition) {
					System.out.println("Goat and farmer must move together!");
					didErrorOccur = true;
				}
				numberOfObjectsMoving = numberOfObjectsMoving + 1;
			}
			// Cabbage
			if (currentCabbagePosition != nextCabbagePosition) {
				// Make sure the farmer is on the same side
				if (currentFarmerPosition != currentCabbagePosition) {
					System.out.println("Wolf and cabbage must move together!");
					didErrorOccur = true;
				}
				numberOfObjectsMoving = numberOfObjectsMoving + 1;
			}
			
			if (numberOfObjectsMoving > 1) {
				System.out.println("You're moving too many things!");
				didErrorOccur = true;
			}
			
			// Check if the goat is alone with the cabbage.
			// The goat is alone with the cabbage if next goat position is
			// the same as the next cabbage position and the next farmer
			// position is not the same as the next goat position.
			
			if (nextGoatPosition == nextCabbagePosition &&
					nextFarmerPosition != nextGoatPosition) {
				System.out.println("The goat would eat the cabbage!");
				didErrorOccur = true;
			}
			
			// Check if the wolf is alone with the goat.
			if (nextGoatPosition == nextWolfPosition &&
					nextFarmerPosition != nextGoatPosition) {
				System.out.println("The wolf would eat the goat!");
				didErrorOccur = true;
			}
			
			if (!didErrorOccur) {
				// Make the move happen if an error didn't occur.
				currentFarmerPosition = nextFarmerPosition;
				currentGoatPosition = nextGoatPosition;
				currentWolfPosition = nextWolfPosition;
				currentCabbagePosition = nextCabbagePosition;
				if (currentFarmerPosition) {
					System.out.println("Farmer is now on left bank");
				} else {
					System.out.println("Farmer is now on right bank");
				}
				if (currentWolfPosition) {
					System.out.println("Wolf is now on left bank");
				} else {
					System.out.println("Wolf is now on right bank");
				}
				if (currentGoatPosition) {
					System.out.println("Goat is now on left bank");
				} else {
					System.out.println("Goat is now on right bank");
				}
				if (currentCabbagePosition) {
					System.out.println("Cabbage is now on left bank");
				} else {
					System.out.println("Cabbage is now on right bank");
				}
			}
		}
	}

}