import java.util.ArrayList;

//to test the Molecule implementation
public class TestMolecule {
	
	    //helper methods//
	    //create an arraylist of atoms of the appropriate type
	    public static  ArrayList<Atom> atomList(int len, String type){
	    	ArrayList<Atom> theAtoms = new ArrayList<Atom>();
	    	for(int i=0;i<len;i++) theAtoms.add(new Atom(type));//supply of atoms of the specified type
	    	return theAtoms;
			
	    }
	
	    //these are so that I have some stored, nothing to do with the actual implementation
		public static Molecule createMolecule(String name, ArrayList<Atom> carbonAtoms, ArrayList<Atom> oxygenAtoms, ArrayList<Atom> nitrogenAtoms) {
			
			
			Molecule mol = new TreeMolecule(carbonAtoms.get(0));//all molecules contain an initial carbon atom
			
			if(name.equals("methane")) return mol;
			if(name.equals("ethane")) {
				mol.addBond(carbonAtoms.get(0), carbonAtoms.get(1), 1);
				return mol;
			}
			
			if(name.equals("ethene")) {
				mol.addBond(carbonAtoms.get(0), carbonAtoms.get(1), 2);
				return mol;
			}
			
			if(name.equals("ethyne")) {
				mol.addBond(carbonAtoms.get(0), carbonAtoms.get(1), 3);
				return mol;
			}
			
			if(name.equals("dimethyl ether")) {
				mol.addBond(carbonAtoms.get(0), oxygenAtoms.get(0), 1);
				mol.addBond(oxygenAtoms.get(0), carbonAtoms.get(1), 1);
				
				return mol;
			}
			
			if(name.equals("ethanol")) {
				mol.addBond(carbonAtoms.get(0), carbonAtoms.get(1), 1);
				mol.addBond(carbonAtoms.get(1), oxygenAtoms.get(0), 1);
				
				return mol;
			}
			
			if(name.equals("acetaldehyde")) {
				mol.addBond(carbonAtoms.get(0), carbonAtoms.get(1), 1);
				mol.addBond(carbonAtoms.get(1), oxygenAtoms.get(0), 2);
				
				return mol;
			}
			
			if(name.equals("hydrogen cyanide")) {
				mol.addBond(carbonAtoms.get(0), nitrogenAtoms.get(0), 3);
				return mol;
			}
			
			if(name.equals("isobutyl alcohol")) {
				mol.addBond(carbonAtoms.get(0), carbonAtoms.get(1), 1);
				mol.addBond(carbonAtoms.get(1), carbonAtoms.get(2), 1);
				mol.addBond(carbonAtoms.get(1), carbonAtoms.get(3), 1);
				mol.addBond(carbonAtoms.get(3), oxygenAtoms.get(0), 1);
				
				return mol;
			}
			
			if(name.equals("5-amino-4-methylpentanamide")) {
				mol.addBond(carbonAtoms.get(0), carbonAtoms.get(1), 1);
				mol.addBond(carbonAtoms.get(1), carbonAtoms.get(2), 1);
				mol.addBond(carbonAtoms.get(2), carbonAtoms.get(3), 1);
				mol.addBond(carbonAtoms.get(3), carbonAtoms.get(4), 1);
				
				mol.addBond(carbonAtoms.get(4), oxygenAtoms.get(0), 2);
				mol.addBond(carbonAtoms.get(4), nitrogenAtoms.get(0), 1);
				mol.addBond(carbonAtoms.get(1), carbonAtoms.get(5), 1);
				mol.addBond(carbonAtoms.get(5), nitrogenAtoms.get(1), 1);	
				
				return mol;
			}
			
			return null;
			
		}

		//choose a molecule, build it and output strings
		public static void main(String[] args) {
			//create a supply of atoms - amend as necessary
			ArrayList<Atom> carbonAtoms = atomList(10, "C");//supply of carbon atoms
			ArrayList<Atom> oxygenAtoms = atomList(10, "O");//supply of oxygen atoms
			ArrayList<Atom> nitrogenAtoms = atomList(10, "N");//supply of nitrogen atoms
			
			String name = "isobutyl alcohol";
	        Molecule mol = createMolecule(name, carbonAtoms, oxygenAtoms, nitrogenAtoms);
	        System.out.println(name + " has smiles string " + mol.smilesString());
	        System.out.println(name + " and structure " + mol.structuralFormula());
	        boolean containsAtom = mol.contains(oxygenAtoms.get(1));
	        String output = "";
	        if(containsAtom) output+=" contains ";
	        else output+=" doesn't contain ";
	        output+="the atom in question";
	        System.out.println(name+ "" + output);
		}


	

}
