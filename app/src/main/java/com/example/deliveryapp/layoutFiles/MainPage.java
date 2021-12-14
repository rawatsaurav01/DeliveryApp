package com.example.deliveryapp.layoutFiles;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.deliveryapp.Fragments.Cart;
import com.example.deliveryapp.Fragments.HomePage;
import com.example.deliveryapp.Fragments.Profile;
import com.example.deliveryapp.R;
import com.example.deliveryapp.layoutFiles.DemoFragmentAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainPage extends AppCompatActivity {
    ViewPager vp1;
    TabLayout tb1;
    DrawerLayout dl;
    ActionBarDrawerToggle ad;
    private int[] tabIcons = {
            R.drawable.ic_baseline_home,
            R.drawable.ic_baseline_reorder,
            R.drawable.ic_baseline_shopping_cart,
            R.drawable.ic_baseline_account_circle_24
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        vp1=findViewById(R.id.vp1);
        tb1=findViewById(R.id.tb1);
        tb1.addTab(tb1.newTab().setText("Home"));
        tb1.addTab(tb1.newTab().setText("My Orders"));
        tb1.addTab(tb1.newTab().setText("Cart"));
        tb1.addTab(tb1.newTab().setText("Profile"));

            tb1.getTabAt(0).setIcon(tabIcons[0]);
            tb1.getTabAt(1).setIcon(tabIcons[1]);
            tb1.getTabAt(2).setIcon(tabIcons[2]);
            tb1.getTabAt(3).setIcon(tabIcons[3]);

        DemoFragmentAdapter adapt=new DemoFragmentAdapter(this,getSupportFragmentManager(),tb1.getTabCount());
        vp1.setAdapter(adapt);



        vp1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tb1));
        tb1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        dl=findViewById(R.id.dl1);
        ad=new ActionBarDrawerToggle(this,dl,R.string.open,R.string.close);//strings are created in string xml file in values
        ad.syncState();//it tells whether the navigation drawer is open or close
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//it is used for icon button on action bar
        dl.addDrawerListener(ad);
        logic();
    }
    public  void logic(){

        NavigationView nv=findViewById(R.id.nv1);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment f=null;
                int id=item.getItemId();
                if(id==R.id.item1);{
                    f=new HomePage();
                }
                if(id==R.id.item2){
                    f=new Cart();
                }
                if(id==R.id.item3){
                    f=new Profile();
                }

                if(id==R.id.item4){
                    //do something
                }
                if(id==R.id.item5){
                    //do something
                }
                if(id==R.id.item6){
                    //do something
                }
                if(id==R.id.item7){
                    //do something
                }
                if(id==R.id.item0){
                    //do something
                }




                if(f!=null){
                    FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.fl,f);
                    dl.closeDrawers();//no more operations can be done. save changes
                    ft.commit();
                }
                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(ad.onOptionsItemSelected(item))
            return  true;
        return super.onOptionsItemSelected(item);
    }
}