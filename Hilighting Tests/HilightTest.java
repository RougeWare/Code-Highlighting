/* 
 * A file that is useful only to test Java syntax hilighting
 * Made by Blue Husky Studios.
 */

import java.util.Date;
import static java.lang.System.out;

/**
 * A class that does nothing useful, for testing a syntax hilighter
 *
 * @param <T> A type of number
 */
public class HilightTest<T extends Number> extends Object implements Cloneable {

    /** The full name of this class: {@value} */
    public static final String FULL_NAME = "Syntax Hilighter Test";
    private static final String FANCY_STR = "\u0000 and \uFFFF";
    private static long concurrentInstances = 0;

    public int pub;
    int pack;
    private int priv;
    protected int prot;
    private T innerNumber;

    public HilightTest(T initialValue) {
        concurrentInstances++;
        innerNumber = initialValue;
    }

    /**
     * Does nonsense
     * @deprecated to test deprecation
     * @param x Used for comparisons
     * @return an {@link InnerClass}.
     */
    @Deprecated
    private InnerClass methodA(int x, T y) {
        
        x = InnerClass.MyEnum.VALUE_A.ordinal();
        
        if (x > innerNumber.longValue()) {
            for (int i = 0; i < 12; i++) {
                System.out.println(i);
            }
        } else if (x == 7) {
            double array[] = {0.0, 1.0, 1.0001, -123.45, 12.3e45};
            for (double val : array) {
                System.out.println(val);
            }
        } else {
            out.println("Else");
            innerNumber = y;
        }

        return () -> {
            out.println("I am implemented!");
        };
    }

    @Override  @SuppressWarnings("CloneDoesntCallSuperClone")
    public HilightTest<T> clone() throws CloneNotSupportedException {
        return new HilightTest(innerNumber);
    }

    public static interface InnerClass {
        public static enum MyEnum { VALUE_A, VALUE_B, VALUE_C }
        public void implementMe();
    }
}

"Bad code that causes a compile error."