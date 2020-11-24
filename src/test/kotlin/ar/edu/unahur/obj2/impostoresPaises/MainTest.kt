package ar.edu.unahur.obj2.impostoresPaises

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.*

class MainTest : DescribeSpec({

    describe("testear consola"){
        val consolaMockk = mockk<Consola>()
        Programa.entradaSalida = consolaMockk

        it("si son limitrofes"){
            every { consolaMockk.escribirLinea(any()) } just Runs
            every { consolaMockk.leerLinea() } returns "ejije un pais"

            Programa.iniciar()

            verify { consolaMockk.escribirLinea("elije un pais") }
        }
    }


})
