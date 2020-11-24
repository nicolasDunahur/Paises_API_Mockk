package ar.edu.unahur.obj2.impostoresPaises

import ar.edu.unahur.obj2.impostoresPaises.Programa.entradaSalida


// Acá encapsulamos el manejo de la consola real, desacoplandolo del programa en sí
object Consola {
  fun leerLinea() = readLine()!!
  fun escribirLinea(contenido: String) {
    println(contenido)
  }
}

object Programa {
  // Ambas son variables para poder cambiarlas en los tests
  var entradaSalida = Consola


  fun iniciar() {

    entradaSalida.escribirLinea("Elegir una opcion  \n" +
            "1) Ver si 2 paises limitan.  \n" +
            "2) Analizar si 2 paises necesitan traduccion.\n" +
            "3) Comparar si 2 paises puesen ser aliados. \n" +
            "4) Si un pais pertenece a derminado bloque. \n" +
            "5) Los 5 paises con mas poblacion. \n" +
            "6) El continente mas poblado. \n")

    val opcion = entradaSalida.leerLinea().toInt()

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

  // 1
  fun limitrofes() {
    entradaSalida.escribirLinea("Escribe un pais")
    var pais = entradaSalida.leerLinea()

    entradaSalida.escribirLinea("Escribe otro pais")
    var pais2 = entradaSalida.leerLinea()

    if (Observatorio.sonLimitrofes(pais, pais2)) entradaSalida.escribirLinea("Los paises ${pais} y ${pais2} son limitrofes.")
    else entradaSalida.escribirLinea("Los paises ${pais},${pais2} no limitan.")
  }

  // 2
  fun traduccion() {
    entradaSalida.escribirLinea("Escribe un pais:")
    var pais = entradaSalida.leerLinea()

    entradaSalida.escribirLinea("Escribe otro pais:")
    var pais2 = entradaSalida.leerLinea()

    if (Observatorio.necesitanTraduccion(pais, pais2)) entradaSalida.escribirLinea("${pais}, ${pais2} necesitan traduccion.")
    else entradaSalida.escribirLinea("${pais}, ${pais2} no nesecitan traduccion.")
  }

  // 3
  fun aliados() {
    entradaSalida.escribirLinea("Escribe un pais:")
    var pais = entradaSalida.leerLinea()

    entradaSalida.escribirLinea("Escribe otro pais:")
    var pais2 = entradaSalida.leerLinea()

    if (Observatorio.sonPotencialesAliados(pais,pais2)) entradaSalida.escribirLinea("Los paises ${pais}, ${pais2} son aliados.")
    else entradaSalida.escribirLinea("Los paises ${pais},${pais2} no son aliados")
  }

  // 4
  private fun cincoPaisesConMayorPoblacion() {
    entradaSalida.escribirLinea("Los paises con mayor poblacion son: ${Observatorio.paisesConMayorPoblacion()} .")
  }

  // 5
  private fun continenteMasPoblado() {
    entradaSalida.escribirLinea("El continente mas poblado es: ${Observatorio.continenteConMasPoblacion()} .")
  }

}


