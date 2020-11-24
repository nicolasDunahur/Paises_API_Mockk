package ar.edu.unahur.obj2.impostoresPaises



// Acá encapsulamos el manejo de la consola real, desacoplandolo del programa en sí
object Consola {
  fun leerLinea() = readLine()!!
  fun escribirLinea(contenido: String) {
    println(contenido)
  }
}

// El código de nuestro programa, que (eventualmente) interactuará con una persona real
object IngresarPaises {

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

      1 -> comparSiSonLimitrofes()
      2 -> saberSiNecesitanTraduccion()
      3-> sonAlidados()
      //4-> perteneceAlBloque(pais)
      5-> cincoPaisesConMayorPoblacion()
      6-> continenteMasPoblado()
      else -> entradaSalida.escribirLinea("no hay mas opciones")


    }

  }

  fun siSiEsTrue(unaFuncion:Boolean) {
    if (unaFuncion) "Si"
    else "No"
  }


  // 1
  fun comparSiSonLimitrofes(): Boolean {
    entradaSalida.escribirLinea("Escribe un pais")
    val pais = entradaSalida.leerLinea()

    entradaSalida.escribirLinea("Escribe otro pais")
    val pais2 = entradaSalida.leerLinea()

    return Observatorio.sonLimitrofes(pais,pais2)

  }



  // 2
  fun saberSiNecesitanTraduccion(pais: String, pais2: String) =
          if (Observatorio.necesitanTraduccion(pais,pais2)) entradaSalida.escribirLinea("${pais}, ${pais2} necesitan taduccion")
          else entradaSalida.escribirLinea("${pais}, ${pais2} no nesecitan traduccion")

  // 3
  fun sonAlidados( pais: String,pais2: String) =
          if (Observatorio.sonPotencialesAliados(pais,pais2)) entradaSalida.escribirLinea("S{pais}, ${pais2} son aliados")
          else entradaSalida.escribirLinea("${pais},${pais2} no son aliados")


  // 5
  private fun cincoPaisesConMayorPoblacion() {
    entradaSalida.escribirLinea("Los paises con mayor poblacion son: ${Observatorio.paisesConMayorPoblacion()} ")
  }

  // 6
  private fun continenteMasPoblado() {
    entradaSalida.escribirLinea("El continente mas poblado es: ${Observatorio.continenteConMasPoblacion()} ")
  }

/*
  fun perteneceAlBloque(pais: String) {
    Observatorio.buscarPais(pais).bloqueRegional
    entradaSalida.escribirLinea("el ${pais} pertenece al bloque ${Observatorio.buscarPais(pais).bloqueRegional}")
  }
  fun comparSiSonLimitrofes(pais:String, pais2:String) =
          if (Observatorio.sonLimitrofes(pais,pais2)) entradaSalida.escribirLinea("los paises ${pais}, ${pais2} son limitrofes")
          else entradaSalida.escribirLinea("los paises ${pais},${pais2} no limitan")
*/


}


