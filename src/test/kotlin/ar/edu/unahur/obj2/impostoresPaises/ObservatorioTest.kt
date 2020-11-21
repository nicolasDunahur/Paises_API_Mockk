package ar.edu.unahur.obj2.impostoresPaises

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class ObservatorioTest : DescribeSpec({

    val api = mockk<RestCountriesAPI>()

    describe("Requerimiento :1 - Paises son limitrofes"){
        it("Los paises son limitrofes"){

            Observatorio.buscarPais("Argentina").paisesLimitrofes.shouldContain("CHL")
            //Observatorio.sonLimitrofes("Argentina","Chile")?.shouldBeTrue()
        }
        it("Los paises NO son limitrofes"){
            //every { api.buscarPaisesPorNombre("Chile") } returns emptyList()

            Observatorio.sonLimitrofes("Mexico","Argentina").shouldBeFalse()
        }
    }
/*
    describe("Requrimiento 2 : indica si los paises necesitan traduccion"){

        it("los paises no nesecitan traduccion, tienen algun idioma oficial igual"){


            Observatorio.necesitanTraduccion("Argentina","Mexico").shouldBeFalse()
        }

        it( "los paises necesitan tradiccion, no comparten idioma oficial"){
            Observatorio.necesitanTraduccion("Chile","EEUU").shouldBeTrue()
        }
    }
    describe("Requerimiento 3: conocer si son potenciales aliados"){
        it ("los paises no son aliados, no comparte el mismo bloque"){
            Observatorio.sonPotencialesAliados("Argentina","Mexico").shouldBeFalse()
        }
        it("los paises comparte un bloque regional, puede ser potenciales aliados"){
            Observatorio.sonPotencialesAliados("Argentina","Chile").shouldBeTrue()
        }
    }
    describe("Requerimiento 4: Obtener los nombres de los 5 países con mayor población"){
        it ("los paises no son aliados, no comparte el mismo bloque"){
            Observatorio.paisesConMayorPoblacion().shouldContainAll("Brasil", "EEUU", "Mexico", "Argentina", "Chile")
        }
    }
    describe("Requerimiento 5: Indicar cuál es el continente más poblado."){
        it ("El continente mas poblado es America"){
            Observatorio.continenConMasPobla().shouldBe("America")
        }
    }

 */
})
