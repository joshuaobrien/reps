package tokyo.drift.reps;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

/**
 * Created by josh on 27/02/2017.
 */

public class SettingsActivity extends PreferenceActivity implements Preference.OnPreferenceChangeListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);

        bindPreferenceValue(findPreference("units"));
    }

    private void bindPreferenceValue(Preference preference) {
        preference.setOnPreferenceChangeListener(this);

        onPreferenceChange(preference, PreferenceManager.getDefaultSharedPreferences(preference.getContext())
                .getString(preference.getKey(), ""));

    }

    @Override
    public boolean onPreferenceChange(Preference pref, Object value) {
        String val = value.toString();

        if (pref instanceof ListPreference) {
            ListPreference listPref = (ListPreference) pref;
            int prefIndex = listPref.findIndexOfValue(val);

            if (prefIndex >= 0) {
                pref.setSummary(val);
            }
        }
        return true;
    }



}
