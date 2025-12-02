package org.learnings.interviewExperience;

import java.util.HashMap;
import java.util.Map;

class LRUCache<K,V>{
    private int capacity;
    private final Map<K,V> cache = new HashMap<>();
    private final DoubleLinkedList<K> doubleLinkedList = new DoubleLinkedList<>();
    LRUCache(int capacity){
        this.capacity = capacity;
    }
    public V get(K key) throws Exception{
        // get the value and mark it as most recently used
        if(cache.isEmpty()){
            throw new RuntimeException("No Entry in Cache");
        }
        doubleLinkedList.updateOrder(key);
        return cache.get(key);
    }
    public void put(K key, V value){
        this.cache.put(key,value);
        // add or update the value and mark as most recently used
        if(this.capacity > this.cache.size()){
            this.doubleLinkedList.addFirst(key);
        } else {
            //delete the least used item from linked list
            K keyToRemove = this.doubleLinkedList.removeLast();
            this.cache.remove(keyToRemove);
        }
    }
    public void printCacheItems(){
        int count = this.cache.size();
        while(count-- >0){
            K key = this.doubleLinkedList.peek();
            System.out.println(key + " : " + this.cache.get(key));
        }
    }
}
class Node<K>{
    public K value;
    public Node<K> prev = null;
    public Node<K> next = null;
    public Node(K value){
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
class DoubleLinkedList<K>{
    private Node<K> head,tail = null;
    public void addFirst(K item){
        if(head == null){
            head = new Node<>(item);
            tail = head;
        } else {
            Node<K> newNode = new Node<>(item);
            newNode.next = head;
            head.prev = newNode;
            newNode.prev = tail;
            head = newNode;
        }
    }
    public void updateOrder(K key){
        // make the head point the latest key
        Node<K> cur = head;
        while(cur.value!=key){
            cur = cur.next;
        }
        Node<K> temp = cur;
        temp.next.prev = cur.prev;
        temp.prev.next = cur.next;
        head.prev = cur;
        cur.prev = tail;
        cur.next = head;
    }
    public K removeLast(){
        Node<K> cur = head;
        while(cur.next!=tail){
            cur = cur.next;
        }
        Node<K> lastItem = tail;
        cur.next = head;
        tail = cur;
        return lastItem.value;
    }
    public K peek(){
        return this.head.value;
    }
}

class Solution {

    public static void main(String[] args) {
        LRUCache<String,Integer> lruCache = new LRUCache<>(5);
        lruCache.put("a",1);
        lruCache.put("b",2);
        lruCache.put("c",3);
        lruCache.put("d",4);
        lruCache.printCacheItems(); // print in most recent acceded order wise
    }
}
