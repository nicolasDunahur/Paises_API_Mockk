package ar.edu.unahur.obj2.impostoresPaises

// Analiza y arroja concluciones sobre paises y contienentes.

object Observatorio {

    var api = RestCountriesAPI()

    // Recibe como parametro el nombre de un pais y si es correcto devuelve ese pais adaptado.

    private fun buscarPais(nombre: String): Pais {
        val country = api.buscarPaisesPorNombre(nombre)
        return Adaptador.convertirAPais(country.first())
    }

    // 1 -- Nos devuelve si 2 paises son limitrofes o no.

    fun sonLimitrofes(pais: String, otro: String): Boolean {
        val unPais = buscarPais(pais)
        val otroPais = buscarPais(otro)
        return unPais.esLimitrofeDe(otroPais)
    }

    // 2 -- Nos responde si 2 paises necesitan traduccion.

    fun necesitanTraduccion(nombre1: String, nombre2: String): Boolean {
        val unPais = buscarPais(nombre1)
        val otroPais = buscarPais(nombre2)
        return unPais.necesitaTraduccionPara(otroPais)
    }

    // 3 -- Nos responde si 2 paises son potenciales aliados o no.

    fun sonPotencialesAliados(pais1: String, pais2: String): Boolean {
        val unPais = buscarPais(pais1)
        val otroPais = buscarPais(pais2)
        return unPais.esPotencialAliadoDe(otroPais)
    }

    // 4

    // Trae todos los paises de la api y los convierte al tipo de dato pais.
    private fun convertirAPaises() = api.todosLosPaises().map { Adaptador.convertirAPais(it) }

    // Ordena los paises de forma desendiente por poblacion.
    private fun ordenarlosPorPoblacion() = convertirAPaises().sortedByDescending { it.poblacion }

    // Obtenemos una lista con los nombres de los paises ordenados.
    private fun ordenadosYConNombres() = ordenarlosPorPoblacion().map { it.nombre }

    // Nos devuelve una lista con el nombre de los 5 paises mas poblados.
    fun paisesConMayorPoblacion() =
        ordenadosYConNombres().take(5)

    // 5 -- Retorna el continente mas poblado.
    fun continenConMasPobla() = convertirAPaises().maxByOrNull { it.poblacion }!!.continente
}
