package math;

/**
 * Immutable leaf component of AbstractLabeledDouble.
 * 
 * @author Nick Simoncelli
 * @version H5
 *
 */
public final class LeafLabeledDouble extends AbstractLabeledDouble
{

  private Double value;

  /**
   * LeafLabeledDouble constructor.
   * 
   * @param label
   *          String label
   */
  public LeafLabeledDouble(final String label)
  {
    super(label);
    this.value = 0.0;
  }

  /**
   * LeafLabeledDouble constructor.
   * 
   * @param label
   *          String label
   * @param value
   *          double value
   */
  public LeafLabeledDouble(final String label, final double value)
  {
    super(label);
    this.value = value;
  }

  /**
   * LeafLabeledDouble constructor.
   * 
   * @param label
   *          String label
   * @param value
   *          double value
   */
  public LeafLabeledDouble(final String label, final Double value)
  {
    super(label);
    this.value = value;
  }

  /**
   * getValue method.
   * 
   * @return Double
   */
  public Double getValue()
  {
    return value;
  }
}
