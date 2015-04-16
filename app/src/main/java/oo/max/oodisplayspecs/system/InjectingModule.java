package oo.max.oodisplayspecs.system;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import oo.max.oodisplayspecs.specs.SpecsRetriever;
import oo.max.oodisplayspecs.specs.SpecsRetrieverImplementation;
import oo.max.oodisplayspecs.ui.MainActivity;

@Module( library = true, injects = {
        CustomApplication.class,
        MainActivity.class,
        SpecsRetrieverImplementation.class
})
public class InjectingModule  {

    private final Context applicationContext;

    public InjectingModule(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Provides
    public Context provideContext() {
        return applicationContext;
    }

    @Provides
    public SpecsRetriever provideSpecsRetriever() {
        return new SpecsRetrieverImplementation(applicationContext);
    }
}
