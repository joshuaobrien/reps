package tokyo.drift.reps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by josh on 25/02/2017.
 */

public class ExerciseDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_activity_detail);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ExerciseDetailFragment())
                    .commit();
        }
    }

    public static class ExerciseDetailFragment extends Fragment {

        public ExerciseDetailFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.exercise_fragment_detail, container, false);

            Intent intent = getActivity().getIntent();

            /* pull the exercise name out of the intent */
            if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
                String exercise = intent.getStringExtra(Intent.EXTRA_TEXT);
                ((TextView) rootView.findViewById(R.id.exercise_detail_text))
                        .setText(exercise);

            }

            return rootView;
        }

    }


}
