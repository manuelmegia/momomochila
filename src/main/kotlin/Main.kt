import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    var cojondemono = mutableListOf(Articulo(4, 40), Articulo(6, 30), Articulo(4, 50), Articulo(5, 10))
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
    fun dentroM() {
        println(lista)
        val result = mutableListOf<Articulo>()
        var suma = 0
        while (suma < W) {
            val el = lista.removeLastOrNull()
            if (el == null || suma + el.peso > W) break
            result.add(el)
            suma += el.peso
        }
        //aaaaa por eso cuando me he hecho el auxiliar se me borraba a la vez
        //gracias :D Nada
        //lista = result
        print(lista)

        /*var sum = 0
        var aux = 0

        //okele
        repeat(lista.size) { g ->
            if (W < sum) {
                sum += lista[g].peso
                aux += 1
            } else if (sum <= W) lista.removeLast() // Si pero esto siempre va a ser true, te lo esta diciendo IntelliJ
        }*/
        println(lista)
    }

    override fun toString(): String {
        return "Mochila(lista=$lista, W=$W)"
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