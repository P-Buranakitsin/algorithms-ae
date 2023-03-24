//add name and id as comment
// Pavaruth Buranakitsin 2646802B

//add import statement



public class TreeMolecule implements Molecule {

	private Atom first;

	
        //add constructor, implemented methods and any helper methods you require
        public TreeMolecule(Atom atom) {
                this.first = atom;
        }

        @Override
        public boolean addBond(Atom a1, Atom a2, int strength) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean contains(Atom a) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public String smilesString() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String structuralFormula() {
            // TODO Auto-generated method stub
            return null;
        }
	
	
}
