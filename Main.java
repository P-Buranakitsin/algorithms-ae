public class Main {
    public static void main(String[] args) {
        Atom atom1 = new Atom("C");
        Atom atom2 = new Atom("C");
        Atom atom3 = new Atom("C");
        Atom atom4 = new Atom("C");
        Atom atom5 = new Atom("C");
        Atom atom6 = new Atom("C");
        TreeMolecule treeMolecule = new TreeMolecule(atom1);
        treeMolecule.addBond(atom1, atom2, 1);
        treeMolecule.addBond(atom1, atom3, 1);
        treeMolecule.addBond(atom1, atom4, 1);
        treeMolecule.addBond(atom1, atom5, 1);
        treeMolecule.addBond(atom1, atom6, 1);
        System.out.println(treeMolecule.structuralFormula());
    }
}
