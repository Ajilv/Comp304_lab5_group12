package com.example.comp_304lab5group12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var et_email : EditText
    private lateinit var et_password:EditText
    private lateinit var authenticate : FirebaseAuth
    private lateinit var signin:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        authenticate = Firebase.auth

        et_email = findViewById(R.id.et_loginusername)
        et_password = findViewById(R.id.et_loginpassword)
        signin = findViewById(R.id.loginBtn)

        signin.setOnClickListener{
            AttemptLogin()


        }





    }

    private fun AttemptLogin(){
        val email = et_email.text.toString()
        val password = et_password.text.toString()


        if(TextUtils.isEmpty(email)){
            et_email.error = "this field cannot be empty"
            et_email.requestFocus()
        } else if (TextUtils.isEmpty(password)){
            et_password.error = "this field cannot be empty"
            et_password.requestFocus()

        } else{
            authenticate.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){
                        task ->
                    if(task.isSuccessful){

                      authenticate.currentUser

                        val intent = Intent(this@MainActivity,WorkActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(baseContext,"authentication failed",Toast.LENGTH_SHORT).show()
                    }
                }
        }












    }







}