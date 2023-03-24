//add name and id as comment
// Pavaruth Buranakitsin 2646802B

//add import statement
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
                // exit the method if there is no hydrogen left
                if (!containsHydrogen(a1)) {
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
                String formula = structuralFormulaHelper(this.first);
                return formula;
        }

        private String structuralFormulaHelper(Atom current) {
                // LinkedHashSet is used because it preserves insertion order and avoid repeated characters
                Set<String> formula = new LinkedHashSet<String>();
                String formulaString = "";
                formula.add(current.getElement());
                int hydrogenCount = 0;
                for (int i = 0; i < current.getBonds().size(); i++) {
                        if (current.getBonds().get(i).getChild().getElement().equals("H")) {
                                formula.add("H");
                                hydrogenCount++;
                        } else {
                                String weightString = "";
                                int weight = current.getBonds().get(i).getWeight();
                                if (weight == 2) {
                                        weightString = "=";
                                } else if (weight == 3) {
                                        weightString = "#";
                                }
                                formulaString = weightString + structuralFormulaHelper(current.getBonds().get(i).getChild()) +  formulaString;
                        }
                }
                if (hydrogenCount > 1) {
                        formula.add(Integer.toString(hydrogenCount));
                }
                System.out.println(formula);
                formulaString = String.join("", formula) + formulaString;
                return formulaString;
        }

        public Atom getFirst() {
                return first;
        }

}
