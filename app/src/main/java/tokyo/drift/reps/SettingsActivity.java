package tokyo.drift.reps;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by josh on 27/02/2017.
 */

public class SettingsActivity extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);
    }
}
