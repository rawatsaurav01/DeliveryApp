package com.example.deliveryapp.layoutFiles;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.deliveryapp.Fragments.Cart;
import com.example.deliveryapp.Fragments.HomePage;
import com.example.deliveryapp.Fragments.MyOrders;
import com.example.deliveryapp.Fragments.Profile;

public class DemoFragmentAdapter extends FragmentPagerAdapter{
    Context c;
    int count;

    public DemoFragmentAdapter(Context applicationContext, FragmentManager fm, int count) {
        super(fm);
        this.c = c;
        this.count = count;
    }

    public DemoFragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                HomePage obj = new HomePage();
                return obj;
            case 1:
                MyOrders obj1 = new MyOrders();
                return obj1;
            case 2:
                Cart obj2 = new Cart();
                return obj2;
            case 3:
                Profile obj3 = new Profile();
                return obj3;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return count;
    }
}
