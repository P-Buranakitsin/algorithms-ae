//add name and id as comment
// Pavaruth Buranakitsin 2646802B

//add import statement
import java.util.ArrayList;

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
                // a2 should not be the exact same object as a1, but it can of the same type (to
                // avoid confusion)
                if (a1.equals(a2)) {
                        return false;
                }
                // strength cannot be more than the valency of a1
                if (strength > a1.getValency()) {
                        return false;
                }
                // exit the method if there is no hydrogen left
                if (!containsHydrogen(a1)) {
                        return false;
                }
                if (this.contains(a2)) {
                        return false;
                }

                // remove all excess hydrogens
                a1.getBonds().subList(0, strength).clear();

                a1.addBond(a2, strength);

                // remove all excess hydrogens
                a2.getBonds().subList(0, strength).clear();

                return true;
        }

        private boolean containsHydrogen(Atom a1) {
                for (Bond bond : a1.getBonds()) {
                        if (bond.getChild().getElement().equals("H")) {
                                return true;
                        }
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
                        // recursive call
                        if (this.search(bond.getChild(), target)) {
                                return true;
                        }
                }
                return false;
        }

        @Override
        public String smilesString() {
                String formula = this.structuralFormula();
                // replace H and numbers with empty strings
                formula = formula.replaceAll("H\\d*|H(?=[^0-9]|$)", "");
                return formula;
        }

        @Override
        public String structuralFormula() {
                String formula = structuralFormulaHelper(this.first);
                return formula;
        }

        private String structuralFormulaHelper(Atom current) {
                String formulaString = "";
                formulaString += current.getElement();
                int hydrogenCount = 0;

                // index to count iterations
                int iteration = 0;

                for (Bond bond : current.getBonds()) {
                        if (bond.getChild().getElement().equals("H")) {
                                hydrogenCount++;
                                // print element name (Hydrogen) one time only
                                if (hydrogenCount <= 1) {
                                        formulaString += bond.getChild().getElement();
                                }
                                // if there is more than one hydrogens, print number of hydrogens
                                if (hydrogenCount > 1) {
                                        formulaString += hydrogenCount;
                                }
                                // replace old numbers with more recent ones
                                formulaString = formulaString.replaceAll("\\d+", Integer.toString(hydrogenCount));
                        } else {
                                // Assume that the last element of bond is a main line, so anything else is a
                                // branch
                                if (iteration < current.getBonds().size() - 1) {
                                        formulaString += "(";
                                }

                                // If bond's weight is either two or three, a symbol is printed
                                if (bond.getWeight() == 2) {
                                        formulaString += "=";
                                } else if (bond.getWeight() == 3) {
                                        formulaString += "#";
                                }

                                // recursive call
                                formulaString += structuralFormulaHelper(bond.getChild());

                                // Assume that the last element of bond is a main line, so anything else is a
                                // branch
                                if (iteration < current.getBonds().size() - 1) {
                                        formulaString += ")";
                                }
                        }
                        iteration++;
                }
                return formulaString;
        }

        public Atom getFirst() {
                return first;
        }

}
