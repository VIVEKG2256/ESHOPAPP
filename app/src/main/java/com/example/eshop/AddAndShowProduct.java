package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddAndShowProduct extends AppCompatActivity {
Button AddProduct1,ShowProduct1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_and_show_product);
        AddProduct1=findViewById(R.id.AddProduct);
        ShowProduct1=findViewById(R.id.ShowProduct);
        AddProduct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AddAndShowProduct.this,AddProduct.class);
                startActivity(i);
            }
        });

        ShowProduct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AddAndShowProduct.this,ProductDetails.class);
                startActivity(i);

            }
        });
    }
}