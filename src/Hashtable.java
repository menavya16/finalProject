import java.util.ArrayList;

class Hashtable<K> {
	private ArrayList<Node<K>> arrayOfChains; // this array list stores an array
												// of chains

	private int initCapacity; // initial capacity of the array-list

	private int size;

	public Hashtable() {
		arrayOfChains = new ArrayList<>();
		initCapacity = 10;
		size = 0;

		for (int i = 0; i < initCapacity; i++)

			arrayOfChains.add(null); // set the array list to null for the
										// initial capacity
	}

	/**
	 * This private method returns the index of a specific key using the hash
	 * function
	 * 
	 * @param key
	 * @return index
	 */
	private int getIndex(K key) // get the index of the key
	{
		int hashCode = key.hashCode();
		int index = hashCode % initCapacity;
		return index;
	}

	public int remove(K key) {

		Node<K> head = arrayOfChains.get(getIndex(key));

		Node<K> prev = null;
		while (head != null) {
			if (head.key.equals(key))
				break;

			// Else keep moving in chain
			prev = head;
			head = head.next;
		}

		if (head == null)
			return -1;

		// Reduce size
		size--;

		// Remove key
		if (prev != null)
			prev.next = head.next;
		else
			arrayOfChains.set(getIndex(key), head.next);

		return head.female;
	}

	public int getFemale(K key) // returns the female value for a specific key
	{
		Node<K> head = arrayOfChains.get(getIndex(key)); // find the "head" of
															// chain for the key

		while (head != null) { // if node is not null
			if (head.key.equals(key)) // and if the key of that node equals the
										// key passed in the method
				return head.female; // return the female value for the node
			head = head.next;
		}

		return -1; // return -1 if not found
	}

	/**
	 * This method takes a unique key and returns the male value associated with
	 * the key
	 * 
	 * @param key
	 *            the unique key
	 * @return the male value for the unique key
	 */
	public int getMale(K key) {
		Node<K> head = arrayOfChains.get(getIndex(key));

		while (head != null) {
			if (head.key.equals(key))
				return head.male;
			head = head.next;
		}

		return -1;		//return -1 if not found
	}

	public void add(K key, int femaleN, int maleN) {
		// Find head of chain for given key
		Node<K> head = arrayOfChains.get(getIndex(key));

		while (head != null) { // if the key is already present
			if (head.key.equals(key)) {
				head.female = femaleN; // overwrite values
				head.male = maleN;
				return;
			}
			head = head.next;
		}

		size++;
		head = arrayOfChains.get(getIndex(key));
		Node<K> secondNode = new Node<K>(key, femaleN, maleN);
		secondNode.next = head;
		arrayOfChains.set(getIndex(key), secondNode);

		// If load factor goes beyond threshold, then double hash table size
		if ((1.0 * size) / initCapacity >= 0.7) {
			ArrayList<Node<K>> temp = arrayOfChains;
			arrayOfChains = new ArrayList<>();
			initCapacity = 2 * initCapacity;
			size = 0;
			for (int i = 0; i < initCapacity; i++)
				arrayOfChains.add(null);

			for (Node<K> headNode : temp) {
				while (headNode != null) {
					add(headNode.key, headNode.female, headNode.male);
					headNode = headNode.next;
				}
			}
		}

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

}
