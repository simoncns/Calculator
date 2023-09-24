package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for AbstractLabeledDouble subclass, CompositeLabeledDouble.
 * 
 * @author Nick Simoncelli
 * @version H5
 *
 */
public class CompositeLabeledDouble extends AbstractLabeledDouble
{
  private List<LabeledDouble> data;
  private Filter filter;
  private Calculator calculator;

  /**
   * CompositeLabeledDouble constructor.
   * 
   * @param label
   *          label
   * @param filter
   *          filter
   * @param calculator
   *          calculator
   */
  public CompositeLabeledDouble(final String label, final Filter filter,
      final Calculator calculator)
  {
    super(label);
    this.filter = filter;
    this.calculator = calculator;
    this.data = new ArrayList<LabeledDouble>();
  }

  /**
   * Method to add LabeledDouble.
   * 
   * @param labeledDouble
   *          LabeledDouble to add
   */
  public void add(final LabeledDouble labeledDouble)
  {
    data.add(labeledDouble);
  }

  /**
   * Method to filter data.
   * 
   * @return List<LabeledDouble> filtered list
   */
  public List<LabeledDouble> filter()
  {
    if (filter == null)
    {
      return new ArrayList<LabeledDouble>(data);
    }
    return filter.apply(data);
  }

  /**
   * Method to get value.
   * 
   * @return Double
   */
  public Double getValue()
  {
    if (calculator == null)
    {
      return null;
    }
    if (filter == null)
    {
      return calculator.calculate(this.label, data).getValue();
    }
    return calculator.calculate(this.label, filter()).getValue();
  }
}
