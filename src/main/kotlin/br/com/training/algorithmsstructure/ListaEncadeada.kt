package br.com.training.algorithmsstructure

data class ListaEncadeada(
    var value: String? = null
) {

    var size: Int = 0
    var primeiro: No? = null
    var ultimo: No? = null

    fun adiciona(value: String) {
        // situação: Criando primeiro valor
        if (this.primeiro == null && this.ultimo == null) {
            this.primeiro = No(value)
            this.ultimo = No(value)
            addSize()
        }

        // situação: Existe somente um valor na lista
        else if (this.primeiro != null && this.primeiro!!.proximo == null ) {
            val newValue = No(value)
            this.primeiro!!.proximo = newValue
            this.ultimo = newValue
            addSize()
        }

        // situação: Existe mais de um valor na lista
        else if (this.primeiro != null && this.primeiro!!.proximo != null ) {
            val newValue = No(value)
            var noValue = this.primeiro!!.proximo
            while(noValue!!.proximo != null){
                noValue = noValue!!.proximo
            }
            this.ultimo = newValue
            noValue.proximo = this.ultimo
            addSize()
        }
    }

    private fun addSize() {
        this.size++
    }

    private fun minusSize() {
        this.size--
    }

    fun size(): Int {
        return this.size
    }

    fun get(index: Int): String {
        var nodes = getNodeByIndex(index)

        return nodes!!.value
    }

    private fun getNodeByIndex(index: Int): No? {
        var sizeList = 0
        if (this.primeiro == null) throw IndexOutOfBoundsException("Não existe elemento para esse index!!")
        if (index >= this.size) throw IndexOutOfBoundsException("Index maior que tamanho da lista!!")

        var nodes = this.primeiro
        while (sizeList < index && nodes!!.value != null) {
            nodes = nodes!!.proximo
            sizeList++
        }
        return nodes
    }

    fun delete(index: Int) {
        // pegar os três nodes ( node anterior / node para excluir / proximo node
        val nodeBeforeByIndex = getNodeByIndex(index-1)
        val nodeByIndex = getNodeByIndex(index)

        // caso1: excluir o unico elemento
        if (nodeByIndex === this.primeiro && this.primeiro!!.proximo == null){
            this.primeiro = null
            this.ultimo = null
        }
        // caso2: node que irá excluir é o ultimo
        else if (nodeByIndex === this.ultimo){
            nodeBeforeByIndex!!.proximo = null
            this.ultimo = nodeBeforeByIndex
        }
        // caso3: excluir primeiro elemento
        else if (index==0 && this.size > 0 && nodeByIndex===this.primeiro && nodeByIndex!!.proximo!=null){
            val nodeAfter = nodeByIndex!!.proximo
            this.primeiro = nodeAfter
        }

        // caso3: node que irá deletar é do meio.
        else {
            val nodeAfter = nodeByIndex!!.proximo
            nodeBeforeByIndex!!.proximo = nodeAfter
        }

        minusSize()
    }
}