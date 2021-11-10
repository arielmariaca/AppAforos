package cl.mariaca.appaforos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE

class acceso_personas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acceso_personas)

        val bundle: Bundle? = intent.extras
        bundle?.let {
            val aforoPer = bundle.getString("aforo")
            findViewById<TextView>(R.id.aforo_max).text = aforoPer;
            val faltantesPer = aforoPer
            findViewById<TextView>(R.id.faltantes).text = faltantesPer;
            val totalPer = 0;
            findViewById<TextView>(R.id.total_personas).text = totalPer.toString();
        }
    }

    fun agregarPer(view: View){

        var txt2 = findViewById<TextView>(R.id.total_personas).text.toString();
        val txt3 = findViewById<TextView>(R.id.aforo_max).text.toString();
        val maximo = txt3.toInt();
        var total = txt2.toIntOrNull();
        if (total != null){
            if (total < maximo){
                total++
                findViewById<TextView>(R.id.total_personas).text = total.toString();

                var txt1 = findViewById<TextView>(R.id.faltantes).text.toString();
                var resultado = txt1.toIntOrNull();
                if (resultado != null){
                    resultado--
                }
                findViewById<TextView>(R.id.faltantes).text = resultado.toString();
                findViewById<Button>(R.id.quitar).isClickable = TRUE;
                findViewById<Button>(R.id.quitar).isEnabled  = TRUE;
            }
            else{
                Toast.makeText(applicationContext, "Llego al máximo", Toast.LENGTH_SHORT).show();
                findViewById<Button>(R.id.agregar).isClickable = FALSE;
                findViewById<Button>(R.id.agregar).isEnabled  = FALSE;
            }
        }
    }

    fun eliminarPer(view: View){
        var txt2 = findViewById<TextView>(R.id.total_personas).text.toString();
        val txt3 = findViewById<TextView>(R.id.aforo_max).text.toString();
        val maximo = txt3.toInt();
        var total = txt2.toIntOrNull();
        if (total != null){
            if (total > 0){
                total--
                findViewById<TextView>(R.id.total_personas).text = total.toString();
                var txt1 = findViewById<TextView>(R.id.faltantes).text.toString();
                var resultado = txt1.toIntOrNull();
                if (resultado != null){
                    resultado++
                }
                findViewById<TextView>(R.id.faltantes).text = resultado.toString();
                findViewById<Button>(R.id.agregar).isClickable = TRUE;
                findViewById<Button>(R.id.agregar).isEnabled  = TRUE;
            }
            else{
                Toast.makeText(applicationContext, "Esta en cero", Toast.LENGTH_SHORT).show();
                findViewById<Button>(R.id.quitar).isClickable = FALSE;
                findViewById<Button>(R.id.quitar).isEnabled  = FALSE;
            }
        }
    }

}