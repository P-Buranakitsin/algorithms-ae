public class Main {
    public static void main(String[] args) {
        Atom carbon1 = new Atom("O");
        TreeMolecule treeMolecule = new TreeMolecule(carbon1);
        System.out.println(treeMolecule.structuralFormula());
    }
}
