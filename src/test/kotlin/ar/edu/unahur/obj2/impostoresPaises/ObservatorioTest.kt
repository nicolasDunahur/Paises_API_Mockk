package ar.edu.unahur.obj2.impostoresPaises

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import io.mockk.MockK
import io.mockk.every
import io.mockk.mockk

class ObservatorioTest : DescribeSpec({

    val api = mockk<RestCountriesAPI>()
    Observatorio.api = api
    every { api.buscarPaisesPorNombre("Chile") } returns listOf(mockk())
    every { api.buscarPaisesPorNombre("Argentina") } returns listOf(mockk())
    every { api.buscarPaisesPorNombre("Mexico") } returns listOf(mockk())
    every { api.buscarPaisesPorNombre("United States of America") } returns listOf(mockk())

    describe("Requerimiento :1 - Paises son limitrofes"){

        it("Los paises son limitrofes"){
            Observatorio.sonLimitrofes("Argentina","Chile")?.shouldBeTrue()
        }

        it("Los paises NO son limitrofes"){
            Observatorio.sonLimitrofes("Mexico","Argentina").shouldBeFalse()
        }
    }

    describe("Requrimiento 2 : indica si los paises necesitan traduccion"){

        it("Los paises NO nesecitan traduccion, tienen algun idioma oficial igual"){
            Observatorio.necesitanTraduccion("Argentina","Mexico").shouldBeFalse()
        }

        it( "Los paises SI necesitan traduccion, No comparten idioma oficial"){
            Observatorio.necesitanTraduccion("Chile","United States of America").shouldBeTrue()
        }
    }

    describe("Requerimiento 3: conocer si son potenciales aliados"){

        it ("Los paises NO son aliados, no comparte el mismo bloque pero si el mismo idioma"){
            Observatorio.sonPotencialesAliados("Argentina","Mexico").shouldBeFalse()
        }

        it("SI pueden ser potenciales aliados, los paises comparte un bloque regional e idioma. "){
            Observatorio.sonPotencialesAliados("Argentina","Chile").shouldBeTrue()
        }
    }

    describe("Requerimiento 4: Paises mas poblados"){
        it ("Los paises mas poblados son: China, India, United States of America, Indonesia, Brazil"){
            //every { api.todosLosPaises() } returns listOf(mockk())
            /*
            every { api.todosLosPaises() } returns listOf(
                    mockk() { every { name } returns "China"},
                    mockk() { every { name } returns "India"},
                    mockk() { every { name } returns "United States of America"},
                    mockk() { every { name } returns "Indonesia"},
                    mockk() { every { name } returns "Brazil"}
            )
            */
            Observatorio.paisesConMayorPoblacion().shouldContainAll("China", "India", "United States of America", "Indonesia", "Brazil")
        }
    }

    describe("Requerimiento 5: Indicar cuál es el continente más poblado."){
        it ("El continente mas poblado es Asia"){
            //every { api.todosLosPaises() } returns listOf(mockk())
            Observatorio.continenConMasPobla().shouldBe("Asia")
        }
    }
})
