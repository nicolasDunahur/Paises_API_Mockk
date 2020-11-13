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

    fun ordenarlosPorPoblacion() { paises.sortByDescending { it.poblacion } }

    fun paisesOrdenadosPorNombre() = paises.map { it.nombre }

    fun paisesConMayorPoblacion() = paisesOrdenadosPorNombre().take(5)

    fun necesitanTraduccion(unPais: String, otroPais: String): Boolean {
        val unPais = buscarPais(unPais)
        val otroPais = buscarPais(otroPais)
        return unPais.necesitaTraduccionPara(otroPais)
    }

    fun listaPorElContinente(unContiente:String):List<Pais> =  paises.filter { it.continente == unContiente }!!

    fun habitantesEnElContinente(unContiente:String) =
        listaPorElContinente(unContiente).sumBy { it.poblacion }

    fun listaDeHabitantesPorContienentes()=
        mutableListOf<Int>(
                habitantesEnElContinente("America"),
                habitantesEnElContinente("Europa"),
                habitantesEnElContinente("Africa"),
                habitantesEnElContinente("Asia"),
                habitantesEnElContinente("Oceania")
        )


    fun cantContinenteMasPoblado() = listaDeHabitantesPorContienentes().maxByOrNull { it.toBigDecimal() }



/*

HACER CON TUPLA

Y para el 5 tengo una lista de continentes
Tengo una función que me da la cantidad de habitantes por continente (le pasó por parámetro el continente)

Y después una función que recorre la lista de continentes y hace un maxBy a la función de habitantes por continente
 */
    //fun continenteMasPoblado():String =
    //      listaPorContinentes()







}