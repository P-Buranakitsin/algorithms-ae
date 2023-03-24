//add name and id as comment
// Pavaruth Buranakitsin 2646802B

//add import statement

public class TreeMolecule implements Molecule {

        private Atom first;

        // add constructor, implemented methods and any helper methods you require
        public TreeMolecule(Atom atom) {
                if (this.first != null) {
                        throw new IllegalStateException("TreeMolecule already has a root atom");
                }
                this.first = atom;
        }

        @Override
        public boolean addBond(Atom a1, Atom a2, int strength) {
                if (!this.contains(a1) || !this.contains(a2)) {
                        return false;
                }

                if (a1.equals(a2)) {
                        return false;
                }
                return false;
        }

        @Override
        public boolean contains(Atom a) {
                return this.search(this.first, a);
        }

        private boolean search(Atom current, Atom target) {
                if (current == null) {
                        return false;
                }
                if (current.equals(target)) {
                        return true;
                }
                for (Bond bond : current.getBonds()) {
                        if (this.search(bond.getChild(), target)) {
                                return true;
                        }
                }
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
