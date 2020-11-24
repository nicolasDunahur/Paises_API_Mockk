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


    it("Son Limitrofes") {
      Programa.iniciar()
      every { consolaMock.leerLinea() } returns any().toString()
      verify {
        consolaMock.escribirLinea("elije otro pais")
      }


    }

  }


})
