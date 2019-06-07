package com.hermosaprogramacion.premium.appproductos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.hermosaprogramacion.premium.appproductos.products.domain.ProductsFragment;

public class ProductsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Fragment mProductsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Referencia UI
        mProductsFragment = getSupportFragmentManager().findFragmentById(R.id.products_containers);

        //setup
        setUpProductsFragments();

    }

    private void setUpProductsFragments() {
        if (mProductsFragment == null) {
            mProductsFragment = new ProductsFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.products_containers, mProductsFragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_products, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

            int id= item.getItemId();

            if (id== R.id.action_settings)
                return true;
        return super.onOptionsItemSelected(item);
    }
}
