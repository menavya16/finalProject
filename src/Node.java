import java.util.ArrayList;

// A node of chains
class Node<K>
{
	
	//these are set to public so they can easily be accessed in the hashtable.java
	public K key;
	public int female;
	public int male;

	// Reference to next node
	Node<K> next;

	// Constructor
	public Node(K key, int femaleN, int maleN)
	{
		this.key = key;
		this.female = femaleN;
		this.male=maleN;
	}
}