
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
import android.widget.Toast;
import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    private CircularProgressButton loginbutton;
    Button facebookbutton;
    Button googlebutton;
    Button forgotpassword;
    Button newaccount;



    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        loginbutton = view.findViewById(R.id.loginbutton);
        loginbutton.setOnClickListener(this);


        facebookbutton = view.findViewById(R.id.facebookbutton);
        facebookbutton.setOnClickListener(this);

        googlebutton = view.findViewById(R.id.googlebutton);
        googlebutton.setOnClickListener(this);

        forgotpassword = view.findViewById(R.id.forgotpassword);
        forgotpassword.setOnClickListener(this);

        newaccount = view.findViewById(R.id.newaccount);
        newaccount.setOnClickListener(this);

        Animation animationtwo = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_left);
        view.startAnimation(animationtwo);

        return view;
    }

    @Override
    public void onClick(View view) {

        if (view == loginbutton) {

            loginbutton.startAnimation();
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Fragment newFragment = new Settings_Fragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();

                    transaction.replace(R.id.fragmentFrame, newFragment);
                    transaction.addToBackStack(null);

                    transaction.commit();
                }
            }, 2500);

        }

        else {
            Toast.makeText(this.getActivity(), "Not Yet Implemented", Toast.LENGTH_SHORT).show();
        }


    }
}