package tokyo.drift.reps;

import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int selectedId = item.getItemId();

        switch (selectedId) {
            case (R.id.action_settings):
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            String[] dummyData = {
                    "Incline DB Bench n/m xkg",
                    "DB Side Raise n/m xkg",
                    "Machine Fly n/m xkg",
                    "Tricep Dips n/m xkg",
                    "DB Front Raise n/m xkg",
                    "Cable Pushdown n/m xkg"
            };

            List<String> exerciseData = new ArrayList<>(Arrays.asList(dummyData));

            final ArrayAdapter<String> mExerciseAdapter = new ArrayAdapter<>(
                    getActivity(),
                    R.layout.list_item_exercise,
                    R.id.list_item_exercise_textview,
                    exerciseData
            );



            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ListView exerciseListView = (ListView) rootView.findViewById(R.id.listview_exercise);
            exerciseListView.setAdapter(mExerciseAdapter);

            exerciseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    String exercise = mExerciseAdapter.getItem(position);

                    Intent intent = new Intent(getActivity(), ExerciseDetailActivity.class)
                            .putExtra(Intent.EXTRA_TEXT, exercise);

                    startActivity(intent);

                    //Toast.makeText(getContext(), exercise, Toast.LENGTH_SHORT).show();
                }

            });

            return rootView;
        }

    }
}
