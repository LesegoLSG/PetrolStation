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
		
	}

	@Override
	public void add(Integer i, T e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer size() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
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

}
