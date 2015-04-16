package oo.max.oodisplayspecs.specs;


public interface SpecsRetriever {

    public static int BASE_DENSITY = 160;

    public int getDensityDpi();

    public float getDensityScale();

    public DensityClass getDensityClass();

    public int getScreenWidthPixels();

    public int getScreenHeightPixels();

    public int getScreenWidthDp();

    public int getScreenHeightDp();

    public ScreenSizeClass getScreenSizeClass();

}
