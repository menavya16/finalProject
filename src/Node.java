import java.util.ArrayList;

// A node of chains
class Node<K, V1, V2>
{
	K key;
	V1 value1;
	V2 value2;

	// Reference to next node
	Node<K, V1, V2> next;

	// Constructor
	public Node(K key, V1 value1, V2 value2)
	{
		this.key = key;
		this.value1 = value1;
		this.value2=value2;
	}
}