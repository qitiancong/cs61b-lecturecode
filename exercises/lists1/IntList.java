public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (this.rest == null) { //base case when the node has no rest, ie. 1 element only.
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this; //p points to original list initially.
		int size = 0;
		while(p != null) {  //while p still points to any list
			size += 1;
			p = p.rest;
		}
		return size;
	}

	/** Returns the ith value in this list. ( this use iteration) */
	public int iterGet(int i) {
		int j = 0;
		IntList p = this;
		while (j != i) {
			p = p.rest; //shift pointer down the list while incrementing j.
			j +=1;
		}
		return p.first;
	}

	/** Returns the ith value in this list. ( this use recursion) */
	public int recurrGet(int i) {
		if (i == 0) {
			return this.first; //base case: get the 1st item of the list
		}
		return this.rest.recurrGet(i-1); // my 5th item is my.rest 's 4th item, etc.
	}

	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);

		System.out.println(L.size());
		System.out.println(L.iterativeSize());
		System.out.println(L.recurrGet(1));
		System.out.println(L.recurrGet(2));
	}
} 