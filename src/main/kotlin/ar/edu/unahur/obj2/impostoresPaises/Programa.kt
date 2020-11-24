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

    entradaSalida.escribirLinea("elegir una opcion")
    val opcion = entradaSalida.leerLinea().toInt()

    memu(opcion)

  }

  fun memu(opcion: Int) {
    entradaSalida.escribirLinea("escribe un pais")
    val pais = entradaSalida.leerLinea()
    entradaSalida.escribirLinea("escribe  otro pais")
    val pais2 = entradaSalida.leerLinea()

    when (opcion) {

      1 -> comparSiSonLimitrofes(pais,pais2)
      2 -> saberSiNecesitanTraduccion(pais,pais2)
      3-> sonAlidados(pais,pais)
      4-> perteneceAlBloque(pais)
      else -> entradaSalida.escribirLinea("no hay mas opciones")


    }

  }

  fun perteneceAlBloque(pais: String) {
    Observatorio.buscarPais(pais).bloqueRegional
    entradaSalida.escribirLinea("el ${pais} pertenece al bloque ${Observatorio.buscarPais(pais).bloqueRegional}")
  }

  fun comparSiSonLimitrofes(pais:String, pais2:String) =
          if (Observatorio.sonLimitrofes(pais,pais2)) entradaSalida.escribirLinea("los paises ${pais}, ${pais2} son limitrofes")
          else entradaSalida.escribirLinea("los paises ${pais},${pais2} no limitan")

  fun saberSiNecesitanTraduccion(pais: String, pais2: String) =
          if (Observatorio.necesitanTraduccion(pais,pais2)) entradaSalida.escribirLinea("${pais}, ${pais2} necesitan taduccion")
          else entradaSalida.escribirLinea("${pais}, ${pais2} no nesecitan traduccion")
  fun sonAlidados( pais: String,pais2: String) =
          if (Observatorio.sonPotencialesAliados(pais,pais2)) entradaSalida.escribirLinea("S{pais}, ${pais2} son aliados")
          else entradaSalida.escribirLinea("${pais},${pais2} no son aliados")


}
