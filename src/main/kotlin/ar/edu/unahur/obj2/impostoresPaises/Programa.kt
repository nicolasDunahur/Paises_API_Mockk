package ar.edu.unahur.obj2.impostoresPaises

// Acá encapsulamos el manejo de la consola real, desacoplandolo del programa en sí
object Consola {
  fun leerLinea() = readLine()!!
  fun escribirLinea(contenido: String) {
    println(contenido)
  }
}

// El código de nuestro programa, que (eventualmente) interactuará con una persona real
object Programa {
  // Ambas son variables para poder cambiarlas en los tests
  var entradaSalida = Consola


  fun iniciar() {
    entradaSalida.escribirLinea("elije un pais")
    val pais = entradaSalida.leerLinea()
    entradaSalida.escribirLinea("elije otro pais")
    val pais2 = entradaSalida.leerLinea()

    comparSiSonLimitrofes(pais, pais2)


    /*val paisesEncontrados1 = api.buscarPaisesPorNombre(pais)
    check(paisesEncontrados1.isNotEmpty())
      { "No encontramos nada, fijate si lo escribiste bien" }
    paisesEncontrados1.forEach {
      entradaSalida.escribirLinea(
        "${it.name} (${it.alpha3Code}) es un país de ${it.region}, con una población de ${it.population} habitantes."
      )
    }
    // comparacion
    entradaSalida.escribirLinea("Hola, poné el nombre de un país y te mostramos algo de data")
    val otroPais = entradaSalida.leerLinea()
    checkNotNull(pais) { "Sin nombre no puedo hacer nada :(" }

    val paiseAComparar = otroPais?.let { api.buscarPaisesPorNombre(it) }
    if (paiseAComparar != null) {
      check(paiseAComparar.isNotEmpty())
      { "No encontramos nada, fijate si lo escribiste bien" }
    }*/

  }
  fun comparSiSonLimitrofes(pais:String, pais2:String) =
    if (Observatorio.sonLimitrofes(pais,pais2)) entradaSalida.escribirLinea("los paises ${pais}, ${pais2} son limitrofes")
    else entradaSalida.escribirLinea("los paises ${pais},${pais2} no limitan")


}
