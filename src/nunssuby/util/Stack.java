package nunssuby.util;

public class Stack<E> {
	Node<E> top;
	
	void push(E e){
		top.data = e;
	}

}
