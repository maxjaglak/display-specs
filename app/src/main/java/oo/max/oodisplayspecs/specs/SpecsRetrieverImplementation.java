package oo.max.oodisplayspecs.specs;


import android.content.Context;
import android.util.DisplayMetrics;

public class SpecsRetrieverImplementation implements SpecsRetriever {

    private final Context context;
    private DisplayMetrics metrics;

    public SpecsRetrieverImplementation(Context context) {
        this.context = context;
        init();
    }

    public void init() {
        metrics = context.getResources().getDisplayMetrics();
    }

    @Override
    public int getDensityDpi() {
        return metrics.densityDpi;
    }

    @Override
    public float getDensityScale() {
        return metrics.density;
    }

    @Override
    public DensityClass getDensityClass() {
        return DensityClass.getDensity(getDensityDpi());
    }

    @Override
    public int getScreenWidthPixels() {
        return metrics.widthPixels;
    }

    @Override
    public int getScreenHeightPixels() {
        return metrics.heightPixels;
    }

    @Override
    public int getScreenWidthDp() {
        return getScreenWidthPixels() * BASE_DENSITY / metrics.densityDpi;
    }

    @Override
    public int getScreenHeightDp() {
        return getScreenHeightPixels() * BASE_DENSITY / metrics.densityDpi;
    }

    @Override
    public ScreenSizeClass getScreenSizeClass() {
        return ScreenSizeClass.getScreenSizeClassByDp(getScreenWidthDp(), getScreenHeightDp());
    }

}
