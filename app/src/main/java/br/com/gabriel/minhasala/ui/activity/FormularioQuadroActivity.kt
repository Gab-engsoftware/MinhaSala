package br.com.gabriel.minhasala.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import br.com.gabriel.minhasala.R
import br.com.gabriel.minhasala.dao.QuadrosDao
import br.com.gabriel.minhasala.databinding.ActivityFormularioQuadroBinding
import br.com.gabriel.minhasala.databinding.FormularioImagemBinding
import br.com.gabriel.minhasala.extensions.tentaCarregarImagem
import br.com.gabriel.minhasala.model.Quadro
import br.com.gabriel.minhasala.ui.dialog.FormularioImagemDialog
import coil.load

class FormularioQuadroActivity :
    AppCompatActivity(R.layout.activity_formulario_quadro) {
    private val binding by lazy {
        ActivityFormularioQuadroBinding.inflate(layoutInflater)
    }
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Cadastrar Sala"
        configuraBotaoSalvar()
        binding.activityFormularioImagem.setOnClickListener {
            FormularioImagemDialog(this)
                .mostra(url) { imagem ->
                    url = imagem
                    binding.activityFormularioImagem.tentaCarregarImagem(url)
                }
        }

    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = binding.activityFormularioBotaoSalvar
        val dao = QuadrosDao()
        botaoSalvar.setOnClickListener {
            val quadro = criaQuadro()
            dao.adiciona(quadro)
            finish()
        }
    }

    private fun criaQuadro(): Quadro {
        val campoNome = binding.activityFormularioNome
        val nome = campoNome.text.toString()
        val campoDia = binding.activityFormularioDia
        val dia = campoDia.text.toString()
        val campoProfessor = binding.activityFormularioProfessor
        val professor = campoProfessor.text.toString()
        val campoSala = binding.activityFormularioSala
        val sala = campoSala.text.toString()

        return Quadro(
            nome = nome,
            dia = dia,
            professor = professor,
            sala = sala,
            imagem = url
        )
    }

}