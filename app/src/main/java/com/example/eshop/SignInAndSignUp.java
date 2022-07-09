package com.example.eshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInAndSignUp extends AppCompatActivity {
Button SignUp,SignIn;
EditText email,password;
FirebaseAuth auth=FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_and_sign_up);
        email = findViewById(R.id.EmailId1);
        password = findViewById(R.id.Password1);
        SignIn = findViewById(R.id.SignIn);
        SignUp = findViewById(R.id.SignUp);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                SignInFireBase(Email, Password);
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInAndSignUp.this, SignUp.class);
                startActivity(i);
            }
        });
    }
        public void SignInFireBase(String Email,String Password){

            auth.signInWithEmailAndPassword(Email, Password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignInAndSignUp.this, "SignIn Successfull", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(SignInAndSignUp.this,AddAndShowProduct.class);
                                startActivity(i);

                            } else {
                                Toast.makeText(SignInAndSignUp.this, "Please Enter Valid Credentials", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

        }
}