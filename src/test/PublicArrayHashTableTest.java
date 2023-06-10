package test;

import structures.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PublicArrayHashTableTest {
  @Test
  public void testConstructor1A() throws Exception {
    CollisionHandler<Integer> linCollisionHdler = new LinearCollisionHandler<Integer>();
    ArrayHashTable<Integer, String> q = new ArrayHashTable<Integer, String>(linCollisionHdler);
    assertEquals(0, q.size());
    assertTrue((q.DEFAULT_CAPACITY - q.getCapacity()) < .001);
    assertTrue((q.DEFAULT_LOAD_FACTOR - q.getLoadFactor()) < .001);
    Object[] karr = q.getKeyArray();
    assertTrue(karr.length == q.DEFAULT_CAPACITY);
    Object[] varr = q.getValueArray();
    assertTrue(varr.length == q.DEFAULT_CAPACITY);
    boolean[] aa = q.getIsActiveArray();
    assertTrue(aa.length == q.DEFAULT_CAPACITY);
    assertTrue(q.getCollisionHandler() == linCollisionHdler);
  }

  @Test
  public void testConstructor1B() throws Exception {
    CollisionHandler<Integer> quadCollisionHdler = new QuadraticCollisionHandler<Integer>();
    ArrayHashTable<Integer, String> q = new ArrayHashTable<Integer, String>(quadCollisionHdler);
    assertEquals(0, q.size());
    assertTrue((q.DEFAULT_CAPACITY - q.getCapacity()) < .001);
    assertTrue((q.DEFAULT_LOAD_FACTOR - q.getLoadFactor()) < .001);
    Object[] karr = q.getKeyArray();
    assertTrue(karr.length == q.DEFAULT_CAPACITY);
    Object[] varr = q.getValueArray();
    assertTrue(varr.length == q.DEFAULT_CAPACITY);
    boolean[] aa = q.getIsActiveArray();
    assertTrue(aa.length == q.DEFAULT_CAPACITY);
    assertTrue(q.getCollisionHandler() == quadCollisionHdler);
  }

  @Test
  public void testConstructor2A() throws Exception {
    CollisionHandler<Integer> linCollisionHdler = new LinearCollisionHandler<Integer>();
    ArrayHashTable<Integer, String> q = new ArrayHashTable<Integer, String>(100, linCollisionHdler);
    assertEquals(0, q.size());
    assertEquals(100, q.getCapacity());
    assertTrue((q.DEFAULT_LOAD_FACTOR - q.getLoadFactor()) < .001);
    Object[] karr = q.getKeyArray();
    assertTrue(karr.length == 100);
    Object[] varr = q.getValueArray();
    assertTrue(varr.length == 100);
    boolean[] aa = q.getIsActiveArray();
    assertTrue(aa.length == 100);
    assertTrue(q.getCollisionHandler() == linCollisionHdler);
  }

  @Test
  public void testConstructor2B() throws Exception {
    CollisionHandler<Integer> quadCollisionHdler = new QuadraticCollisionHandler<Integer>();
    ArrayHashTable<Integer, String> q = new ArrayHashTable<Integer, String>(100, quadCollisionHdler);
    assertEquals(0, q.size());
    assertEquals(100, q.getCapacity());
    assertTrue((q.DEFAULT_LOAD_FACTOR - q.getLoadFactor()) < .001);
    Object[] karr = q.getKeyArray();
    assertTrue(karr.length == 100);
    Object[] varr = q.getValueArray();
    assertTrue(varr.length == 100);
    boolean[] aa = q.getIsActiveArray();
    assertTrue(aa.length == 100);
    assertTrue(q.getCollisionHandler() == quadCollisionHdler);
  }

  @Test
  public void testConstructor3A() throws Exception {
    CollisionHandler<Integer> linCollisionHdler = new LinearCollisionHandler<Integer>();
    ArrayHashTable<Integer, String> q = new ArrayHashTable<Integer, String>(100, 0.9, linCollisionHdler);
    assertEquals(0, q.size());
    assertEquals(100, q.getCapacity());
    assertTrue((0.9 - q.getLoadFactor()) < .001);
    Object[] karr = q.getKeyArray();
    assertTrue(karr.length == 100);
    Object[] varr = q.getValueArray();
    assertTrue(varr.length == 100);
    boolean[] aa = q.getIsActiveArray();
    assertTrue(aa.length == 100);
    assertTrue(q.getCollisionHandler() == linCollisionHdler);
  }

  @Test
  public void testConstructor3B() throws Exception {
    CollisionHandler<Integer> quadCollisionHdler = new QuadraticCollisionHandler<Integer>();
    ArrayHashTable<Integer, String> q = new ArrayHashTable<Integer, String>(100, 0.9, quadCollisionHdler);
    assertEquals(0, q.size());
    assertEquals(100, q.getCapacity());
    assertTrue((0.9 - q.getLoadFactor()) < .001);
    Object[] karr = q.getKeyArray();
    assertTrue(karr.length == 100);
    Object[] varr = q.getValueArray();
    assertTrue(varr.length == 100);
    boolean[] aa = q.getIsActiveArray();
    assertTrue(aa.length == 100);
    assertTrue(q.getCollisionHandler() == quadCollisionHdler);
  }

  @Test
  public void testPutAndGet() throws Exception {
    CollisionHandler<Integer> linCollisionHdler = new LinearCollisionHandler<Integer>();
    ArrayHashTable<Integer, String> q = new ArrayHashTable<Integer, String>(linCollisionHdler);
    assertEquals(0, q.size());
    q.put(1, "apple");
    q.put(10, "pencil");
    assertTrue(q.get(1).equals("apple"));
    assertTrue(q.get(10).equals("pencil"));
    q.put(3, "pineapple");
    assertEquals(3, q.size());
    assertTrue(q.get(3).equals("pineapple"));
  }

  @Test
  public void testresizeArray() throws Exception {
    CollisionHandler<Integer> linCollisionHdler = new LinearCollisionHandler<Integer>();
    ArrayHashTable<Integer, String> q = new ArrayHashTable<Integer, String>(3, linCollisionHdler);
    assertEquals(0, q.size());
    assertEquals(3, q.getCapacity());
    q.put(1, "apple");
    q.put(2, "pen");
    q.put(3, "pineapple");
    assertEquals(3, q.size());
    assertEquals(3, q.getCapacity());
    q.put(10, "pencil");
    assertEquals(4, q.size());
    assertEquals(6, q.getCapacity());
  }

  @Test
  public void testLinearProb() throws Exception {
    CollisionHandler<Integer> linCollisionHdler = new LinearCollisionHandler<Integer>();
    ArrayHashTable<Integer, String> q = new ArrayHashTable<Integer, String>(200, linCollisionHdler);
    q.put(111, "Apple");
    q.put(311, "Pen");
    Object[] keyTable = q.getKeyArray();
    Object[] valueTable = q.getValueArray();
    Integer k = (Integer) keyTable[111];
    String v = (String) valueTable[112];
    assertTrue(k.equals(111));
    assertTrue(v.equals("Pen"));
    q.put(1114, "Dog");
    q.put(914, "Cat");
    q.put(713, "Bird");
    q.put(313, "Grape");
    keyTable = q.getKeyArray();
    valueTable = q.getValueArray();
    k = (Integer) keyTable[115];
    v = (String) valueTable[116];
    assertTrue(k.equals(914));
    assertTrue(v.equals("Grape"));
  }

  @Test
  public void testQuadProbHandler1() throws Exception {
    QuadraticCollisionHandler<Integer> hndler = new QuadraticCollisionHandler<Integer>(1, 1);
    boolean[] arr = new boolean[27];
    arr[5] = true;
    arr[7] = true;
    arr[13] = true;
    arr[25] = true;
    int resIndex = hndler.doProbe(5, arr, 27);
    assertTrue(resIndex == 18);
  }

  @Test // (timeout = 1000)
  public void testQuadProbHandler2() throws Exception {
    QuadraticCollisionHandler<Integer> hndler = new QuadraticCollisionHandler<Integer>(1, 1);
    boolean[] arr = new boolean[207];
    arr[25] = true;
    arr[27] = true;
    arr[33] = true;
    arr[45] = true;
    arr[65] = true;
    arr[95] = true;
    arr[137] = true;
    arr[193] = true;
    int resIndex = hndler.doProbe(25, arr, 207);
    assertTrue(resIndex == 58);
  }

}
