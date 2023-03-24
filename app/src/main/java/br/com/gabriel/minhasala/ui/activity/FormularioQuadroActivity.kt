package br.com.gabriel.minhasala.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import br.com.gabriel.minhasala.R
import br.com.gabriel.minhasala.dao.QuadrosDao
import br.com.gabriel.minhasala.model.Quadro

class FormularioQuadroActivity :
    AppCompatActivity(R.layout.activity_formulario_quadro) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)
        botaoSalvar.setOnClickListener {
            val campoNome = findViewById<EditText>(R.id.nome)
            val nome = campoNome.text.toString()
            val campoDia = findViewById<EditText>(R.id.dia)
            val dia = campoDia.text.toString()
            val campoProfessor = findViewById<EditText>(R.id.professor)
            val professor = campoProfessor.text.toString()
            val campoSala = findViewById<EditText>(R.id.sala)
            val sala = campoSala.text.toString()

            val quadro = Quadro(
                nome = nome,
                dia = dia,
                professor = professor,
                sala =  sala
            )
            Log.i("FormularioQuadro", "onCreate: $quadro")
            val dao = QuadrosDao()
            dao.adiciona(quadro)
            Log.i("FormularioQuadro", "onCreate: ${dao.buscaTodos()}")
            finish()
        }
    }

}