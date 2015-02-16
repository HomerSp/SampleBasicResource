package eu.elpollo.sample.basicresource;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import android.content.res.PResources;
import se.aqba.framework.elpollo.ElPollo;
import se.aqba.framework.elpollo.ElPolloModule;
import se.aqba.framework.elpollo.exception.OverrideException;


public class Module extends ElPolloModule {
    // The class tag, used for log output.
    private static final String TAG = "SampleModule";

    @Override
    public void main() {
        // Add a resource listener for the system framework.
        ElPollo.Resources.addListener(new ElPollo.Resources.Listener() {
            @Override
            public void onLoad(String pkg, PResources res) {
                Log.d(TAG, "Resource onLoad " + pkg);

                // This should replace the "Power off" text in the power dialog to say "Power down"
                ElPollo.Resources.addReplacement(pkg, "global_action_power_off", "string", res, "Power down");
            }
        }, ElPollo.Resources.SYSTEM);
    }

    @Override
    public void destroy() {

    }
}