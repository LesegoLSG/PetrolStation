import java.util.Iterator;


public class ArrayListIterator<T> implements Iterator<T> {
	private ArrayList<T> list;
	private int cursor;
	
	public ArrayListIterator(ArrayList<T> list){
		this.list = list;
		if(!list.isEmpty()){
			this.cursor = 0;
		}
	}
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

	@Override
	public T next() {
		// TODO Auto-generated method stub
		T nextItem = list.get(this.cursor);
		this.cursor++;
		
		return nextItem;
	}
	
	public void remove(){
		
	}

}
