package ar.edu.unahur.obj2.impostoresPaises

import ar.edu.unahur.obj2.impostoresPaises.Observatorio.api
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*
import kotlin.collections.mutableListOf as mutableListOf1


class ProgramaTest : DescribeSpec({
  describe("Programa") {
    val consolaMock = mockk<Consola>()
    Programa.entradaSalida = consolaMock
    Observatorio.api = mockk<RestCountriesAPI>()

    val espaniol = Language("espaniol")
    val ingles = Language("ingles")
    val MERCOSUR = RegionalBloc("MERCOSUR","MERCOSUER")

    every { api.buscarPaisesPorNombre("Argentina") } returns listOf(
            Country("Argentina", "ARG", "BS AS", "America", 43, kotlin.collections.mutableListOf("CHL"), kotlin.collections.mutableListOf(espaniol), kotlin.collections.mutableListOf(MERCOSUR)))

    every { api.buscarPaisesPorNombre("Russia") } returns listOf(
            Country("Russia", "RUS", "Moscow", "Asia", 100, kotlin.collections.mutableListOf("MON"), kotlin.collections.mutableListOf(), kotlin.collections.mutableListOf()))

    it("1. Paises limitrofes") {
      every { consolaMock.escribirLinea(any()) } just Runs
      every { consolaMock.leerLinea() } returnsMany listOf( "1","Argentina", "Russia")

      Programa.iniciar()

      verify {
        consolaMock.escribirLinea("Los paises Argentina y Russia no son limitrofes.")
      }
    }

    it("2. Paises con mayor poblacion") {
      every { consolaMock.escribirLinea(any()) } just Runs
      every { consolaMock.leerLinea() } returnsMany listOf( "2","Argentina", "Russia")

      Programa.iniciar()

      verify {
        consolaMock.escribirLinea("Los paises Argentina y Russia necesitan traduccion.")
      }
    }

    it("3. Paises son aliados.") {
      every { consolaMock.escribirLinea(any()) } just Runs
      every { consolaMock.leerLinea() } returnsMany listOf( "3","Argentina", "Russia")

      Programa.iniciar()

      verify {
        consolaMock.escribirLinea("Los paises Argentina y Russia no son aliados")
      }
    }

    it("4. Paises con mayor poblacion") {
      every { consolaMock.escribirLinea(any()) } just Runs
      every { consolaMock.leerLinea() } returns "4"
      every { api.todosLosPaises() } returns listOf(
              Country("United States of America", "USA", "Washington", "America", 3, mutableListOf1("CAN", "MEX"), mutableListOf1(ingles), mutableListOf1()),
              Country("Brazil", "BRA", "Brasilia", "America", 1, mutableListOf1("ARG", "URU"), mutableListOf1(espaniol), mutableListOf1(MERCOSUR)),
              Country ("China", "", "", "", 5, mutableListOf1("BRA"), mutableListOf1(), mutableListOf1()),
              Country("India", "", "", "", 4, mutableListOf1("BRA"), mutableListOf1(), mutableListOf1()),
              Country("Indonesia", "", "", "", 2, mutableListOf1("BRA"), mutableListOf1(), mutableListOf1())
      )

      Programa.iniciar()

      verify {
        consolaMock.escribirLinea("Los paises con mayor poblacion son: [China, India, United States of America, Indonesia, Brazil] .")
      }
    }

    it("5. Continente con mayor poblacion") {
      every { api.todosLosPaises() } returns listOf(Country("China", "", "", "Asia", 5, mutableListOf1("CHI"), mutableListOf1(), mutableListOf1()), )
      every { consolaMock.escribirLinea(any()) } just Runs
      every { consolaMock.leerLinea() } returns "5"

      Programa.iniciar()

      verify {
        consolaMock.escribirLinea("El continente mas poblado es: Asia .")
      }
    }

  }
})
