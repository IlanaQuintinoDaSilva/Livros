package br.com.ilanadev.livros.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
//import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.ilanadev.livros.domain.Livro
import kotlinx.android.synthetic.main.adapter_livro.view.*

class LivroAdapter(
        val livros: List<Livro>,
        val onClick: (Livro) -> Unit) :
        RecyclerView.Adapter<LivroAdapter.LivrosViewHolder>() {

    override fun getItemCount(): Int {
        return this.livros.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivrosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_livro,
                parent, false)
        return LivrosViewHolder(view)
    }

    override fun onBindViewHolder(holder: LivrosViewHolder, position: Int) {
        val livro = livros[position]
        val view = holder.itemView
        with(view) {
            tTitulo.text = livro.titulo
            tEditora.text = livro.editora
            //img.loadUrl(carro.urlFoto, progress)
            setOnClickListener { onClick(livro) }
        }
    }
    class LivrosViewHolder(view: View) : RecyclerView.ViewHolder(view)
}


