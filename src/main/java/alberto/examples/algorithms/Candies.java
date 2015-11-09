package alberto.examples.algorithms;


/**
 *
 * @author <a href="mailto:nobuji.saito@gmail.com">nobuji.saito</a>
 * @version $Id$
 * @since Jul 24, 2015
 *
 *        There are N children standing in a line. Each child is assigned a rating value. You are giving candies to
 *        these children subjected to the following requirements:
 *
 *        1. Each child must have at least one candy. 2. Children with a higher rating get more candies than their
 *        neighbors.
 *
 *        What is the minimum candies you must give?
 */
public class Candies
{
   /**
    * Represents candy
    *
    * @param ratings
    * @return int
    * @since Jul 24, 2015
    *
    */
   public static int candy (final int[] ratings)
   {
      if ( (ratings == null) || (ratings.length == 0))
      {
         return 0;
      }

      final int[] candies = new int[ratings.length];
      candies[0] = 1;

      // from let to right
      for (int i = 1; i < ratings.length; i++)
      {
         if (ratings[i] > ratings[i - 1])
         {
            candies[i] = candies[i - 1] + 1;
         }
         else
         {
            // if not ascending, assign 1
            candies[i] = 1;
         }
      }

      int result = candies[ratings.length - 1];

      // from right to left
      for (int i = ratings.length - 2; i >= 0; i--)
      {
         int cur = 1;
         if (ratings[i] > ratings[i + 1])
         {
            cur = candies[i + 1] + 1;
         }

         result += Math.max (cur, candies[i]);
         candies[i] = cur;
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
      final int[] ratings = {1, 2, 3, 3, 1};
      System.out.println (candy (ratings));
   }

}
