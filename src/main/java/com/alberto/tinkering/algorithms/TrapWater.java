package com.alberto.tinkering.algorithms;


/**
 *
 * @author <a href="mailto:nobuji.saito@gmail.com">nobuji.saito</a>
 * @version $Id$
 * @since Jul 24, 2015
 *
 *        Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
 *        water it is able to trap after raining.
 *
 *        For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrapWater
{

   /**
    * Represents trap
    *
    * @param height
    * @return int
    * @since Jul 24, 2015
    *
    */
   public static int trap (final int[] height)
   {
      int result = 0;

      if ( (height == null) || (height.length <= 2))
      {
         return result;
      }

      final int left[] = new int[height.length];
      final int right[] = new int[height.length];

      // scan from left to right
      int max = height[0];
      left[0] = height[0];
      for (int i = 1; i < height.length; i++)
      {
         if (height[i] < max)
         {
            left[i] = max;
         }
         else
         {
            left[i] = height[i];
            max = height[i];
         }
      }

      // scan from right to left
      max = height[height.length - 1];
      right[height.length - 1] = height[height.length - 1];
      for (int i = height.length - 2; i >= 0; i--)
      {
         if (height[i] < max)
         {
            right[i] = max;
         }
         else
         {
            right[i] = height[i];
            max = height[i];
         }
      }

      // calculate total
      for (int i = 0; i < height.length; i++)
      {
         result += Math.min (left[i], right[i]) - height[i];
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
      // final int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
      final int[] heights = {0, 1, 2, 0, 1, 3, 1};
      System.out.printf ("Water trapped: %d\n", trap (heights));
   }

}
