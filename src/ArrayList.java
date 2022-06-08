import java.util.Iterator;


public class ArrayList<T> implements List<T>, Iterator<T> {
	
	private T[] array;
	private Integer size;
	private Integer arrayLength;
	private Integer strategy;
	
	public ArrayList(){
		this(1);
	}
	
	public ArrayList(Integer strategy){
		this.strategy = strategy;
		this.arrayLength = 1;
		this.array = createArray(this.arrayLength);
		this.size = 0;
	}
	private T[] createArray(int size) {
		// TODO Auto-generated method stub
		Object[] objArray = new Object[size];
		
		return (T[])objArray;
	}

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

	@Override
	public Integer size() {
		// TODO Auto-generated method stub
		return size;
	}

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
	
	private void shiftElementsRight(Integer position){
		for(int i=this.size;i>=position;i--){
			this.array[i+1]=this.array[i];
		}
	}
	
	private void shiftElementsLeft(Integer position){
		for(int i=position; i<size;i++){
			this.array[i] = this.array[i+1];
		}
	}
	
	public Iterator<T> iterator(){
		return new ArrayListIterator<>(this);
	}
	
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
