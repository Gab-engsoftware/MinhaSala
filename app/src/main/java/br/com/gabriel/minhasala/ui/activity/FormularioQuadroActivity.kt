package br.com.gabriel.minhasala.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.gabriel.minhasala.R
import br.com.gabriel.minhasala.dao.QuadrosDao
import br.com.gabriel.minhasala.model.Quadro

class FormularioQuadroActivity :
    AppCompatActivity(R.layout.activity_formulario_quadro) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_botao_salvar)
        val dao = QuadrosDao()
        botaoSalvar.setOnClickListener {
            val quadro = criaQuadro()
            dao.adiciona(quadro)
            finish()
        }
    }

    private fun criaQuadro(): Quadro {
        val campoNome = findViewById<EditText>(R.id.activity_formulario_nome)
        val nome = campoNome.text.toString()
        val campoDia = findViewById<EditText>(R.id.activity_formulario_dia)
        val dia = campoDia.text.toString()
        val campoProfessor = findViewById<EditText>(R.id.activity_formulario_professor)
        val professor = campoProfessor.text.toString()
        val campoSala = findViewById<EditText>(R.id.activity_formulario_sala)
        val sala = campoSala.text.toString()

        return Quadro(
            nome = nome,
            dia = dia,
            professor = professor,
            sala = sala
        )
    }

}