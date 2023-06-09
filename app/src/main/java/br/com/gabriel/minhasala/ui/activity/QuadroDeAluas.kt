package br.com.gabriel.minhasala.ui.activity

import android.content.DialogInterface
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.gabriel.minhasala.R
import br.com.gabriel.minhasala.dao.QuadrosDao
import br.com.gabriel.minhasala.ui.dialog.FormularioImagemDialog
import br.com.gabriel.minhasala.ui.recyclerview.adapter.ListaQuadroAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class QuadroDeAluas : AppCompatActivity(R.layout.activity_quado_aulas) {

    private val dao = QuadrosDao()
    private val adapter = ListaQuadroAdapter(context = this, quadros = dao.buscaTodos())
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraRecyclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun configuraFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_lista_quadro_fab)
        fab.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorOnPrimary))
        fab.setOnClickListener {
            vaiParaFormularioQuadro()
        }
    }

    private fun vaiParaFormularioQuadro() {
        val intent = Intent(this, FormularioQuadroActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {

        recyclerView = findViewById(R.id.activity_lista_quadro_recyclerView)
        recyclerView.adapter = adapter
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

    }
}