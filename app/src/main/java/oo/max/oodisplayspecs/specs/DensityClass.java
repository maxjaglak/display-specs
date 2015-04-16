package oo.max.oodisplayspecs.specs;

import android.util.DisplayMetrics;

import lombok.Getter;
import oo.max.oodisplayspecs.R;

public enum DensityClass {

    LDPI (DisplayMetrics.DENSITY_LOW, R.string.ldpi),
    MDPI (DisplayMetrics.DENSITY_MEDIUM, R.string.mdpi),
    TVDPI (DisplayMetrics.DENSITY_TV, R.string.tvdpi),
    HDPI (DisplayMetrics.DENSITY_HIGH, R.string.hdpi),
    XHDPI (DisplayMetrics.DENSITY_XHIGH, R.string.xhdpi),
    DPI400 (DisplayMetrics.DENSITY_400, R.string.dpi400),
    XXHDPI (DisplayMetrics.DENSITY_XXHIGH, R.string.xxhdpi),
    DPI560 (DisplayMetrics.DENSITY_560, R.string.dpi560),
    XXXHDPI (DisplayMetrics.DENSITY_XXXHIGH, R.string.xxxhdpi);

    @Getter
    private final int density;

    @Getter
    private final int nameResourceId;
    private static DensityClass[] densities = getDensityClassesOrderedBySize();

    DensityClass(int density, int nameResourceId) {
        this.density = density;
        this.nameResourceId = nameResourceId;
    }

    public static DensityClass getDensity(int dpi) {
        throwIfNegative(dpi);
        for (DensityClass densityClass : getDensityClassesOrderedBySize()) {
            if(dpi >= densityClass.density) {
                return densityClass;
            }
        }
        throw new RuntimeException("Cannot find proper density class for dpi : "+dpi);
    }

    private static void throwIfNegative(int dpi) {
        if(dpi < 0) {
            throw new IllegalArgumentException("Dpi must not be negative value!");
        }
    }

    public static DensityClass[] getDensityClassesOrderedBySize() {
        return new DensityClass[] { XXXHDPI, DPI560, XXHDPI, DPI400, XHDPI, HDPI, TVDPI, MDPI, LDPI };
    }
}