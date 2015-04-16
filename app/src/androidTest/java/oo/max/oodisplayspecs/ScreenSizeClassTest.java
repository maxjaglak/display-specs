package oo.max.oodisplayspecs;


import oo.max.oodisplayspecs.specs.ScreenSizeClass;

public class ScreenSizeClassTest extends AbstractTest {

    private int[][] smallSizes = {
            { 320, 435 },
            { 469, 321 }
    };

    private int[][] normalSizes = {
            { 470, 320 },
            { 500, 400 },
            { 480, 321 },
            { 490, 342 },
            { 320, 500 },
            { 640, 479 }
    };

    private int[][] largeSizes = {
            { 640, 480 },
            { 700, 800 },
            { 655, 812 },
            { 480, 640 },
            { 1232, 500 },
            { 640, 500 }
    };

    private int[][] extraLargeSizes = {
            { 960, 720 },
            { 800, 1000 }
    };


    public void testSmallScreenValue() {
        testSizeClazz(smallSizes, ScreenSizeClass.SMALL);
    }

    public void testNormalScreenValue() {
        testSizeClazz(normalSizes, ScreenSizeClass.NORMAL);
    }

    public void testLargeScreenValue() {
        testSizeClazz(largeSizes, ScreenSizeClass.LARGE);
    }

    public void testExtraLargeSizes() {
        testSizeClazz(extraLargeSizes, ScreenSizeClass.EXTRA_LARGE);
    }

    private void testSizeClazz(int[][] smallSizes, ScreenSizeClass sizeClass) {
        for (int[] smallSize : smallSizes) {
            ScreenSizeClass screenSizeClassByDp = ScreenSizeClass.getScreenSizeClassByDp(smallSize[0], smallSize[1]);
            assertEquals(sizeClass, screenSizeClassByDp);
        }
    }

    public void testExceptionOnNegativeValues() {
        try {
            ScreenSizeClass.getScreenSizeClassByDp(-1, -1);
            fail("Exception should be thrown");
        } catch (IllegalArgumentException e) {
            //expected
        }
    }

    public void testAlwaysGettingValueOnCorrectSize() {
        for( int x = 426; x <= 1000; x++ ) {
            for(int y = 320; y <= 1000; y++) {
                ScreenSizeClass screenSizeClassByDp = ScreenSizeClass.getScreenSizeClassByDp(x, y);
                assertNotNull(screenSizeClassByDp);
            }
        }
    }

}