package ar.edu.unahur.obj2.impostoresPaises

object Observatorio {
    var api = RestCountriesAPI()
    var paises = mutableListOf<Pais>()

    fun sonLimitrofes(unPais: String, otro: String): Boolean {
        val unPais = buscarPais(unPais)
        val elOtro = buscarPais(otro)
        return unPais.esLimitrofeDe(elOtro)
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

    fun necesitanTraduccion(nombre1: String, nombre2: String): Boolean {
        val unPais = buscarPais(nombre1)
        val otroPais = buscarPais(nombre2)
        return unPais.necesitaTraduccionPara(otroPais)
    }

    //4
    //  se deben ordenar los paises para
    fun ordenarlosPorPoblacion() { paises.sortByDescending { it.poblacion } }

    fun paisesOrdenadosPorNombre() = paises.map { it.nombre }

    fun paisesConMayorPoblacion() = paisesOrdenadosPorNombre().filterIndexed { index, s -> (index != 5)}

    // 5
    fun continenConMasPobla() = paises.maxBy { it.poblacion }!!.continente


}