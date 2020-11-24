package ar.edu.unahur.obj2.impostoresPaises

import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*
import jdk.internal.vm.compiler.word.LocationIdentity.any

class ProgramaTest : DescribeSpec({
  describe("Programa") {
    val consolaMock = mockk<Consola>()

    // Configuramos un mock para la entrada salida
    // TODO: hacer lo mismo para la RestCountriesAPI
    Programa.entradaSalida = consolaMock

    // Indicamos que los llamados a `escribirLinea` no hacen nada (just Runs)
    every { consolaMock.escribirLinea(any()) } just Runs

/*
    it("Son Limitrofes") {
      Programa.iniciar()
      every { consolaMock.leerLinea() } returns any().toString()
      verify {
        consolaMock.escribirLinea("elije otro pais")
      }
*/
    it("Paises con mayor poblacion") {
      Programa.iniciar()
      verify {
        consolaMock.escribirLinea("Elegir una opcion  \n" +
                "1) Ver si 2 paises limitan.  \n" +
                "2) Analizar si 2 paises necesitan traduccion.\n" +
                "3) Comparar si 2 paises puesen ser aliados. \n" +
                "4) Si un pais pertenece a derminado bloque. \n" +
                "5) Los 5 paises con mas poblacion. \n" +
                "6) El continente mas poblado. \n")
      }
      every { consolaMock.leerLinea() } returns 6.toString()
      verify {
        consolaMock.escribirLinea("Los paises con mayor poblacion son: Asia .")
      }
    }





  }


})

/*
package ar.edu.unahur.obj2.impostoresPaises

import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*

class ProgramaTest : DescribeSpec({
  describe("Programa") {
    val consolaMock = mockk<Consola>()

    // Configuramos un mock para la entrada salida
    // TODO: hacer lo mismo para la RestCountriesAPI
    Programa.entradaSalida = consolaMock

    // Indicamos que los llamados a `escribirLinea` no hacen nada (just Runs)
    every { consolaMock.escribirLinea(any()) } just Runs

    it("buscar país") {
      // Cuando se llame a `leerLinea()`, simulamos que el/la usuaria escribió "thailand".
      // Notar que esto lo configuramos *antes* de iniciar el programa,
      // para que cuando efectivamente se llame al método ya el mock sepa qué tiene que hacer.
      every { consolaMock.leerLinea() } returns "thailand"

      // Iniciamos el programa
      Programa.iniciar()

      // Verificamos que se escribió "por pantalla" el resultado esperado
      verify {
        consolaMock.escribirLinea("Thailand (THA) es un país de Asia, con una población de 65327652 habitantes.")
      }
    }
  }
})
 */
