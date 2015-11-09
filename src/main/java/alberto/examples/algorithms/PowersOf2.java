package alberto.examples.algorithms;


/**
 *
 * @author <a href="mailto:nobuji.saito@gmail.com">nobuji.saito</a>
 * @version $Id$
 * @since Jul 24, 2015
 *
 *        Find if int value is power of 2 or not
 *
 */
public class PowersOf2
{
   /**
    * Represents main
    *
    * @param args
    * @since Jul 24, 2015
    *
    */
   public static void main (final String[] args)
   {
      final int value = Integer.parseInt (args[0]);
      System.out.printf ("%s is Power of 2?, %s", args[0], (value & (value - 1)) == 0);
   }

}
