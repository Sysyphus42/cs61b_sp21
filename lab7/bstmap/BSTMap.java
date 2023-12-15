package bstmap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K> , V> implements Map61B<K, V>{

    private class Node{
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size = 0;
    /** Removes all of the mappings from this map. */
    public void clear(){
        size = 0;
        root = null;
    }

    /* Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key){
        if (key == null){
            throw new UnsupportedOperationException("Key cannot be null");
        }
        return containsKey(root, key) != null;
    }

    private Node containsKey(Node node, K key){
        if (node == null) {
            return null;
        }
        if (key == null){
            throw new UnsupportedOperationException("Key cannot be null");
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0){
            return node;
        } else if (cmp < 0){
            return containsKey(node.left, key);
        } else {
            return containsKey(node.right, key);
        }
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key){
        return get(root, key);
    }
    private V get(Node node, K key){
        if (node == null) {
            return null;
        }
        if (key == null){
            throw new UnsupportedOperationException("Key cannot be null");
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0){
            return node.value;
        } else if (cmp < 0){
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }

    }

    /* Returns the number of key-value mappings in this map. */
    public int size(){
        return size;
    }

    /* Associates the specified value with the specified key in this map. */
    public void put(K key, V value) {
        if (key == null){
            throw new UnsupportedOperationException("Key cannot be null");
        }
        root = put(root, key, value);
        size++;
    }

    private Node put(Node cur, K key, V value){
        if (cur == null){
            return new Node(key, value);
        }
        if (key == null){
            throw new UnsupportedOperationException("Key cannot be null");
        }
        if (key.compareTo(cur.key) == 0){
            cur.value = value;
        } else if (key.compareTo(cur.key) < 0){
            cur.left = put(cur.left, key, value);
        } else {
            cur.right = put(cur.right, key, value);
        }
        return cur;
    }


    public Set<K> keySet() {
        HashSet<K> set = new HashSet<>();
        addAllKeys(root, set);
        return set;
    }

    private void addAllKeys(Node node, HashSet<K> set) {
        if (node == null) {
            return;
        }
        addAllKeys(node.left, set);
        set.add(node.key);
        addAllKeys(node.right, set);
    }


    public V remove(K key) {
        if (containsKey(key)){
            V val = get(key);
            root = remove(root, key);
            size--;
            return val;
        }
        return null;
    }

    private Node remove(Node node, K key){
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            node.left = remove(node.left, key);
        } else if (cmp > 0){
            node.right = remove(node.right, key);
        } else {
            if (node.left == null){
                return node.right;
            }
            if (node.right == null){
                return node.left;
            }
            Node temp = node;
            node = getMinChild(temp.right);
            node.right = remove(temp.right, node.key);
            node.left = temp.left;
        }
        return node;
    }

    private Node getMinChild(Node node){
        if (node.left == null){
            return node;
        }
        return getMinChild(node.left);
    }


    public V remove(K key, V value) {
        if (containsKey(key) && get(key).equals(value)){
            remove(key);
            return value;
        }
        return null;
    }



    public void printInOrder(){
        printInOrder(root);
    }
    private void printInOrder(Node node){
        if (node == null){
            return;
        }
        printInOrder(node.left);
        System.out.println(node.key.toString() + "->" + node.value.toString());
        printInOrder(node.right);
    }

    public Iterator<K> iterator(){
        return null;
    }


}
