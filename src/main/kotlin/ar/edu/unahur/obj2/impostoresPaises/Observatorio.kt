package ar.edu.unahur.obj2.impostoresPaises

object Observatorio {
    var api = RestCountriesAPI()
    var paises = api.todosLosPaises().map { adaptador.convertirAPais(it) }

    fun buscarPais(nombre: String): Pais {
        val country = api.buscarPaisesPorNombre(nombre)
        return adaptador.convertirAPais(country.first())
    }

    // 1
    fun sonLimitrofes(unPais: String, otro: String): Boolean {
        val unPais = buscarPais(unPais)
        val elOtroConCodigo = buscarPais(otro)
        return unPais.esLimitrofeDe(elOtroConCodigo)
    }

    // 2
    fun necesitanTraduccion(nombre1: String, nombre2: String): Boolean {
        val unPais = buscarPais(nombre1)
        val otroPais = buscarPais(nombre2)
        return unPais.necesitaTraduccionPara(otroPais)
    }

    // 3
    fun sonPotencialesAliados(pais1: String, pais2: String): Boolean {
        val unPais = buscarPais(pais1)
        val otroPais = buscarPais(pais2)
        return unPais.comparteBloqueCon(otroPais) && !unPais.necesitaTraduccionPara(otroPais)
    }

    // 4
    fun ordenarlosPorPoblacion() = paises.sortedByDescending { it.poblacion }

    fun ordenadosYConNombres() = ordenarlosPorPoblacion().map { it.nombre }

    fun paisesConMayorPoblacion() =
            ordenadosYConNombres().filterIndexed  { index, s -> (index != 5) }

    // 5
    fun continenConMasPobla() = paises.maxBy { it.poblacion }!!.continente

}
