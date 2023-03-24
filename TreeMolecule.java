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
                // a1 should already be in the molecule
                if (!this.contains(a1)) {
                        return false;
                }
                // a2 should not be the exact same object as a1, but it can of the same type
                if (a1.equals(a2)) {
                        return false;
                }
                // strength cannot be more than the valency of a1
                if (strength > a1.getValency()) {
                        return false;
                }

                // remove all excess hydrogens
                a1.getBonds().subList(0, strength).clear();

                a1.addBond(a2, strength);

                // remove all excess hydrogens
                a2.getBonds().subList(0, strength).clear();

                return true;
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

        public Atom getFirst() {
            return first;
        }

}
