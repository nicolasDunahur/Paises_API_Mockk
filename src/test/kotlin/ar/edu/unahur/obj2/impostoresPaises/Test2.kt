package ar.edu.unahur.obj2.impostoresPaises

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk


class ObservatorioTest : DescribeSpec({

    val api = mockk<RestCountriesAPI>()
    Observatorio.api = api

    val espaniol = Language("espaniol")
    val ingles = Language("ingles")
    val MERCOSUR = RegionalBloc("ALCA","alca")

    every { api.buscarPaisesPorNombre("Chile") } returns listOf(Country(
            "Chile",
            "CHL",
            "Santiago",
            "America",
            111111111,
            listOf("ARG"),
            mutableListOf(espaniol),
            mutableListOf(MERCOSUR)
    ))

    every { api.buscarPaisesPorNombre("Argentina") } returns listOf(Country(
            "Argentina",
            "ARG",
            "BS AS",
            "America",
            111111111,
            mutableListOf("CHL"),
            mutableListOf(espaniol),
            mutableListOf(MERCOSUR)
    ))
    every { api.buscarPaisesPorNombre("Mexico") } returns listOf(Country(
            "Mexico",
            "MEX",
            "C",
            "America",
            111111111,
            mutableListOf("MEX"),
            mutableListOf(espaniol),
            mutableListOf()
    ))

    every { api.buscarPaisesPorNombre("United States of America") } returns listOf(Country(
            "United States of America",
            "USA",
            "C",
            "America",
            111111111,
            mutableListOf("BRA"),
            mutableListOf(ingles),
            mutableListOf()
    ))



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
            every { api.todosLosPaises() } returns listOf(
                Country("United States of America", "USA", "C", "America", 3, mutableListOf("BRA"), mutableListOf(ingles), mutableListOf()),
                Country("Brazil", "", "", "", 1, mutableListOf("BRA"), mutableListOf(), mutableListOf()),
                Country("China", "", "", "", 5, mutableListOf("BRA"), mutableListOf(), mutableListOf()),
                Country("India", "", "", "", 4, mutableListOf("BRA"), mutableListOf(), mutableListOf()),
                Country("Indonesia", "", "", "", 2, mutableListOf("BRA"), mutableListOf(), mutableListOf())
            )
            Observatorio.paisesConMayorPoblacion().shouldContainAll("China", "India", "United States of America", "Indonesia", "Brazil")
        }
    }

    describe("Requerimiento 5: Indicar cuál es el continente más poblado."){
        it ("El continente mas poblado es Asia"){
            every { api.todosLosPaises() } returns listOf(Country("China", "", "", "Asia", 5, mutableListOf("CHI"), mutableListOf(), mutableListOf()),
            )
            Observatorio.continenteConMasPoblacion().shouldBe("Asia")
        }
    }
})