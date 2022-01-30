
package driver;

// import model.Automobile;
import adapter.*;

public class Driver {

	public static void main(String[] args) {
		BuildAuto buildAutoInterface = new BuildAuto();
		buildAutoInterface.init(); // only call this once
		// Build Automobile Object from a file.
		String FordZTWAutomobileKey = buildAutoInterface.buildAuto("FordZTW.txt");
		String TeslaModelYAutomobileKey = buildAutoInterface.buildAuto("TeslaModelY.txt");
		if (TeslaModelYAutomobileKey != null) {
			// Print attributes before serialization
			buildAutoInterface.printAuto(TeslaModelYAutomobileKey);
			// update an options set's name
			buildAutoInterface.updateOptionSetName(TeslaModelYAutomobileKey, "Color", "Colors");
			// update an options set's option price
			buildAutoInterface.updateOptionPrice(TeslaModelYAutomobileKey, "Trim", "Brushed Aluminum trim", 2000);
			// choose a transmission option
			buildAutoInterface.setOptionChoice(TeslaModelYAutomobileKey, "Tier", "Full Self-Driving Capability");
			// Serialize the object
			buildAutoInterface.serialize(TeslaModelYAutomobileKey, "TeslaModelY.data");
		} else {
			System.out.println("Could not build automobile");
		}
		// Deserialize the object and read it into memory.
		String TeslaModelYAutomobileKey2 = buildAutoInterface.deserialize("TeslaModelY.data");
		// Print new attributes
		if (TeslaModelYAutomobileKey2 != null) {
			// Print attributes after deserialization
			buildAutoInterface.printAuto(TeslaModelYAutomobileKey2);
			// Print transmission choice
			String optionName = buildAutoInterface.getOptionChoice(TeslaModelYAutomobileKey, "Transmission");
			if (optionName != null) {
				System.out.println("Transmission choice: " + optionName);
			}
			// Print transmission choice price
			Double optionPrice = buildAutoInterface.getOptionChoicePrice(TeslaModelYAutomobileKey, "Transmission");
			if (optionName != null) {
				System.out.println("Transmission choice price: $" + optionPrice);
			}
		} else {
			System.out.println("could not deserialize automobile");
		}
	}

}
