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

	@Override
	public Iterator iterator() {
		return new SeqCollectionIterator();
	}
	
	private class SeqCollectionIterator implements Iterator {
        private int position = 0;

		@Override
		public boolean hasNext() {
			if (position < SeqCollection.this.idList.size())
				return true;
			else
				return false;
		}

		@Override
		public Object next() {
			if (this.hasNext()) {
				String nextId = SeqCollection.this.idList.get(position++);
                return SeqCollection.this.get(nextId);
			}
            else
                return null;
		}
	}
}
