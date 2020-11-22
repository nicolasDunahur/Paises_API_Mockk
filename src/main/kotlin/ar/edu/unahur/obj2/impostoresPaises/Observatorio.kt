package ar.edu.unahur.obj2.impostoresPaises

object Observatorio {
    var api = RestCountriesAPI()
    var paises = mutableListOf<Pais>()

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

    fun sonPotencialesAliados(pais1: String, pais2: String): Boolean {
        val unPais = buscarPais(pais1)
        val otroPais = buscarPais(pais2)
        return unPais.comparteBloqueCon(otroPais) && !unPais.necesitaTraduccionPara(otroPais)
    }

    //4
    //  se deben ordenar los paises para
    fun ordenarlosPorPoblacion() { paises.sortByDescending { it.poblacion } }

    fun paisesOrdenadosPorNombre() = paises.map { it.nombre }

    fun paisesConMayorPoblacion() = paisesOrdenadosPorNombre().filterIndexed { index, s -> (index != 5)}

    // 5
    fun continenConMasPobla() = paises.maxBy { it.poblacion }!!.continente

}