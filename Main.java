public class Main {
    public static void main(String[] args) {
        Atom hydrogen1 = new Atom("H");
        TreeMolecule treeMolecule = new TreeMolecule(hydrogen1);
        System.out.println(treeMolecule.structuralFormula());
    }
}
