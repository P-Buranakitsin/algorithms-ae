public class Main {
    public static void main(String[] args) {
        Atom carbon1 = new Atom("C");
        Atom carbon2 = new Atom("C");
        TreeMolecule treeMolecule = new TreeMolecule(carbon1);
        System.out.println(treeMolecule.contains(carbon1));
    }
}
