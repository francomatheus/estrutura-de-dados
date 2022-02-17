package br.com.training.algorithmsstructure

class AlgorithmsStructureApplication

fun main(args: Array<String>) {

    val lista = ListaEncadeada()

    lista.adiciona("abc")
    lista.adiciona("def")
    lista.adiciona("ghi")
    lista.adiciona("jkl")
    lista.adiciona("mno")
    lista.adiciona("pqr")

    println("Tamanho: ${lista.size()}")
    println("Primeiro: ${lista.primeiro!!.value}")
    println("Proximo: ${lista.primeiro!!.proximo}")
    println("Ultimo: ${lista.ultimo!!}")

    val get = lista.get(3)

    println("Elemento 4: $get")

    lista.delete(5)
    println("Novo tamanho da lista: ${lista.size}")
    println("Lista: ${lista.primeiro}")
    println("Ultimo elemento da lista: ${lista.ultimo}")

    lista.adiciona("8")
    println("Novo tamanho da lista: ${lista.size}")
    println("Lista: ${lista.primeiro}")
    println("Elemento: ${lista.get(4)}")


    lista.delete(0)
    println("Novo tamanho da lista: ${lista.size}")
    println("Lista: ${lista.primeiro}")
    println("Ultimo elemento da lista: ${lista.ultimo}")


    lista.delete(2)
    println("Novo tamanho da lista: ${lista.size}")
    println("Lista: ${lista.primeiro}")
    println("Ultimo elemento da lista: ${lista.ultimo}")
}
