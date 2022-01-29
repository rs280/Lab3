
package driver;

//import model.Automobile;
import adapter.*;

public class Driver {

	public static void main(String[] args) {
		BuildAuto buildAutoInterface = new BuildAuto();
		buildAutoInterface.init(); // only call this once
		// Build Automobile Object from a file.
		String FordZTWAutomobileKey = buildAutoInterface.buildAuto("FordZTW.txt");
		String BMW320iAutomobileKey = buildAutoInterface.buildAuto("BMW320i.txt");
		if (FordZTWAutomobileKey != null) {
			// Print attributes before serialization
			buildAutoInterface.printAuto(FordZTWAutomobileKey);
			// update an options set's name
			buildAutoInterface.updateOptionSetName(FordZTWAutomobileKey, "Color", "Colors");
			// update an options set's option price
			buildAutoInterface.updateOptionPrice(FordZTWAutomobileKey, "Transmission", "automatic", 50);
			// choose a transmission option
			buildAutoInterface.setOptionChoice(FordZTWAutomobileKey, "Transmission", "manual");
			// Serialize the object
			buildAutoInterface.serialize(FordZTWAutomobileKey, "FordZTW.data");
		} else {
			System.out.println("Could not build automobile");
		}
		// Deserialize the object and read it into memory.
		String FordZTWAutomobileKey2 = buildAutoInterface.deserialize("FordZTW.data");
		// Print new attributes
		if (FordZTWAutomobileKey2 != null) {
			// Print attributes after deserialization
			buildAutoInterface.printAuto(FordZTWAutomobileKey2);
			// Print transmission choice
			String optionName = buildAutoInterface.getOptionChoice(FordZTWAutomobileKey, "Transmission");
			if (optionName != null) {
				System.out.println("Transmission choice: " + optionName);
			}
			// Print transmission choice price
			Double optionPrice = buildAutoInterface.getOptionChoicePrice(FordZTWAutomobileKey, "Transmission");
			if (optionName != null) {
				System.out.println("Transmission choice price: $" + optionPrice);
			}
		} else {
			System.out.println("could not deserialize automobile");
		}
	}

}
