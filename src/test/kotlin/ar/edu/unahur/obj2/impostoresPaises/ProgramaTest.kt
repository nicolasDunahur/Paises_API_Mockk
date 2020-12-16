package ar.edu.unahur.obj2.impostoresPaises

import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*

class ProgramaTest : DescribeSpec({
  describe("Programa") {

    val consolaMock = mockk<Consola>()
    Programa.entradaSalida = consolaMock

    val apiChequeo = mockk<RestCountriesAPI>()
    IngresoYChequeo.apichequeo = apiChequeo
    Observatorio.api = apiChequeo

    val espaniol = Language("espaniol")
    val ingles = Language("ingles")
    val MERCOSUR = RegionalBloc("MERCOSUR","MERCOSUER")

    every { consolaMock.escribirLinea(any()) } just Runs

    every { apiChequeo.buscarPaisesPorNombre("Argentina") } returns listOf(
            Country("Argentina", "ARG", "BS AS", "America", 43, listOf("CHL"), mutableListOf(espaniol), mutableListOf(MERCOSUR)))

    every { apiChequeo.buscarPaisesPorNombre("Russia") } returns listOf(
            Country("Russia", "RUS", "Moscow", "Asia", 100, listOf("MON"), mutableListOf(), mutableListOf()))

    it("1. Paises limitrofes") {
      every { consolaMock.leerLinea() } returnsMany listOf( "1","Argentina", "Russia")

      Programa.iniciar()

      verify {
        consolaMock.escribirLinea("Los paises Argentina y Russia no son limitrofes.")
      }
    }

    it("2. Si 2 necesitan traduccion") {
      every { consolaMock.leerLinea() } returnsMany listOf( "2","Argentina", "Russia")

      Programa.iniciar()

      verify {
        consolaMock.escribirLinea("Los paises Argentina y Russia necesitan traduccion.")
      }
    }

    it("3. Paises son aliados.") {
      every { consolaMock.leerLinea() } returnsMany listOf( "3","Argentina", "Russia")

      Programa.iniciar()

      verify {
        consolaMock.escribirLinea("Los paises Argentina y Russia no son aliados")
      }
    }

    it("4. Paises con mayor poblacion") {
      every { consolaMock.leerLinea() } returns "4"
      every { apiChequeo.todosLosPaises() } returns listOf(
              Country("United States of America", "USA", "Washington", "America", 3, mutableListOf("CAN", "MEX"), mutableListOf(ingles), mutableListOf()),
              Country("Brazil", "BRA", "Brasilia", "America", 1, mutableListOf("ARG", "URU"), mutableListOf(espaniol), mutableListOf(MERCOSUR)),
              Country ("China", "", "", "Asia", 5, mutableListOf("BRA"), mutableListOf(), mutableListOf()),
              Country("India", "", "", "Asia", 4, mutableListOf("BRA"), mutableListOf(), mutableListOf()),
              Country("Indonesia", "", "", "Asia", 2, mutableListOf("BRA"), mutableListOf(), mutableListOf())
      )

      Programa.iniciar()

      verify {
        consolaMock.escribirLinea("Los paises con mayor poblacion son: [China, India, United States of America, Indonesia, Brazil] .")
      }
    }

    it("5. Continente con mayor poblacion") {
      every { apiChequeo.todosLosPaises() } returns listOf(Country("China", "", "", "Asia", 5, mutableListOf("CHI"), mutableListOf(), mutableListOf()), )
      every { consolaMock.leerLinea() } returns "5"

      Programa.iniciar()

      verify {
        consolaMock.escribirLinea("El continente mas poblado es: Asia .")
      }
    }
  }
})
