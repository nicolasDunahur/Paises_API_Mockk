package ar.edu.unahur.obj2.impostoresPaises

import ar.edu.unahur.obj2.impostoresPaises.Programa.entradaSalida

// Consola para interactuar con la pantalla.
object Consola {

  // Lee la linea que imprimimos en la pantalla.
  fun leerLinea() = readLine()!!

  // Escribe determinado contenido en la pantalla.
  fun escribirLinea(contenido: String) {
    println(contenido)
  }
}

//  Ingresar datos y chequeamos si existe como pais.
object IngresoYChequeo {
  var apichequeo = RestCountriesAPI()

  // Verificamos que el string ingresado corresponde a un pais y esta escrito correctamente.
  fun chekeoDePais(unPais:String){
    val paisesEncontrados = apichequeo.buscarPaisesPorNombre(unPais)

    checkNotNull(unPais) { "Sin nombre no puedo hacer nada :(" }

    check(paisesEncontrados.isNotEmpty())
    { "No encontramos nada, fijate si lo escribiste bien, debe ser en ingles." }
  }

  // Tipeamos los paises que queremos comparar.
  fun ingresarPaises(): MutableList<String> {

    entradaSalida.escribirLinea("Escribi un pais:")
    val pais = entradaSalida.leerLinea()
    chekeoDePais(pais)

    entradaSalida.escribirLinea("Escribi otro pais:")
    val pais2 = entradaSalida.leerLinea()
    chekeoDePais(pais2)

    return mutableListOf(pais, pais2)
  }
}

  // Programa con menu de opciones.
object Programa {
  var entradaSalida = Consola

  // Muestra el panel principal.
  fun iniciar() {
    entradaSalida.escribirLinea("Elegir una opcion  \n" +
            "1) Ver si 2 paises limitan.  \n" +
            "2) Analizar si 2 paises necesitan traduccion.\n" +
            "3) Comparar si 2 paises puesen ser aliados. \n" +
            "4) Los 5 paises con mas poblacion. \n" +
            "5) El continente mas poblado. \n")

    val opcion = entradaSalida.leerLinea().toInt()
    check(opcion < 7) {"Debe ingresar un numero entre 1 y 6"}

    menu(opcion)
  }

  // Direcciona la ejecucion segun la opcion seleccionada.
  private fun menu(opcion: Int) {

    when (opcion) {

      1 -> limitrofes()
      2 -> traduccion()
      3 -> aliados()
      4 -> cincoPaisesConMayorPoblacion()
      5 -> continenteMasPoblado()
      else -> entradaSalida.escribirLinea("Programa terminado.")
    }
  }

  // 1 -- Nos dice si 2 paises son limitrofes.
  private fun limitrofes() {
    val pais = IngresoYChequeo.ingresarPaises().first()
    val pais2 = IngresoYChequeo.ingresarPaises().last()

    if (Observatorio.sonLimitrofes(pais, pais2)) entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} son limitrofes.")
    else entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} no son limitrofes.")
  }

  // 2 -- Comunica si 2 paises necesitan traduccion.
  private fun traduccion() {
    val pais = IngresoYChequeo.ingresarPaises().first()
    val pais2 = IngresoYChequeo.ingresarPaises().last()

    if (Observatorio.necesitanTraduccion(pais, pais2)) entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} necesitan traduccion.")
    else entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} no nesecitan traduccion.")
  }

  // 3 -- Indica si 2 paises son aliados.
  private fun aliados() {
    val pais = IngresoYChequeo.ingresarPaises().first()
    val pais2 = IngresoYChequeo.ingresarPaises().last()

    if (Observatorio.sonPotencialesAliados(pais,pais2)) entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} son aliados.")
    else entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} no son aliados")
  }

  // 4 -- Retorna una lista con los paises con mayor poblacion.
  private fun cincoPaisesConMayorPoblacion() {
    entradaSalida.escribirLinea("Los paises con mayor poblacion son: ${Observatorio.paisesConMayorPoblacion()} .")
  }

  // 5 -- Muestra el continente mas poblado.
  private fun continenteMasPoblado() {
    entradaSalida.escribirLinea("El continente mas poblado es: ${Observatorio.continenConMasPobla()} .")
  }
}


