package ar.edu.unahur.obj2.impostoresPaises

object Observatorio {
    var paises = mutableListOf<Pais>()

    fun sonLimitrofes(pais1: String, pais2: String) =
            traerPaisPorNombre(pais1)?.esLimitrofeDelString(pais2)

    fun traerPaisPorNombre(nombre: String) = paises?.find { it.nombre == nombre }

    fun necesitanTraduccion(pais1: String, pais2: String) = traerPaisPorNombre(pais2)?.let { traerPaisPorNombre(pais1)?.compartenIdiomas(it) }

    fun agregarPais(pais: List<Pais>) {
        paises.addAll(pais)
        ordenarlosPorPoblacion()
    }

    fun buscarNombre(nombre: String) = paises.any { it.nombre == nombre }

    fun sonPotencialesAliados(pais1: String, pais2: String) =
            traerPaisPorNombre(pais1)?.esPotencialAliadoDe(pais2)

    private fun ordenarlosPorPoblacion() { paises.sortBy { it.poblacion } }


    fun paisesConMayorPoblacion() =
            paises.take(5)


    fun listaPorContinentes() =  paises.map { it.continente  }

    //fun continenteMasPoblado():String =
      //      listaPorContinentes()
    // Hay alguna funcion que haga todo junto? debe contar repetidos






}