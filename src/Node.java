import java.util.ArrayList;

// A node of chains
class Node<K, Female, Male>
{
	
	//these are set to public so they can easily be accessed in the hashtable.java
	public K key;
	public Female femaleN;
	public Male maleN;

	// Reference to next node
	Node<K, Female, Male> next;

	// Constructor
	public Node(K key, Female femaleN, Male maleN)
	{
		this.key = key;
		this.femaleN = femaleN;
		this.maleN=maleN;
	}
}