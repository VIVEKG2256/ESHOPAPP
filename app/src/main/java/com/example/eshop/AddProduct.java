package com.example.eshop;

import static java.sql.Types.NULL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddProduct extends AppCompatActivity {
Button AddP;
EditText ProductName1,ProductPrice1;
FirebaseDatabase database=FirebaseDatabase.getInstance();
DatabaseReference reference= database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        ProductName1=findViewById(R.id.ProductName500);
        ProductPrice1=findViewById(R.id.ProductPrice500);
        AddP=findViewById(R.id.Add);
        AddP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String PName =ProductName1.getText().toString();
                String PPrice=ProductPrice1.getText().toString();
//                reference.child("Product").child(PName).setValue(NULL);
//                reference.child(PName).child("ProductName").setValue(PName);
//                reference.child("Product").child(PPrice).setValue(NULL);
//                reference.child(PPrice).child("ProductPrice").setValue(PPrice);
                 reference.child("Product").child(PName).child("ProductName").setValue(PName);
                 reference.child("Product").child(PName).child("ProductPrice").setValue(PPrice);

                Toast.makeText(AddProduct.this, "Product Added Successfully", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(AddProduct.this,AddAndShowProduct.class);
                startActivity(i);
            }
        });

    }
}