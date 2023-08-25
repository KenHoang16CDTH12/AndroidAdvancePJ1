package com.example.orderf_ood.view.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.orderf_ood.R;
import com.example.orderf_ood.core.data.local.model.FoodModel;
import com.example.orderf_ood.view.cart.CartListActivity;
import com.example.orderf_ood.view.drawerMenu.AddProductActivity;
import com.example.orderf_ood.view.drawerMenu.MapViewActivity;
import com.example.orderf_ood.view.home.HomeFragment;
import com.example.orderf_ood.view.login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public BottomNavigationView bottomNavigationView;
    public DrawerLayout drawerLayout;
    public NavigationView navigationView;
    public ActionBarDrawerToggle toggle;
    public Toolbar toolbar;
    private ImageView imageViewCartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //khi nao can tao du lieu thi moi su dung
//        FoodModel.insertDataTestFood(getApplicationContext());
        initView();
        initToolbar();
        drawerMenu();
    }

    private void drawerMenu() {
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
//         navigationView.setCheckedItem(R.id.navHome);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        imageViewCartList = findViewById(R.id.image_view_cart_list);
        imageViewCartList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), CartListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        bottomNavigationView = findViewById(R.id.bottom_nav_bar);
        HomeFragment fragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment, "");
        fragmentTransaction.commit();

        bottomNavigationView.setOnItemSelectedListener(bottomSelectedListener);

    }

    private BottomNavigationView.OnItemSelectedListener bottomSelectedListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.navigation_chat:
                    ChatFragment fragment2 = new ChatFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.content, fragment2, "");
                    fragmentTransaction2.commit();
                    break;
                case R.id.navigation_history:
                    HistoryFragment fragment3 = new HistoryFragment();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.content, fragment3, "");
                    fragmentTransaction3.commit();
                    break;
                case R.id.navigation_account:
                    AccountFragment fragment4 = new AccountFragment();
                    FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.replace(R.id.content, fragment4, "");
                    fragmentTransaction4.commit();
                    break;
                default:
                    HomeFragment fragment5 = new HomeFragment();
                    FragmentTransaction fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction5.replace(R.id.content, fragment5, "");
                    fragmentTransaction5.commit();
                    break;
            }
            Log.d("log", "tabbar menuitem id: " + menuItem.getItemId());
            return false;
        }
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return false;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_product_item:
                //Move to AddProductActivity
                Intent intent = new Intent(this, AddProductActivity.class);
                startActivity(intent);
                drawerLayout.close();
                break;
            case R.id.item_2:
                Intent intent1 = new Intent(this, LoginActivity.class);
                startActivity(intent1);
                // finish current activity
                finish();
                break;
            case R.id.item_3:
                // xu ly hien thi man hinh map
                Intent intentMap = new Intent(HomeActivity.this, MapViewActivity.class);
                startActivity(intentMap);
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}