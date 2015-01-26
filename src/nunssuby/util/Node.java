package nunssuby.util;

 public class Node<E> {
	Node<E> next;
	E data;
	
	public int publicInt;
	protected int protectedInt;
	
	public Node(E e){
		this.data = e;
	}
}
