package structures;

public class LinearCollisionHandler <K> implements CollisionHandler <K>{
    private int probeLength;

    /**
  * Constructors to set probeLength to 1, or a different length.
  */
    public LinearCollisionHandler(){
        this.probeLength = 1;
    }

    public LinearCollisionHandler(int probeLength){
        this.probeLength = probeLength;
    }

/**
  * Method starts at index and searches linearly until an open spot
  * is found in the array. This could include index itself.
  * index = (index + probeLength) % size
  */
   public int doProbe(int index, boolean[] activeArray, int M) {
      //TODO: Implement this method.
      return -1;
   }

  /**
* Start at index and search the array linearly until the target
* is found. Then return the array index of the target. 
* Return -1 if not found.
*/
   public int doSearch(int startIndex, K target, K[] keyArray, boolean [] activeArray, int M){
      //TODO: Implement this method.

    return -1;
   }
}
