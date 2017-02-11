package com.faqrulans.calcandfriend;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements NavigationDrawerFragment.OnFragmentInteractionListener {


    FragmentPagerAdapter adapterViewPager;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.myViewPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapterViewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.navigation_drawer_menu, menu);
        return true;
    }

    public void MenuClicked(MenuItem item){

        if(getSupportFragmentManager().getBackStackEntryCount() == 0) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            NavigationDrawerFragment navigationDrawer = new NavigationDrawerFragment();

            ft.setCustomAnimations(R.anim.slide_right,0,0,R.anim.slide_left);

            ft.replace(R.id.navigationDrawerSection, navigationDrawer);
            ft.addToBackStack(null);

            ft.commit();

        }else if(getSupportFragmentManager().getBackStackEntryCount() == 1){
            getSupportFragmentManager().popBackStack();

        }

    }

    /**
    public void WriteInput(View view){

        String text = ((Button)view).getText().toString();

        switch (view.getId()){

            case R.id.button_0:
                aritmaticTV.append(text);
            case R.id.button_1:
                aritmaticTV.append(text);
            case R.id.button_2:
                aritmaticTV.append(text);
            case R.id.button_3:
                aritmaticTV.append(text);
            case R.id.button_4:
                aritmaticTV.append(text);
            case R.id.button_5:
                aritmaticTV.append(text);
            case R.id.button_6:
                aritmaticTV.append(text);
            case R.id.button_7:
                aritmaticTV.append(text);
            case R.id.button_8:
                aritmaticTV.append(text);
            case R.id.button_9:
                aritmaticTV.append(text);
            case R.id.button_c:
            case R.id.button_del:
            case R.id.button_ans:
            case R.id.button_div:
                aritmaticTV.append(text);
            case R.id.button_mul:
                aritmaticTV.append(text);
            case R.id.button_sub:
                aritmaticTV.append(text);
            case R.id.button_add:
                aritmaticTV.append(text);
            case R.id.button_equals:



        }

    }**/

    @Override
    public void onFragmentInteraction(int position) {
        getSupportFragmentManager().popBackStack();
        mViewPager.setCurrentItem(position);
    }
}
