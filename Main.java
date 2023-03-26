public class Main {
    public static void main(String[] args) {
        Atom hydrogen1 = new Atom("H");
        Atom oxygen1 = new Atom("O");
        TreeMolecule treeMolecule = new TreeMolecule(hydrogen1);
        treeMolecule.addBond(hydrogen1, oxygen1, 1);
        System.out.println(treeMolecule.structuralFormula());
    }
}
