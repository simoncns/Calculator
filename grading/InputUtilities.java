package grading;

import java.io.BufferedReader;
import java.io.IOException;

import math.Calculator;
import math.CompositeLabeledDouble;
import math.Filter;
import math.LabeledDouble;
import math.LeafLabeledDouble;
import math.WeightedAverageCalculator;

/**
 * Class for inputting values for History and Cohort.
 * 
 * @author Nick Simoncelli
 * @version H5
 *
 */
public class InputUtilities
{
  /**
   * Method to make a labeled double from a string.
   * 
   * @param line
   *          line being parsed
   * @return Labeled double from string
   */
  private static LabeledDouble parseLine(final String line)
  {
    String[] tokens = line.split("\t", 2);
    if (tokens[1].equals("N/A"))
    {
      return null;
    }
    return new LeafLabeledDouble(tokens[0], LetterGrade.fromCode(tokens[1]).getValue());

  }

  /**
   * Method to read a list of History.
   * 
   * @param resultLabel
   *          Label of returned history
   * @param in
   *          BufferedReader
   * @param filter
   *          Filter
   * @param calculator
   *          Calculator of GPA
   * @return History students grade history
   * @throws IOException
   *           IOE
   */
  public static CompositeLabeledDouble readGradeHistory(final String resultLabel,
      final BufferedReader in, final Filter filter, final Calculator calculator) throws IOException
  {
    String line;
    CompositeLabeledDouble rh = new CompositeLabeledDouble(resultLabel, filter, calculator);
    while ((line = in.readLine()) != null)
    {
      LabeledDouble l = parseLine(line);
      if (l != null)
      {
        rh.add(parseLine(line));
      }

    }
    return rh;
  }

  /**
   * Method to read a list of Cohorts.
   * 
   * @param resultLabel
   *          Label attribute of returned Cohort
   * @param in
   *          BufferedReader
   * @param filter
   *          Filter
   * @param calculator
   *          Calculator of GPA
   * @return Cohort group of students grade history
   * @throws IOException
   *           IOE
   */
  public static CompositeLabeledDouble readCohort(final String resultLabel,
      final BufferedReader[] in, final Filter filter, final Calculator calculator)
      throws IOException
  {
    WeightedAverageCalculator calc = new WeightedAverageCalculator(null);
    CompositeLabeledDouble rc = new CompositeLabeledDouble(resultLabel, null, calc);
    for (BufferedReader buff : in)
    {
      if (buff != null)
      {
        rc.add(readGradeHistory("GPA", buff, filter, calculator));
      }
    }
    return rc;
  }
}
