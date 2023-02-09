package RegisterFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.androidproject_hit.R;
import com.example.androidproject_hit.RegisterActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterTwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterTwoFragment extends Fragment {

    private Button b;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegisterTwoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CustomerTrainingProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterTwoFragment newInstance(String param1, String param2) {
        RegisterTwoFragment fragment = new RegisterTwoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.register_two_fragment, container, false);


        Button ButtonSave = view.findViewById(R.id.Reg_save);

/*        ButtonSave.setOnClickListener(new View.OnClickListener()
            @Override
            public void onClick(View view) {

                RegisterActivity registerActivity = (RegisterActivity) getActivity();
                assert registerActivity != null;
                registerActivity.ButtonSave(view);

            }
        });*/
        return view;
    }
}
