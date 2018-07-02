package br.com.ilanadev.livros.activity.livro

import br.com.ilanadev.livros.domain.Livro

interface LivroView{
    fun alerta(msg:String)
    //fun showProgress()
    //fun hideProgress()
    fun setLivros(livros:List<Livro>)
}