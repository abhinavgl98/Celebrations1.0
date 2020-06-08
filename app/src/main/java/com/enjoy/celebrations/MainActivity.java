package com.enjoy.celebrations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import com.enjoy.celebrations.MainActivityFragments.HomeFragment.HomeFragmentMain;
import com.enjoy.celebrations.MainActivityFragments.LetsCelebrate.LetsCelebrateFragment;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;


public class MainActivity extends AppCompatActivity {




    MeowBottomNavigation mainBottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBottomNav=findViewById(R.id.mainBottomNav);
        mainBottomNav.add(new MeowBottomNavigation.Model(1,R.drawable.outline_home_black_24dp));
        mainBottomNav.add(new MeowBottomNavigation.Model(2,R.drawable.ic_card_giftcard_black_24dp));
        mainBottomNav.add(new MeowBottomNavigation.Model(3,R.drawable.ic_local_phone_black_24dp));
        mainBottomNav.add(new MeowBottomNavigation.Model(4,R.drawable.ic_account_circle_black_24dp));

        mainBottomNav.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                Fragment selectedFragment=null;
                switch (model.getId()){
                    case 1:
                        selectedFragment=new HomeFragmentMain();
                        break;
                    case 2:
                        selectedFragment=new LetsCelebrateFragment();
                        break;
                    case 3:
                        selectedFragment=new LetsCelebrateFragment();
                        break;
                    case 4:
                        selectedFragment=new LetsCelebrateFragment();
                        break;
                }
                callFragment(selectedFragment);
               return null;
            }
        });



    }

    public void callFragment(Fragment fragment){
        fragment.setEnterTransition(new Slide(Gravity.START));
        fragment.setReturnTransition(new Slide(Gravity.START));
        FragmentTransaction transition=getSupportFragmentManager().beginTransaction();
        transition.replace(R.id.mainFrameLayout,fragment);
        transition.addToBackStack(null);
        transition.commit();

    }
}
