package com.example.eshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
Button SignUp;
EditText email,password;
    FirebaseAuth auth=FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email = findViewById(R.id.EmailId2);
        password = findViewById(R.id.Password2);
        SignUp = findViewById(R.id.SignUp2);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                signUpFirebase(Email, Password);
            }
        });
    }
       public void signUpFirebase(String Email,String Password){

//           FirebaseAuth auth = null;
           auth.createUserWithEmailAndPassword(Email, Password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignUp.this, "Account hasbeen created successfully", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(SignUp.this,SignInAndSignUp.class);
                                startActivity(i);

                            } else {
                                Toast.makeText(SignUp.this, "Please fill the required credentials", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
            

    }
}