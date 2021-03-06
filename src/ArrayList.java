import java.util.Iterator;

/**
 * 
 * @author Mhlongo L
 *
 */
public class ArrayList<T> implements List<T>, Iterator<T> {
	
	private T[] array;
	private Integer size;
	private Integer arrayLength;
	private Integer strategy;
	
	//The default constructor
	public ArrayList(){
		this(1);
	}
	/*
	 * The overloaded constructor for creating an arrayList
	 * @param strategy
	 */
	public ArrayList(Integer strategy){
		this.strategy = strategy;
		this.arrayLength = 1;
		this.array = createArray(this.arrayLength);
		this.size = 0;
	}
	
	/*
	 * A helper method for creating the underlying array
	 * @param size - size of an array
	 */
	private T[] createArray(int size) {
		// TODO Auto-generated method stub
		Object[] objArray = new Object[size];
		
		return (T[])objArray;
	}
	/**
	 * The method for retrieving the element from the arrayList
	 * 
	 * @param the index to retrieve from
	 */
	@Override
	public T get(Integer i) {
		// TODO Auto-generated method stub
		if(i >= size){
			throw new ArrayListException("Index greater than size");
		}
		if(i < 0){
			throw new ArrayListException("Index out of range");
		}
		return array[i];
	}
	/**
	 * The method for replacing an element in the ArrayList
	 * 
	 * @param i-index
	 * @param e-element
	 */
	@Override
	public void set(Integer i, T e) {
		// TODO Auto-generated method stub
		if(i >= size){
			throw new ArrayListException("Index greater than size");
		}
		if(i < 0){
			throw new ArrayListException("Index out of range");
		}
		
		array[i] = e;
		
	}
	/**
	 * The method for adding en element to the ArrayList
	 * 
	 * @param i - index for where the new element needs to be added
	 * @param e - element
	 */
	@Override
	public void add(Integer i, T e) {
		// TODO Auto-generated method stub
		if(i>size){
			throw new ArrayListException("Index greater than Array size");
		}else if(i<0){
			throw new ArrayListException("Index out of bound less than zero");
		}
		if(size == arrayLength -1){
			expandArray();
		}
		shiftElementsRight(i);
		array[i] = e;
		size++;
	}

	/**
	 * The method for removing an element from the ArrayList
	 * 
	 * @param i - index of the element for removal
	 */
	@Override
	public T remove(Integer i) {
		// TODO Auto-generated method stub
		T removedElements = array[i];
		if(i>size){
			throw new ArrayListException("Index greater than array size");
		}else if(i<0){
			throw new ArrayListException("Index out of bound less than zero");
		}
		shiftElementsLeft(i);
		size--;
		
		return removedElements;
	}
	/**
	 * The auxiliary method to determine the size of the ArrayList
	 */
	@Override
	public Integer size() {
		// TODO Auto-generated method stub
		return size;
	}
	/**
	 * The auxiliary method to check if the list is empty
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * The method creates a new array thta depends on the strategy
	 * (1 for incremental and 2 for doubling)
	 */
	private void expandArray(){
		int length = arrayLength;
		if(strategy ==1){
			arrayLength += 10;
		}else if(strategy ==2){
			arrayLength *=2;
		}
		T[] newArray = createArray(this.arrayLength);
		for(int i=0; i<length;i++){
			newArray[i] = array[i];
		}
		
		array = newArray;
	}
	/**
	 * The method for shifting all elements up by one to the right
	 * @param position - index from where to shift
	 */
	private void shiftElementsRight(Integer position){
		for(int i=this.size;i>=position;i--){
			this.array[i+1]=this.array[i];
		}
	}
	/**
	 * The method for shifting all elements up by one to the left
	 * @param position - index from where to shift
	 */
	private void shiftElementsLeft(Integer position){
		for(int i=position; i<size;i++){
			this.array[i] = this.array[i+1];
		}
	}
	/**
	 * The overridden iterator method
	 * @return Iterator
	 */
	public Iterator<T> iterator(){
		return new ArrayListIterator<>(this);
	}
	/**
	 * The overridden toString method
	 * @return String
	 */
	public String toString(){
		String str = "[";
		for(int i=0;i<size-1;i++){
			str += array[i].toString()+",";
		}
		if(size>0){
			str += array[size -1];
		}
		str +="]";
		return str;
	}

}
