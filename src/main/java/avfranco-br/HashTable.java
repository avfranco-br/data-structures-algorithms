import java.util.ArrayList;
import java.util.List;

public class HashTable {
  // Create a new HashMap function, set and get data
  // Bucket data structure
  private class BucketDataStructure {
    String product;
    int quantity;

    public BucketDataStructure(String product, int quantity) {
      this.product = product;
      this.quantity = quantity;
    }
  }

  private class BucketStructure {
    ArrayList <BucketDataStructure> shelfitem;
    //BucketDataStructure shelfitem;

    public BucketStructure() {
      shelfitem = new ArrayList<BucketDataStructure>();
    }

    public BucketStructure(int sizeArrayList) {
      shelfitem = new ArrayList<BucketDataStructure>(sizeArrayList);
    } 
  }

  private BucketStructure bucket[];

  // Constructor to set the size of our Grocery Bucket
  public HashTable (int bucketShelves) {
    bucket = new BucketStructure[bucketShelves];
  }

  private int _hashKey (String product) {
    int hash = 0;
    for (int i=0; i < product.length(); i++) {
      hash = (hash + product.codePointAt(i)*(i==0?1:i)) % bucket.length;
    }
    return hash;
  } 

  public boolean set(String product, int quantity) {
    int keyShelf = _hashKey(product);
    //BucketDataStructure item = new BucketDataStructure();
    //item.product = product;
    //item.quantity = quantity;

    if (bucket[keyShelf] == null) {
      bucket[keyShelf] =  new BucketStructure(1);
      //bucket[keyShelf] = new BucketStructure();
      //bucket[keyShelf].shelfitem = item;
    }
    bucket[keyShelf].shelfitem.add(new BucketDataStructure(product,quantity));
    
    return true;
  }

  public void set(int[] ArrayOfNumbers) {
    int index=0;
    for (int item : ArrayOfNumbers) {
      int keyShelf = _hashKey((Integer.toString(item)));
    
      if (bucket[keyShelf] == null) {
        bucket[keyShelf] =  new BucketStructure(1);
      } 
      bucket[keyShelf].shelfitem.add(new BucketDataStructure(Integer.toString(item), index));
      index++;
    }
  }

  public int get(String key) {
    int hashKey = _hashKey(key);

    for (BucketDataStructure itemAtShelf : bucket[hashKey].shelfitem) {
      if (itemAtShelf.product == key) {
        return itemAtShelf.quantity;
      }
    }
    return 0;
  }

  public int[] getRecurringCharacters(String key) {
    int hashKey = _hashKey(key);
    int [] pairsOfRecurring = new int[2];
    
    if (bucket[hashKey].shelfitem.size() > 1) {

      pairsOfRecurring[0] = Integer.parseInt(bucket[hashKey].shelfitem.get(1).product);
      pairsOfRecurring[1] = bucket[hashKey].shelfitem.get(1).quantity;
      return pairsOfRecurring;
    }

    return null;
  }

  public void keys() {
    for (int i=0; i < bucket.length; i++) {
      if (bucket[i] != null) {
        for (BucketDataStructure itemAtShelf : bucket[i].shelfitem) {
          System.out.println(itemAtShelf.product + "," + itemAtShelf.quantity);
        }
      }
    }
  }
}
