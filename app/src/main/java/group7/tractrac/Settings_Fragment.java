package group7.tractrac;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class Settings_Fragment extends Fragment implements View.OnClickListener{

    Button buttonLogout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        buttonLogout = view.findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(this);

        Animation animationtwo = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_left);

        view.startAnimation(animationtwo);

        return view;
    }

    @Override
    public void onClick(View view) {

        Fragment newFragment = new LoginFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.replace(R.id.fragmentFrame, newFragment);
        transaction.addToBackStack(null);

        transaction.commit();

    }

}
