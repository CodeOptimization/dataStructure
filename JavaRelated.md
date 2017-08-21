``` java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class JavaInterview {
    public static void main(String[] args) {

        //chars
        char A = new Character('\u0041');

        // String
        String s = "abc";
        s.charAt(0);
        s.length();
        //0 is inclueded, 1 is excluded;
        s.substring(0, 1);
        //0 is inclueded, till the end
        s.substring(1);
        //reutrn true if two strings' contents are the same;
        s.equals("b");
        //Returns a string whose value is this string, with any leading and trailing whitespace removed.
        s = s.trim();
        //Returns the index within this string of the first occurrence of the specified character.
        s.indexOf("a");
        //Returns the index within this string of the first occurrence of the specified character, starting the
        //search at the specified index(include).
        s.indexOf("a", 1);
        //Returns the index within this string of the last occurrence of the specified character.
        s.lastIndexOf("a");
        //Returns the index within this string of the last occurrence of the specified character, searching
        //backward starting at the specified index((include)).
        s.indexOf("a", 1);
        //Converts this string to a new character array.
        s.toCharArray();
        //Returns an Integer object holding the value of the specified String, an Integer object
        Integer.valueOf(s);
        //Parses the string argument as a signed decimal integer,  an int primitive;
        Integer.parseInt(s);
        //Returns the string representation of the boolean/char/char array/specific subarray of the char array/
        //double/float/int/long/Object argument.
        String.valueOf(4); // integer to string
        int code = "abcaa".codePointAt(0);//i = 97

        // StringBuilder, A mutable sequence of characters.
        StringBuilder sb = new StringBuilder("abc");
        sb.append("a");
        sb.insert(0, "a");// "aabc"
        sb.deleteCharAt(sb.length() - 1);
        //Causes this character sequence to be replaced by the reverse of the sequence, return a StringBuilder 
        //object.
        sb.reverse();
        //The term "surrogate pair" refers to a means of encoding Unicode characters with high code-points in 
        //the UTF-16 encoding scheme.
        StringBuilder surrogatePair = new StringBuilder("急");
        surrogatePair.reverse();// won't change, surrogatePair.length() = 1;
        StringBuilder chars = new StringBuilder("abc");
        chars.reverse();// will change, chars.length() = 3;
        //Returns a string representing the data in this sequence.
        sb.toString();

        // Array
        int[] a = new int[10];
        char[] b1 = {'a', 'b'};
        char[] b2 = new char[]{'a', 'b'};
        int[][] c = new int[10][10];
        int m = a.length;
        int n = c[0].length;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        //Sorts the specified array into ascending numerical order.
        Arrays.sort(a);
        //Returns a fixed-size list backed by the specified array.
        List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);

        //Set
        Set<Integer> set = new HashSet<>();
        //Adds the specified element to this set if it is not already present (optional operation). Returns
        //false  if list size doesn't change.
        set.add(0); //true
        set.add(0); //false
        //Removes the specified element from this set if it is present (optional operation).  Returns false 
        //if list size doesn't change.
        set.remove(0);
        //Returns true if this set contains the specified element. More formally, returns true if and only 
        //if this set contains an element e such that (o==null ? e==null : o.equals(e)).
        if (set.contains(0)) {
        }
        //Returns true if this set contains no elements.
        set.isEmpty();
        //Returns the number of elements in this set (its cardinality).
        set.size();

        // List
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> list1 = new ArrayList<List<Integer>>();
        //boolean add(E e): Appends the specified element to the end of this list (optional operation). Returns 
        //false if list size doesn't chage.
        list.add(0);// list = [0]
        //Inserts the specified element at the specified position in this list (optional operation). Shifts the 
        //element currently at that position (if any) and any subsequent elements to the right (adds one to 
        //their indices).
        list.add(0, 1); //list = [1, 0]
        //Returns the element at the specified position in this list.
        list.get(0);
        //Returns the number of elements in this list.
        list.size();
        //Removes the first occurrence of the specified element from this list, if it is present (optional 
        //operation).
        // If this list does not contain the element, it is unchanged. Returns false if list size doesn't chage.
        list.remove(list.size() - 1);

        //public static <T extends Comparable<? super T>> void sort(List<T> list): Sorts the specified list
        //into ascending order, according to the natural ordering of its elements. All elements in the list
        //must implement the Comparable interface. Furthermore, all elements in the list must be mutually
        //comparable (that is, e1.compareTo(e2) must not throw a ClassCastException for any elements e1 and 
        //e2 in the list).
        Collections.sort(list);
        //1. public static <T> Comparator<T> reverseOrder(): Returns a comparator that imposes the reverse 
        //of the natural ordering on a collection of objects that implement the Comparable interface.
        //2. public static <T> void sort(List<T> list, Comparator<? super T> c): Sorts the specified list 
        //according to the order induced by the specified comparator.
        Collections.sort(list, Collections.reverseOrder());
        //Interface java.util.Comparator<T>: A comparison function, which imposes a total ordering on some 
        //collection of objects. Comparators can be passed to a sort method (such as Collections.sort or 
        //Arrays.sort) to allow precise control over the sort order.Comparators can also be used to control
        //the order of certain data structures (such as sorted sets or sorted maps), or to provide an ordering
        //for collections of objects 
        //that don't have a natural ordering.
        // Comparator is a operator.
        // Comparable can be read as a ability.
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            //Compares its two arguments for order. Returns a negative integer, zero, or a positive integer 
            //as the first argument is less than, equal to, or greater than the second.
            public int compare(Integer o1, Integer o2) {
                return o1 - o2; // 0‐>1
                // return o2‐o1; // 1‐>0
            }
        });

        //Comparator vs Comparable
        //Comparable: This ordering is referred to as the class's natural ordering, and the class's compareTo 
        //method is referred to as its natural comparison method. Lists (and arrays) of objects that implement
        //this interface can be sorted automatically by Collections.sort (and Arrays.sort).
        //Note that null is not an instance of any class, and e.compareTo(null) should throw a 
        //NullPointerException even though e.equals(null) returns false.
        //http://www.importnew.com/19250.html
        class T implements Comparable<T>{
            int val = 0;
            @Override
            public int compareTo(T o) {
                return this.val - o.val;
            }
        }

        // Stack
        //LinkedList: Doubly-linked list implementation of the List and Deque interfaces. Implements all 
        //optional list operations, and permits all elements (including null).
        //LinkedList(), LinkedList(Collection<? extends E> c)
        LinkedList<Integer> stack = new LinkedList<Integer>();
        //Pushes an element onto the stack represented by this list. In other words, inserts the element
        //at the front of this list. This method is equivalent to addFirst(E).
        stack.push(0);
        //Pops an element from the stack represented by this list. In other words, removes and returns 
        //the first element of this list. This method is equivalent to removeFirst().
        stack.pop();
        //Retrieves, but does not remove, the head (first element) of this list., peekFirst, peekLast
        stack.peek();
        //from AbstractCollection
        stack.isEmpty();
        //Returns the number of elements in this list.
        stack.size();

        // Queue add ‐‐‐‐‐‐> remove, peek
        Queue<Integer> q = new LinkedList<Integer>();
        //Appends the specified element to the end of this list. This method is equivalent to addLast(E).
        q.add(0);
        //Retrieves and removes the head (first element) of this list.
        q.remove();
        //same
        q.peek();
        q.isEmpty();
        q.size();

        // HashMap
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.putIfAbsent(1, 99);
        map.put(1, 1);
        map.get("sssssdsd");// null
        if (map.containsKey('c')) { }
        if (map.containsValue(1)) { }
        for (Integer d : map.keySet()) { }
        for (Integer i : map.values()) { }
        map.isEmpty();
        map.size();

        //About iterating
        //Interface Map.Entry<K,V>

        //TreeMap: A Red-Black tree based NavigableMap implementation. The map is sorted according to 
        //the natural order of its keys, or by a Comparator provided at map creation time, depending 
        //on which constructor is used.
        //Iterating 1: from java5 and on
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        //Iterating 2:
        //iterating keys
        for (Integer key : map.keySet())
            System.out.println("Key = " + key);
        //iterating vals
        for (Integer value : map.values())
            System.out.println("Value = " + value);
        //Iterating 3:
        //with generics
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        //without generics
        Iterator entries2 = map.entrySet().iterator();
        while (entries2.hasNext()) {
            Map.Entry entry = (Map.Entry) entries2.next();
            Integer key = (Integer) entry.getKey();
            Integer value = (Integer) entry.getValue();
            System.out.println("Key = " + key + ", Value = " + value);
        }
        //Iterating 4: Low efficiency
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println("Key = " + key + ", Value = " + value);
        }

        // mini heap
        // mini heap
        //An unbounded priority queue based on a priority heap. The elements of the priority queue are
        //ordered according to their natural ordering, or by a Comparator provided at queue construction
        //time, depending on which constructor is used. A priority queue does not permit null elements.
        //This class and its iterator implement all of the optional methods of the Collection and 
        //Iterator interfaces. The Iterator provided in method iterator() is not guaranteed to traverse
        //the elements of the priority queue in any particular ORDER. If you need ordered traversal, consider 
        //using Arrays.sort(pq.toArray()).
        //Note that this implementation is not synchronized. Multiple threads should not access a
        //PriorityQueue instance concurrently if any of the threads modifies the queue. Instead, use the 
        //thread-safe PriorityBlockingQueue class.
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(0);
        pq.remove();
        pq.peek();
        pq.isEmpty();
        pq.size();
        while (!pq.isEmpty()) {
        }
    }
}
```
