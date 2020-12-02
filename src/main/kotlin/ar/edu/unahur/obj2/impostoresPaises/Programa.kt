package ar.edu.unahur.obj2.impostoresPaises

import ar.edu.unahur.obj2.impostoresPaises.Programa.entradaSalida


object Consola {
  fun leerLinea() = readLine()!!
  fun escribirLinea(contenido: String) {
    println(contenido)
  }
}

object IngresoYChequeo {
  var apichequeo = RestCountriesAPI()

  fun chekeoDePais(unPais:String){

    checkNotNull(unPais) { "Sin nombre no puedo hacer nada :(" }

    val paisesEncontrados = apichequeo.buscarPaisesPorNombre(unPais)

    check(paisesEncontrados.isNotEmpty())
    { "No encontramos nada, fijate si lo escribiste bien, debe ser en ingles." }
  }

  fun ingresarPaises(): MutableList<String> {

    entradaSalida.escribirLinea("Escribi un pais:")
    var pais = entradaSalida.leerLinea()
    IngresoYChequeo.chekeoDePais(pais)

    entradaSalida.escribirLinea("Escribi otro pais:")
    var pais2 = entradaSalida.leerLinea()
    IngresoYChequeo.chekeoDePais(pais2)

    return mutableListOf<String>(pais, pais2)

  }
}

object Programa {

  var entradaSalida = Consola

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

  fun menu(opcion: Int) {

    when (opcion) {

      1 -> limitrofes()
      2 -> traduccion()
      3 -> aliados()
      4 -> cincoPaisesConMayorPoblacion()
      5 -> continenteMasPoblado()
      else -> entradaSalida.escribirLinea("Programa terminado.")
    }
  }

  // 1

  fun limitrofes() {
    val pais = IngresoYChequeo.ingresarPaises().first()
    val pais2 = IngresoYChequeo.ingresarPaises().last()

    if (Observatorio.sonLimitrofes(pais, pais2)) entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} son limitrofes.")
    else entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} no son limitrofes.")
  }

  // 2
  fun traduccion() {
    val pais = IngresoYChequeo.ingresarPaises().first()
    val pais2 = IngresoYChequeo.ingresarPaises().last()

    if (Observatorio.necesitanTraduccion(pais, pais2)) entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} necesitan traduccion.")
    else entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} no nesecitan traduccion.")
  }

  // 3
  fun aliados() {
    val pais = IngresoYChequeo.ingresarPaises().first()
    val pais2 = IngresoYChequeo.ingresarPaises().last()

    if (Observatorio.sonPotencialesAliados(pais,pais2)) entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} son aliados.")
    else entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} no son aliados")
  }

  // 4
  fun cincoPaisesConMayorPoblacion() {
    entradaSalida.escribirLinea("Los paises con mayor poblacion son: ${Observatorio.paisesConMayorPoblacion()} .")
  }

  // 5
  fun continenteMasPoblado() {
    entradaSalida.escribirLinea("El continente mas poblado es: ${Observatorio.continenConMasPobla()} .")
  }
}


