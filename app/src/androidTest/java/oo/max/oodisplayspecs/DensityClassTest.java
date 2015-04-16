package oo.max.oodisplayspecs;

import oo.max.oodisplayspecs.specs.DensityClass;

public class DensityClassTest extends AbstractTest {

    private void testDensityClass(int[] testValues, DensityClass expectedResult) {
        for (int testValue : testValues) {
            assertEquals(expectedResult, DensityClass.getDensity(testValue));
        }
    }

    public void testThrowOnNegative() {
        try {
            DensityClass.getDensity(-1);
            fail("Should throw on negative");
        } catch (Exception e) {

        }
    }

    public void testAlwaysGettingValue() {
        for(int i=DensityClass.LDPI.getDensity();i<=1000;i++) {
            assertNotNull(DensityClass.getDensity(i));
        }
    }
}
