package math;

/**
 * Class AbstractLabeledDouble provides an abstract representation and
 *  functionality of LabeledDouble objects LeafLabeledDouble and 
 *  CompositeLabeledDouble.
 *  
 * @author Nick Simoncelli
 * @version H5
 *
 */
public abstract class AbstractLabeledDouble implements LabeledDouble
{
  private static final String NA = "N/A";
  protected String label;

  protected AbstractLabeledDouble(final String label) throws IllegalArgumentException
  {
    if ((label == null) || label.equals("")) throw new IllegalArgumentException();
    
    this.label = label;
  }
  @Override
  public int compareTo(final LabeledDouble o)
  {
    int result;
    if ((this.getValue() == null) && (o.getValue() == null)) result = 0; // Spec 4.1
    else if (this.getValue() == null) result = -1; // Spec 4.2
    else if (o.getValue() == null) result = 1; // Spec 4.3
    else result = Numerics.signum(this.getValue().compareTo(o.getValue())); // Spec 4

    return result;
  }

  @Override
  public String getLabel()
  {
    return label;
  }

  @Override
  public String toString(final boolean verbose)
  {
    String result;

    if (verbose)
    {
      if ((getValue() == null) || getValue().isNaN()) 
        result = String.format("%s: %s", label, NA); // Spec 5.1.1
      else
        result = String.format("%s: %f", label, getValue()); // Spec 5.1.2
    }
    else
    {
      if ((getValue() == null) || getValue().isNaN()) 
        result = String.format("%s", NA); // Spec 5.2.1
      else                                  
        result = String.format("%f", getValue()); // Spec 5.2.2
    }

    return result;
  }
  
  /**
   * Terse representation of toString.
   * 
   * @return String
   */
  public String toString()
  {
    return toString(false);
  }

  

}
