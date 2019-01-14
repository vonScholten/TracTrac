
package group7.tractrac;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    Button loginbutton;
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

        return view;
    }

    @Override
    public void onClick(View view) {

        if (view == loginbutton) {


            Fragment newFragment = new Settings_Fragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            transaction.replace(R.id.fragmentFrame, newFragment);
            transaction.addToBackStack(null);


            transaction.commit();
        }

        else {
            Toast.makeText(this.getActivity(), "Not Yet Implemented", Toast.LENGTH_SHORT).show();
        }


    }
}