public class Main {
    public static void main(String[] args) {
        Atom carbon1 = new Atom("C");
        Atom oxygen1 = new Atom("O");
        Atom carbon2 = new Atom("C");
        TreeMolecule treeMolecule = new TreeMolecule(carbon1);
        treeMolecule.addBond(carbon1, oxygen1, 1);
        treeMolecule.addBond(oxygen1, carbon2, 1);
    }
}
