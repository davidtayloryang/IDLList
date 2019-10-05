package classes;

import java.util.ArrayList;

/**
 * I pledge my honor I have abided by the Stevens Honor System
 * @author lukemcevoy
 *a double-linked list with fast accessing. Fast
	accessing is provided by an internal index
 * @param <E>
 */
public class IDLList<E> {

	
       class Node<F> {
             private F data;
             private Node<F> next;
             private Node<F> prev;

             Node(F elem){
                    data  = elem;
                    next = null;
                    prev = null;
             }
           
             Node(F elem, Node<F> prev, Node<F> next){
                    data = elem;
                    this.next = next;
                    this.prev = prev;
             }

       }
    
       private Node<E> head;
       private Node<E> tail;
       private int size;
       private ArrayList<Node<E>> indices;
     
       /**
        *  that creates an empty double-linked list
        */
       public IDLList() {
             head = null;
             tail = null;
             size  = 0;
             indices = new ArrayList<Node<E>>();
       }
       
       /**
        * that adds elem at the head (i.e. it becomes the first element
		of the list)
        * @param elem
        * @return
        */
       public boolean add (E elem) {//done
             Node<E> temp = new Node<E>(elem, null, null);
            
             if(size>0) {
                    temp.next = indices.get(0);     
                    }else {
                           tail = temp;
                    }
             head = temp;
             indices.add(0, temp);
             size++;
             return true;
       }
       
       /**
        * that adds elem at position index (counting from
		wherever head is). It uses the index for fast access
        * @param index
        * @param elem
        * @return
        */
       public boolean add (int index, E elem) {
             if(index<0 || index>size) {
                    throw new IllegalArgumentException();
             }
             if(index ==0) {
                    return add(elem);
             }
             if(index == size) {
                    return append(elem);
             }

             Node<E> temp = new Node<E>(elem,indices.get(index-1),indices.get(index));
             indices.get(index-1).next = temp;
             indices.get(index+1).prev = temp;
             size++;
             return true;

       }
       
       /**
        * returns the object at the head
        * @return
        */
       public E getHead() {
             if (size ==0) {
                    throw new NullPointerException();
             }
             return head.data;
       }

       
       /**
        * that adds elem as the new last element of the list
        * @param elem
        * @return
        */
       public boolean append (E elem) {
             if(size ==0) {
                    return add(elem);
             }
             Node<E> answer = new Node<E>(elem,indices.get(size-1),null);
             tail = answer;
             indices.get(size-1).next = answer;
             size++;
             return true;
       }
       
       /**
        * that returns the object at position index from the head. It uses
		the index for fast access. Indexing starts from 0, thus get(0) returns the head element
		of the list.
        * @param index
        * @return
        */
       public E get (int index) {
             if(index < 0 || index > size-1) {
                    throw new IllegalStateException();
             }
            
             Node<E> current = head;
             for(int i = 0; i < index; i++) {
                    current = current.next;
             }
          
             return current.data;
       }
      
     /**
      *  returns the object at the tail
      * @return
      */
       public E getLast() {
             if (size ==0) {
                    throw new NullPointerException();
             }
             return tail.data;
       }

      /**
       * returns the list size
       * @return
       */
       public int size() {
             return size;
       }

      /**
       * removes and returns the element at the head
       * @return
       */
       public E remove() {
             if(size==0) {
                    throw new IllegalStateException();
             }
             if(size==1) {
                    head = null;
                    tail = null;
                    size--;
                    E answer = indices.get(0).data;
                    indices.remove(0);
                    return answer;
             }

             head = indices.get(1);
             size--;
             E answer = indices.get(0).data;
             indices.remove(0);
             head.prev = null;
             return answer;
            
            
       }
       
       /**
        * that removes the first occurrence of elem in the list and
		returns true. Return false if elem was not in the list
        * @param elem
        * @return
        */
       public boolean remove(E elem) {
             if(size ==0) {
                    throw new IllegalStateException();
             }
             for(int i = 0;i<size;i++) {
                    if(indices.get(i).equals(elem)) {
                           removeAt(i);
                           return true;
                    }
             }
             return false;
       }

      /**
       * removes and returns the element at the tail
       * @return
       */
       public E removeLast() {
             if(size==0) {
                    throw new IllegalStateException();
             }
             if(size==1) {
                    head = null;
                    tail = null;
                    size--;
                    E answer = indices.get(0).data;
                    indices.remove(0);
                    return answer;

             }

             tail = indices.get(size-2);
             tail.next = null;
             size--;
             return indices.remove(size).data;
            
       }

      /**
       * that removes and returns the element at the index index.
		Use the index for fast access
       * @param index
       * @return
       */
       public E removeAt(int index) {
             if(index<0 || index >size-1) {
                    throw new IllegalArgumentException();
             }
             if(size==0) {
                    throw new IllegalStateException();
             }
             if(size==1) {
                    return remove();
             }
             if (index == size-1) {
                    return removeLast();
             }

             E answer = indices.get(index).data;
             indices.get(index-1).next = indices.get(index +1);
             indices.get(index+1).prev = indices.get(index-1);
             indices.remove(index);
             size--;
             return answer;
       }
    
       /**
        * That presents a string representation of the list
        */
       public String toString() {
             StringBuilder s = new StringBuilder();
             s.append("[");
             Node<E> current = head;
             while(current!=null) {
                    s.append(current.data + ";");
                    current=current.next;
             }
             s.append("]");
             return s.toString();
       }
}