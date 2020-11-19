package ar.edu.unahur.obj2.impostoresPaises

object Observatorio {
    var api = RestCountriesAPI()

    fun sonLimitrofes(unPais: String,): Boolean {
        val unPais = paises.buscarPaisesPorNombre(unPais)
        paisAdapter.convertir(otro)
        val otroPais = buscarPais(otro)
        return unPais.esLimitrofeDe(otroPais)
    }

    fun buscarPais(nombre: String): Pais {
        val country = api.buscarPaisesPorNombre("Argentina")
        return paisAdapter.convertirAPais(country.first())
    }


    fun sonPotencialesAliados(pais1: String, pais2: String): Boolean {
        val unPais = buscarPais(pais1)
        val otroPais = buscarPais(pais2)
        return unPais.comparteBloqueCon(otroPais) && !unPais.necesitaTraduccionPara(otroPais)
    }

    fun ordenarlosPorPoblacion() { paises.sortByDescending { it.poblacion } }

    fun necesitanTraduccion(nombre1: String, nombre2: String): Boolean {
        val unPais = buscarPais(nombre1)
        val otroPais = buscarPais(nombre2)
        return unPais.necesitaTraduccionPara(otroPais)
    }

    //4
    fun paisesOrdenadosPorNombre() = paises.map { it.nombre }

    fun paisesConMayorPoblacion() = paisesOrdenadosPorNombre().filterIndexed { index, s -> (index != 5)}

    // 5
    fun continenConMasPobla() = paises.maxBy { it.poblacion }!!.continente


}