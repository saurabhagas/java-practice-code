package code.collections.custom.test;

import code.collections.custom.impl.CustomHashMap;
import org.junit.Test;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomHashMapTest {
  @Test
  public void putWithToString() {
    final Map<String, String> customHashMap = createMap();
    System.out.println(customHashMap);
  }

  @Test
  public void put_test_replace() {
    final Map<String, String> customHashMap = createMap();
    assertThat(customHashMap.put("fname", "Surbhi"), is("Saurabh"));
    assertThat(customHashMap.get("fname"), is("Surbhi"));
    System.out.println(customHashMap);
  }

  @Test
  public void putNullKeys() {
    final Map<String, String> customHashMap = new CustomHashMap<>();
    customHashMap.put("key1", null);
    customHashMap.put(null, "value1");
    System.out.println(customHashMap);
  }

  @Test
  public void get() {
    final Map<String, String> customHashMap = createMap();
    assertThat(customHashMap.get("fname"), is("Saurabh"));
    assertThat(customHashMap.get("lname"), is("Agarwal"));
    assertThat(customHashMap.get("address"), is("Bangalore"));
  }

  @Test
  public void remove() {
    final Map<String, String> customHashMap = createMap();
    assertThat(customHashMap.size(), is(3));

    String removed = customHashMap.remove("fname");
    assertThat(removed, is("Saurabh"));
    assertThat(customHashMap.size(), is(2));

    customHashMap.put("fname", "Saurabh");
    assertThat(customHashMap.size(), is(3));

    removed = customHashMap.remove("blah");
    assertThat(removed, is(nullValue()));
    assertThat(customHashMap.size(), is(3));

    System.out.println(customHashMap);
  }

  @Test
  public void clear() {
    final Map<String, String> customHashMap = createMap();
    assertThat(customHashMap.isEmpty(), is(false));

    customHashMap.clear();
    assertThat(customHashMap.size(), is(0));
    assertThat(customHashMap.isEmpty(), is(true));

    System.out.println(customHashMap);
  }

  @Test
  public void containsKey() {
    final Map<String, String> customHashMap = createMap();
    assertThat(customHashMap.containsKey("fname"), is(true));
    assertThat(customHashMap.containsKey("blah"), is(false));
  }

  @Test
  public void containsValue() {
    final Map<String, String> customHashMap = createMap();
    assertThat(customHashMap.containsValue("Saurabh"), is(true));
    assertThat(customHashMap.containsValue("blah"), is(false));
  }

  @Test
  public void putAll() {
    final Map<Object, Object> customHashMap = new CustomHashMap<>();
    customHashMap.putAll(createMap());
    System.out.println(customHashMap);
  }

  @Test
  public void keySet() {
    final Map<String, String> customHashMap = createMap();
    final Set<String> keySet = customHashMap.keySet();
    assertThat(keySet, hasItems("fname", "address", "lname"));
  }

  @Test
  public void values() {
    final Map<String, String> customHashMap = createMap();
    final Collection<String> values = customHashMap.values();
    assertThat(values, hasItems("Saurabh", "Agarwal", "Bangalore"));
  }

  @Test
  public void entrySet() {
    final Map<String, String> customHashMap = createMap();
    final Set<Map.Entry<String, String>> entrySet = customHashMap.entrySet();
    System.out.println(entrySet);
  }

  @Test
  public void testDiffKeysButSameValues() {
    final Map<String, String> customHashMap = new CustomHashMap<>();
    customHashMap.put("fname", "hello");
    customHashMap.put("lname", "hello");
    customHashMap.put("address", "hello");

    final Collection<String> values = customHashMap.values();
    assertThat(values.size(), is(3));
    System.out.println(customHashMap);
  }

  @Test
  public void collisionsTest() {
    final Map<String, String> customHashMap = new CustomHashMap<>();
    //Following keys have same hashCodes
    customHashMap.put("AaAa", "hello1");
    customHashMap.put("BBBB", "hello2");
    customHashMap.put("AaBB", "hello3");
    customHashMap.put("BBAa", "hello4");

    assertThat(customHashMap.get("AaAa"), is("hello1"));
    assertThat(customHashMap.get("BBBB"), is("hello2"));
    assertThat(customHashMap.get("AaBB"), is("hello3"));
    assertThat(customHashMap.get("BBAa"), is("hello4"));
    System.out.println(customHashMap);
  }

  @Test
  public void collisionsTestwithSameValues() {
    final Map<String, String> customHashMap = new CustomHashMap<>();
    customHashMap.put("AaAa", "hello");
    customHashMap.put("BBBB", "hello");
    customHashMap.put("AaBB", "hello");
    customHashMap.put("BBAa", "hello");

    assertThat(customHashMap.get("AaAa"), is("hello"));
    assertThat(customHashMap.get("BBBB"), is("hello"));
    assertThat(customHashMap.get("AaBB"), is("hello"));
    assertThat(customHashMap.get("BBAa"), is("hello"));

    assertThat(customHashMap.size(), is(4));
    System.out.println(customHashMap);
  }

  private Map<String, String> createMap() {
    final Map<String, String> customHashMap = new CustomHashMap<>();
    customHashMap.put("fname", "Saurabh");
    customHashMap.put("lname", "Agarwal");
    customHashMap.put("address", "Bangalore");
    return customHashMap;
  }
}