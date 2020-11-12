package ar.edu.unahur.obj2.impostoresPaises

object Observatorio {
    var paises = mutableListOf<Pais>()

    fun sonLimitrofes(unPais: String, otro: String): Boolean {
        val unPais = buscarPais(unPais)
        val otroPais = buscarPais(otro)
        return unPais.esLimitrofeDe(otroPais)
    }

    fun buscarPais(nombre: String) = paises.find{ it.nombre == nombre }!!

    fun agregarPais(pais: Pais) {
        paises.add(pais)
        ordenarlosPorPoblacion()
    }


    fun sonPotencialesAliados(pais1: String, pais2: String): Boolean {
        val unPais = buscarPais(pais1)
        val otroPais = buscarPais(pais2)
        return unPais.comparteBloqueCon(otroPais) && !unPais.necesitaTraduccionPara(otroPais)
    }

    private fun ordenarlosPorPoblacion() { paises.sortBy { it.poblacion } }


    fun paisesConMayorPoblacion() =
            paises.take(5)


    fun listaPorContinentes() =  paises.map { it.continente  }

    fun necesitanTraduccion(unPais: String, otroPais: String): Boolean {
        val unPais = buscarPais(unPais)
        val otroPais = buscarPais(otroPais)
        return unPais.necesitaTraduccionPara(otroPais)
    }

    //fun continenteMasPoblado():String =
    //      listaPorContinentes()







}