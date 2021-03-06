package mn.devfest.sessions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mn.devfest.R;
import mn.devfest.view.NumberFeedbackField;

/**
 * Fragment that allows the user to rate a session
 *
 * @author bherbst
 */
public class RateSessionFragment extends Fragment {
    private static final String ARG_SESSION_ID = "arg_session_id";

    @Bind(R.id.overall_session_rating) RatingBar mOverallBar;
    @Bind(R.id.field_relevancy) NumberFeedbackField mRelevancyBar;
    @Bind(R.id.field_content) NumberFeedbackField mcontentBar;
    @Bind(R.id.field_speaker_quality) NumberFeedbackField mSpeakerBar;

    private String mSessionId;

    /**
     * Get a new RateSessionFragment for a given session
     * @param sessionId The ID of the session to rate
     * @return A new RatSessionFragment for the given session
     */
    public static RateSessionFragment newInstance(String sessionId) {
        Bundle args = new Bundle();
        args.putString(ARG_SESSION_ID, sessionId);

        RateSessionFragment frag =  new RateSessionFragment();
        frag.setArguments(args);

        return frag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSessionId = getArguments().getString(ARG_SESSION_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rate_session, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.submit_feedback_button)
    void onSubmitClicked() {
        int overall = (int) mOverallBar.getRating();
        int relevancy = mRelevancyBar.getRating();
        int content = mcontentBar.getRating();
        int speakerQuality = mSpeakerBar.getRating();
    }
}
