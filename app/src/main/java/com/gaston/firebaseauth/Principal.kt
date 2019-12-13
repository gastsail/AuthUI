package com.gaston.firebaseauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import kotlinx.android.synthetic.main.activity_principal.*

class Principal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        signOut()
    }

    fun signOut(){
        btn_logout.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            btn_logout.isEnabled = false
            AuthUI.getInstance().signOut(this).addOnSuccessListener {
                startActivity(Intent(this,LoginActivity::class.java))
                Toast.makeText(this,"Hasta pronto",Toast.LENGTH_SHORT).show()
                finish()
            }.addOnFailureListener {
                btn_logout.isEnabled = true
                progressBar.visibility = View.GONE
                Toast.makeText(this,"Ocurrio un error ${it.message}",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
