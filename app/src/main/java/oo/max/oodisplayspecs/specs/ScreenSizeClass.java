package oo.max.oodisplayspecs.specs;


import lombok.Getter;
import oo.max.oodisplayspecs.R;

/**
 * See http://developer.android.com/guide/practices/screens_support.html
 */
public enum ScreenSizeClass {

    SMALL       (426, 320, R.string.small),
    NORMAL      (470, 320, R.string.normal),
    LARGE       (640, 480, R.string.large),
    EXTRA_LARGE (960, 720, R.string.extra_large);

    private final int minWidthDp;
    private final int minHeightDp;

    @Getter
    private final int nameResourceId;

    ScreenSizeClass(int minWidthDp, int minHeightDp, int nameResourceId) {
        this.minWidthDp = minWidthDp;
        this.minHeightDp = minHeightDp;
        this.nameResourceId = nameResourceId;
    }

    public static ScreenSizeClass getScreenSizeClassByDp(int widthDp, int heightDp) {
        throwIfNegativeValues(widthDp, heightDp);
        for (ScreenSizeClass screenSizeClass : getClassesOrderedBySize()) {
            if(screenSizeClass.isSizeOverMinimum(widthDp, heightDp)) {
                return screenSizeClass;
            }
        }
        throw new RuntimeException("Cannot find proper screen size class");
    }

    private static void throwIfNegativeValues(int widthDp, int heightDp) {
        if(widthDp < 0 || heightDp < 0) {
            throw new IllegalArgumentException("dp values must not be negative");
        }
    }

    private static ScreenSizeClass[] getClassesOrderedBySize() {
        return new ScreenSizeClass[] { EXTRA_LARGE, LARGE, NORMAL, SMALL };
    }

    private boolean isSizeOverMinimum(int widthDp, int heightDp) {
        if(isRawSizeEnough(widthDp, heightDp)) {
            return true;
        } else if(isRawSizeEnough(heightDp, widthDp)) {
            return true;
        }
        return false;
    }

    private boolean isRawSizeEnough(int dimensionA, int dimensionB) {
        return minWidthDp <= dimensionA && minHeightDp <= dimensionB;
    }
}