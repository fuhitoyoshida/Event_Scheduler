import java.util.Iterator;



public class IntervalBST<K extends Interval> implements SortedListADT<K> {
	IntervalBSTnode<K> root;
	private int  numNodes;
	
	public IntervalBST() {
		root = null;
		numNodes = 0;
	}

	public void insert(K key){
		//TODO Remove this exception and implement the method
		if(root == null){
			root = new IntervalBSTnode<K>(key);
			return;
		}
		insertHelper(key, root);
		numNodes++;
	}

	private void insertHelper(K key, IntervalBSTnode<K> cur) {
		long kStart = key.getStart();
		long curStart = cur.getStart();
		if(key.overlap(cur.getKey()) || key.equals(cur.getKey())) {
			throw new IntervalConflictException();
		}
		//key would be inserted into cur's subtree
		if(key.getEnd() > cur.getMaxEnd()){
			cur.setMaxEnd(key.getEnd());
		}
		if(kStart < curStart){
			if(cur.getLeft() == null){
				IntervalBSTnode<K> n = new IntervalBSTnode<K>(key);
				cur.setLeft(n);
				return;
			}
			insertHelper(key, cur.getLeft());
		}else{
			if(cur.getRight() == null){
				IntervalBSTnode<K> n = new IntervalBSTnode<K>(key);
				cur.setRight(n);
				return;
			}
			insertHelper(key, cur.getRight());
		}
	}


	public boolean delete(K key) {
		//TODO Remove this exception and implement the method
		if(root == null) return false;
		if(root.getKey().equals(key)){
			//delete root
			root = deleteHelper(root);
			numNodes--;
			return true;
		}else{
			IntervalBSTnode<K> cur = root;
			while(cur != null){
				if(key.compareTo(cur.getKey()) == -1){
					//less than go left
					IntervalBSTnode<K> left = cur.getLeft();
					if(left == null) return false; //not found
					if(key.equals(left.getKey())) {
						cur.setLeft(deleteHelper(left));
						numNodes--;
						return true;
					}
					cur = cur.getLeft();
				}else {
					//larger than go right
					IntervalBSTnode<K> right = cur.getRight();
					if(right == null) return false; //not found
					if(key.equals(right.getKey())) {
						cur.setRight(deleteHelper(right));
						numNodes--;
						return true;
					}
					cur = cur.getRight();
				}
			}
			return false;
		}
	}

	private IntervalBSTnode<K> deleteHelper(IntervalBSTnode<K> target) {
		if(target.getRight() == null && target.getLeft() == null){
			return null;
		}
		if(target.getRight() != null && target.getLeft() != null){
			IntervalBSTnode<K> sub = target.getLeft();
			while(sub.getRight() != null){
				sub = sub.getRight();
			}
			return sub;
		}else{
			if(target.getRight() == null) return target.getLeft();
			return target.getLeft();
		}
	}

	public K lookup(K key) {
		return lookupHelper(key, root);
	}

	private K lookupHelper(K key, IntervalBSTnode<K> cur) {
		if(cur == null) return null;
		K curKey = (K) cur.getKey();
		if(curKey.equals(key)) return curKey;
		if(curKey.compareTo(key) < 0){
			return lookupHelper(key, cur.getLeft());
		}
		return lookupHelper(key, cur.getRight());
	}

	public int size() {
		return numNodes;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public Iterator<K> iterator() {
		return new IntervalBSTIterator<K>(root);
	}

}