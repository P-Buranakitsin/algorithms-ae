// Add name and id as comment
// Pavaruth Buranakitsin 2646802B

// and import statements
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Atom {

	private String element;
	private List<Bond> bonds = new ArrayList<Bond>();// the bonds to child atoms
	private int valency;

	public Atom(String type) {
		
	}

	// this map has been included to help you look up valencies
	// but you can ignore it (and delete it) if you want to use something else

	private static final Map<String, Integer> VALENCY_MAP = createMap();

	private static Map<String, Integer> createMap() {
		Map<String, Integer> result = new HashMap<>();
		result.put("H", 1);// hydrogen
		result.put("C", 4);// carbon
		result.put("B", 3);// boron
		result.put("N", 3);// nitrogen
		result.put("O", 2);// oxygen
		result.put("F", 1);// fluorine
		result.put("P", 3);// phosphorous
		result.put("S", 2);// sulphur
		result.put("Cl", 1);// chlorine
		result.put("Br", 1);// bromine

		return Collections.unmodifiableMap(result);
	}

	// now add all of the Atom constructors and methods you require

}
