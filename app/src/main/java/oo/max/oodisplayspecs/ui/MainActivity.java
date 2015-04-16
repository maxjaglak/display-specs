package oo.max.oodisplayspecs.ui;

import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.InjectView;
import oo.max.oodisplayspecs.R;
import oo.max.oodisplayspecs.specs.SpecsRetriever;


public class MainActivity extends AbstractActivity {

    @InjectView(R.id.resolution)
    TextView resolution;

    @InjectView(R.id.resolution_dp)
    TextView resolutionDp;

    @InjectView(R.id.size_class)
    TextView sizeClass;

    @InjectView(R.id.density)
    TextView density;

    @InjectView(R.id.density_class)
    TextView densityClass;

    @InjectView(R.id.scale)
    TextView scale;

    @Inject
    SpecsRetriever specsRetriever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specs);

        showResolution();
        showResolutionDp();
        showSizeClass();
        showDensity();
        showDensityClass();
        showScale();
    }

    private void showResolution() {
        StringBuilder builder = new StringBuilder();
        builder.append(getString(R.string.screen_resolution))
                .append(" ")
                .append(specsRetriever.getScreenWidthPixels())
                .append(" x ")
                .append(specsRetriever.getScreenHeightPixels());
        resolution.setText(builder.toString());
    }

    private void showResolutionDp() {
        StringBuilder builder = new StringBuilder();
        builder.append(getString(R.string.resolution_dp))
                .append(" ")
                .append(specsRetriever.getScreenWidthDp())
                .append(" x ")
                .append(specsRetriever.getScreenHeightDp());
        resolutionDp.setText(builder.toString());
    }

    private void showSizeClass() {
        StringBuilder builder = new StringBuilder();
        builder.append(getString(R.string.screen_size_class))
                .append(" ")
                .append(getString(specsRetriever.getScreenSizeClass().getNameResourceId()));
        sizeClass.setText(builder.toString());
    }

    private void showDensity() {
        StringBuilder builder = new StringBuilder();
        builder.append(getString(R.string.density))
                .append(" ")
                .append(specsRetriever.getDensityDpi())
                .append(" ")
                .append(getString(R.string.pixels_per_inch));
        density.setText(builder.toString());
    }

    private void showDensityClass() {
        StringBuilder builder = new StringBuilder();
        builder.append(getString(R.string.density_class))
                .append(" ")
                .append(getString(specsRetriever.getDensityClass().getNameResourceId()));
        densityClass.setText(builder.toString());
    }

    private void showScale() {
        StringBuilder builder = new StringBuilder();
        builder.append(getString(R.string.scale))
                .append(" ")
                .append(specsRetriever.getDensityScale());
        scale.setText(builder.toString());
    }

}
