package ar.edu.unahur.obj2.impostoresPaises

import ar.edu.unahur.obj2.impostoresPaises.Programa.entradaSalida
import ar.edu.unahur.obj2.impostoresPaises.adaptador.api

object Consola {
  fun leerLinea() = readLine()!!
  fun escribirLinea(contenido: String) {
    println(contenido)
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

    memu(opcion)
  }

  fun memu(opcion: Int) {

    when (opcion) {

      1 -> limitrofes()
      2 -> traduccion()
      3 -> aliados()
      4 -> cincoPaisesConMayorPoblacion()
      5 -> continenteMasPoblado()
      else -> entradaSalida.escribirLinea("Programa terminado.")
    }
  }
  fun chekeoDePais(unPais:String){
    checkNotNull(unPais) { "Sin nombre no puedo hacer nada :(" }

    val paisesEncontrados = api.buscarPaisesPorNombre(unPais)

    check(paisesEncontrados.isNotEmpty())
    { "No encontramos nada, fijate si lo escribiste bien" }
  }
  // 1

  fun limitrofes() {
    entradaSalida.escribirLinea("Escribe un pais:")
    var pais = entradaSalida.leerLinea()
    chekeoDePais(pais)

    entradaSalida.escribirLinea("Escribe otro pais:")
    var pais2 = entradaSalida.leerLinea()
    chekeoDePais(pais2)

    if (Observatorio.sonLimitrofes(pais, pais2)) entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} son limitrofes.")
    else entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} no son limitrofes.")
  }

  // 2
  fun traduccion() {
    entradaSalida.escribirLinea("Escribe un pais:")
    var pais = entradaSalida.leerLinea()

    entradaSalida.escribirLinea("Escribe otro pais:")
    var pais2 = entradaSalida.leerLinea()

    if (Observatorio.necesitanTraduccion(pais, pais2)) entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} necesitan traduccion.")
    else entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} no nesecitan traduccion.")
  }

  // 3
  fun aliados() {
    entradaSalida.escribirLinea("Escribe un pais:")
    var pais = entradaSalida.leerLinea()

    entradaSalida.escribirLinea("Escribe otro pais:")
    var pais2 = entradaSalida.leerLinea()

    if (Observatorio.sonPotencialesAliados(pais,pais2)) entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} son aliados.")
    else entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} no son aliados")
  }

  // 4
  fun cincoPaisesConMayorPoblacion() {
    entradaSalida.escribirLinea("Los paises con mayor poblacion son: ${Observatorio.paisesConMayorPoblacion()} .")
  }

  // 5
  fun continenteMasPoblado() {
    entradaSalida.escribirLinea("El continente mas poblado es: ${Observatorio.continenteConMasPoblacion()} .")
  }
}


