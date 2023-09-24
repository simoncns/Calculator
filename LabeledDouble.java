package math;

/**
 * Interface LabeledDouble provides a contract for all implementing
 *  classes.
 *  
 * @author Nick Simoncelli
 * @version H5
 *
 */
public interface LabeledDouble extends Comparable<LabeledDouble>
{
  /**
   * compareTo method for LabeledDouble.
   * 
   * @param other Labeled Double to compare
   * @return int based on comparison
   */
  public int compareTo(final LabeledDouble other);
  
  /**
   * toString (Terse or Verbose).
   * 
   * @param verbose
   * @return String representation
   */
  public String toString(final boolean verbose);
  
  /**
   * Terse representation.
   * 
   * @return String representation
   */
  public String toString();
  
  /**
   * Getter for label.
   * 
   * @return String label
   */
  public String getLabel();
  
  /**
   * Getter for value.
   * 
   * @return Double value
   */
  public Double getValue();
  
}
