package ar.edu.unahur.obj2.impostoresPaises

object Observatorio {
    var paises = mutableListOf<Pais>()

    fun sonLimitrofes(pais1: String, pais2:String) =
            this.buscarNombre(pais1)
    fun necesitanTraduccion(pais1: Pais, pais2: Pais) = pais1.compartenIdiomas(pais2)
    fun agregarPais(pais: List<Pais>) = paises.addAll(pais)

    fun buscarNombre(nombre:String) = paises.any { it.nombre == nombre }

}