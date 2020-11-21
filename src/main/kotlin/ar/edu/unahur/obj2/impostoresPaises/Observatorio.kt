package ar.edu.unahur.obj2.impostoresPaises

object Observatorio {
    var api = RestCountriesAPI()
    var paises = mutableListOf<Pais>()

    fun sonLimitrofes(unPais: String, otro: String): Boolean {
        val unPais = buscarPais(unPais)
        val elOtro = buscarPais(otro)
        return unPais.esLimitrofeDe(elOtro)
    }

    //// Etapa 1 - Borrar? ///
    fun buscarPaisPorNombre(nombre: String) = paises.find{ it.nombre == nombre }!!
        /*
            fun sonLimitrofes(unPais: String,otro: Country ): Boolean {
                val unPais = buscarPaisPorNombre(unPais)
                paisAdapter.convertirAPais(otro)
                val otroPais = buscarPais(otro)
                return unPais.esLimitrofeDe(otroPais)
            }
        */
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