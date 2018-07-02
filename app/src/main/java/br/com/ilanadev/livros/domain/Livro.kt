package br.com.ilanadev.livros.domain

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable

@Entity(tableName = "livro")

class Livro : Parcelable {
    @PrimaryKey
    var id: Long = 0
    var titulo = ""
    var editora = ""
    var valor: Double = 0.0
    var urlImagem = ""


    override fun toString(): String {
        return "Livro{titulo='$titulo'}"
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        // Escreve os dados para serem serializados
        dest.writeLong(id)
        dest.writeString(this.titulo)
        dest.writeString(this.editora)
        dest.writeDouble(this.valor)
        dest.writeString(this.urlImagem)
    }

    fun readFromParcel(parcel: Parcel) {
        // Lê os dados na mesma ordem em que foram escritos
        this.id = parcel.readLong()
        this.titulo = parcel.readString()
        this.editora = parcel.readString()
        this.valor = parcel.readDouble()
        this.urlImagem = parcel.readString()
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Livro> =
                object : Parcelable.Creator<Livro> {
                    override fun createFromParcel(p: Parcel): Livro {
                        // Cria o objeto livro com um Parcel
                        val l = Livro()
                        l.readFromParcel(p)
                        return l
                    }

                    override fun newArray(size: Int): Array<Livro?> {
                        // Retorna um array vazio
                        return arrayOfNulls(size)
                    }
                }
    }
}
