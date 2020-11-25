package ar.edu.unahur.obj2.impostoresPaises

import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*


class ProgramaTest : DescribeSpec({
  describe("Programa") {
    val consolaMock = mockk<Consola>()
    Programa.entradaSalida = consolaMock

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

      Programa.iniciar()

      verify {
        consolaMock.escribirLinea("Los paises con mayor poblacion son: [China, India, United States of America, Indonesia, Brazil] .")
      }
    }

    it("5. Continente con mayor poblacion") {
      every { consolaMock.escribirLinea(any()) } just Runs
      every { consolaMock.leerLinea() } returns "5"

      Programa.iniciar()

      verify {
        consolaMock.escribirLinea("El continente mas poblado es: Asia .")
      }
    }

  }
})
