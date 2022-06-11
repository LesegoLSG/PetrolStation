import java.util.Iterator;

	/**
	 * 
	 * @author Mhlongo L
	 * An iterator over an ArrayList.
	 * @return Item that is contained in the list
	 */
public class ArrayListIterator<T> implements Iterator<T> {
	private ArrayList<T> list;
	private int cursor;
	
	/**
	 * The constructor
	 * @param list - the list to iterate over
	 */
	
	public ArrayListIterator(ArrayList<T> list){
		this.list = list;
		if(!list.isEmpty()){
			this.cursor = 0;
		}
	}
	/**
	 * return true if there next() will return an element
	 */
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		boolean hasnext = true;
		/*
		if(list.isEmpty()){
			hasnext = false;
			if(list.get(cursor+1) !=null){
				hasnext=true;
			}else{
				hasnext=false;
			}
		}
		*/
		return cursor<list.size();
	}
	/**
	 * @return the "next" item in the list and then advance the cursor
	 */
	@Override
	public T next() {
		// TODO Auto-generated method stub
		T nextItem = list.get(this.cursor);
		this.cursor++;
		
		return nextItem;
	}
	
	/**
	 * remove the item from the list
	 */
	public void remove(){
		//Keep java happy
	}

}
