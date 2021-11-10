package cl.mariaca.appaforos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun intentar(view: View){
        val numero = findViewById<EditText>(R.id.editTextNumber).text.toString();
        val intent_acceso = Intent(this, acceso_personas::class.java)
        intent_acceso.putExtra("aforo", numero);
        startActivity(intent_acceso);
    }

}

