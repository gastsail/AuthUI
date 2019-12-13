package com.gaston.firebaseauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private val authUser:FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        goTo()
    }

    fun goTo(){
        if(authUser.currentUser != null){
            startActivity(Intent(this,Principal::class.java))
            finish()
        }else{
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }
}
