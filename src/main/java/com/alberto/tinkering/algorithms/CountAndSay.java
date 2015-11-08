package com.alberto.tinkering.algorithms;


/**
 * CountAndSay represents ...
 *
 * @author <a href="mailto:nobuji.saito@gmail.com">nobuji.saito</a>
 * @version $Id$
 * @since Jul 24, 2015
 *
 */
public class CountAndSay
{
   /**
    * Represents countAndSay
    *
    * @param n
    * @return String
    * @since Jul 24, 2015
    *
    */
   public static String countAndSay (final int n)
   {
      if (n <= 0)
      {
         return null;
      }

      String result = "1";
      int i = 1;

      while (i < n)
      {
         final StringBuilder sb = new StringBuilder ();
         int count = 1;
         for (int j = 1; j < result.length (); j++)
         {
            if (result.charAt (j) == result.charAt (j - 1))
            {
               count++;
            }
            else
            {
               sb.append (count);
               sb.append (result.charAt (j - 1));
               count = 1;
            }
         }

         sb.append (count);
         sb.append (result.charAt (result.length () - 1));
         result = sb.toString ();
         i++;
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
      for (int i = 1; i <= 20; i++)
      {
         System.out.print (countAndSay (i));

         if (i != 9)
         {
            System.out.print (", ");
         }
      }
   }
}
