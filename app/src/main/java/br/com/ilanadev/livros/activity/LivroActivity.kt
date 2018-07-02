package br.com.ilanadev.livros.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import br.com.ilanadev.livros.activity.livro.LivroPresenter
import br.com.ilanadev.livros.extensions.setupToolbar
import br.com.ilanadev.livros.activity.livro.LivroView
import br.com.ilanadev.livros.domain.Livro
import kotlinx.android.synthetic.main.activity_livro.*
import kotlinx.android.synthetic.main.include_progress.*
import org.jetbrains.anko.toast

class LivroActivity : AppCompatActivity(), LivroView {
    override fun alerta(msg: String) {
        toast(msg)
    }

/*    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.INVISIBLE
    }*/

    override fun setLivros(livros: List<Livro>) {
        recyclerView.adapter = CarroAdapter(carros){
            carro -> presenter.onClickCarro(carro)}
    }
    }

    private val presenter = LivroPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livro)
        setupToolbar(R.id.toolbar)

        // Views
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
    }
}
