import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    var cojondemono = mutableListOf(Articulo(4, 40), Articulo(6, 30), Articulo(4, 50), Articulo(5, 10), Articulo(7, 8))
    cojondemono.sort()
    println(cojondemono)
    var mochilaJ = Mochila(cojondemono)
    mochilaJ.dentroM()
    println(Persona("Jack", mochilaJ, "Ladron"))
}


class Persona(var nombre: String, var mochila: Mochila, var perfil: String) {
    override fun toString(): String {
        return "Persona(nombre='$nombre', mochila=$mochila, perfil='$perfil')"
    }
}

class Mochila(var lista: MutableList<Articulo>) {
    var W = 10
    var dMochila = mutableListOf<Articulo>()
    fun dentroM() {
        val result = mutableListOf<Articulo>()
        var suma = 0
        var er = 0
        while (suma <= W) {
            suma += result[er].peso
            if (suma > W) break
            result.add(lista[lista.size - 1])
            lista.removeLastOrNull()
            er + 1
        }
        dMochila = lista
        lista = result
        println(lista)
    }
    /*

            while (suma < W) {
                val el = lista.removeLastOrNull()!!
                result.add(el)
                if (el == null || suma + el.peso > W) break
                suma += el.peso
            }
     */

    override fun toString(): String {
        return "Mochila(lista=$dMochila)"
    }
}

class Articulo(var peso: Int, var valor: Int) : Comparable<Articulo> {
    override fun compareTo(other: Articulo): Int {
        return if (peso.toDouble() / valor.toDouble() > other.peso.toDouble() / other.valor) 1
        else if (peso.toDouble() / valor.toDouble() < other.peso.toDouble() / other.valor) -1
        else 0
    }

    override fun toString(): String {
        return "Articulo(peso=$peso, valor=$valor)"
    }
}
