package group7.tractrac;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class Settings_Fragment extends Fragment implements View.OnClickListener{

    private CircularProgressButton buttonLogout;


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

        if (view == buttonLogout) {

            buttonLogout.startAnimation();
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Fragment newFragment = new LoginFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();

                    transaction.replace(R.id.fragmentFrame, newFragment);
                    transaction.addToBackStack(null);

                    transaction.commit();

                }
            }, 1500);

        }


    }

}
