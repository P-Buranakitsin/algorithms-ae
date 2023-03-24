//add name and id as comment
// Pavaruth Buranakitsin 2646802B 

//add import statements

//a bond is a pair (Atom, weight) 
public class Bond {

	private Atom child;
	private int weight;

	// add constructor, getters setters
	// and any other methods you require (if any)
	public Bond(Atom child, int weight) {
		this.child = child;
		this.weight = weight;
	}

	public Atom getChild() {
		return child;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return this.child.getElement() + " " + this.weight;
	}
}
