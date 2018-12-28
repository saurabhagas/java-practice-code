package code.collections.custom.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Possible enhancements:
 * 1. Rehashing capability
 * 2. Capability to turn linked list into a tree
 *
 * @param <K>
 * @param <V>
 */
public class CustomHashMap<K, V> implements Map<K, V> {
  private static final int DEFAULT_TABLE_SIZE = 16;
  private final List<LinkedList<Node<K, V>>> buckets;
  private int numKeyValueMappings;

  public CustomHashMap() {
    this(DEFAULT_TABLE_SIZE);
  }

  public CustomHashMap(int tableSize) {
    this.buckets = new ArrayList<>(tableSize);
    for (int i = 0; i < tableSize; i++) {
      buckets.add(new LinkedList<>());
    }
  }

  @Override
  public V put(K key, V value) {
    LinkedList<Node<K, V>> nodes = buckets.get(getBucketIndex(key));
    V oldValue;
    for (Node<K, V> kvNode : nodes) {
      final K mapKey = kvNode.key;
      if (mapKey == null || mapKey.equals(key)) {
        oldValue = kvNode.value;
        kvNode.value = value;
        return oldValue; //return the old value regardless of the value of replace
      }
    }

    Node<K, V> node = new Node<>(key, value);
    nodes.add(node);
    numKeyValueMappings++;
    return null; //return null because nothing was previously present at this key
  }

  @Override
  public V get(Object key) {
    int bucketIndex = getBucketIndex(key);
    LinkedList<Node<K, V>> nodes = buckets.get(bucketIndex);
    for (Node<K, V> node : nodes) {
      if (node.key.equals(key)) {
        return node.value;
      }
    }
    return null; // key not found
  }

  @Override
  public V remove(Object key) {
    int bucketIndex = getBucketIndex(key);
    LinkedList<Node<K, V>> nodes = buckets.get(bucketIndex);
    Node<K, V> nodeToDelete = null;
    for (Node<K, V> node : nodes) {
      if (node.key.equals(key)) {
        nodeToDelete = node;
      }
    }

    if (nodeToDelete == null) {
      return null;
    } else {
      nodes.remove(nodeToDelete);
      numKeyValueMappings--;
      return nodeToDelete.value;
    }
  }

  @Override
  public void clear() {
    buckets.forEach(LinkedList::clear);
    numKeyValueMappings = 0;
  }

  @Override
  public int size() {
    return numKeyValueMappings;
  }

  @Override
  public boolean isEmpty() {
    return buckets.stream().allMatch(LinkedList::isEmpty);
  }

  @Override
  public boolean containsKey(Object key) {
    return keySet().contains(key);
  }

  @Override
  public boolean containsValue(Object value) {
    return values().contains(value);
  }

  @Override
  public void putAll(Map<? extends K, ? extends V> m) {
    m.forEach(this::put);
  }

  @Override
  public Set<K> keySet() {
    return buckets.stream().flatMap(Collection::stream).map(node -> node.key).collect(Collectors.toSet());
  }

  @Override
  public Collection<V> values() {
    return buckets.stream().flatMap(Collection::stream).map(node -> node.value).collect(Collectors.toList());
  }

  @Override
  public Set<Entry<K, V>> entrySet() {
    return buckets.stream().flatMap(Collection::stream).collect(Collectors.toSet());
  }

  @Override
  public String toString() {
    return entrySet().stream().map(Object::toString).collect(Collectors.joining(", ", "[", "]"));
  }

  private int getBucketIndex(Object key) {
    int hash = Objects.hash(key);
    return Math.abs(hash % buckets.size());
  }

  private static class Node<K, V> implements Map.Entry<K, V> {
    private final K key;
    private V value;

    private Node(K key, V value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public K getKey() {
      return key;
    }

    @Override
    public V getValue() {
      return value;
    }

    @Override
    public V setValue(V value) {
      V oldValue = this.value;
      this.value = value;
      return oldValue;
    }

    @Override
    public String toString() {
      return key + " = " + value;
    }
  }
}
