package seq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SeqCollection implements java.lang.Iterable<Sequence>{

	private Map<String, Sequence> map;
	private ArrayList<String> idList;

	public SeqCollection() {
		map = new HashMap<String, Sequence>();
		idList = new ArrayList<String>();
	}
	
	public void add(Sequence seq) {
		this.map.put(seq.getId(), seq);
		this.idList.add(seq.getId());
	}
	
	public Sequence get(String seqId) {
		return this.map.get(seqId);
	}
	
	public ArrayList<String> getIdList(){
		return this.idList;
	}
	
	public int length() {
		return this.idList.size();
	}

	@Override
	public Iterator<Sequence> iterator() {
		return new SeqCollectionIterator();
	}
	
	private class SeqCollectionIterator implements Iterator<Sequence> {
        private int position = 0;

		@Override
		public boolean hasNext() {
			if (position < SeqCollection.this.length())
				return true;
			else
				return false;
		}

		@Override
		public Sequence next() {
			if (this.hasNext()) {
				String nextId = SeqCollection.this.idList.get(position++);
                return SeqCollection.this.get(nextId);
			}
            else
                return null;
		}
	}
}
