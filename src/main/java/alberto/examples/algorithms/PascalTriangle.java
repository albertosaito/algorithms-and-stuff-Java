package alberto.examples.algorithms;


import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author <a href="mailto:nobuji.saito@gmail.com">nobuji.saito</a>
 * @version $Id$
 * @since Jul 24, 2015
 *
 */
public class PascalTriangle
{

   /**
    * Represents getRow
    *
    * @param rowIndex
    * @return List<Integer>
    * @since Jul 24, 2015
    *
    */
   public static List <Integer> getRow (final int rowIndex)
   {
      final ArrayList <Integer> result = new ArrayList <Integer> ();

      if (rowIndex < 0)
      {
         return result;
      }

      result.add (1);
      for (int i = 1; i <= rowIndex; i++)
      {
         for (int j = result.size () - 2; j >= 0; j--)
         {
            result.set (j + 1, result.get (j) + result.get (j + 1));
         }
         result.add (1);
      }
      return result;
   }


   /**
    * Represents main
    *
    * @param args
    * @since Jul 24, 2015
    *
    */
   public static void main (final String args[])
   {

      System.out.println (getRow (8));

   }

}
