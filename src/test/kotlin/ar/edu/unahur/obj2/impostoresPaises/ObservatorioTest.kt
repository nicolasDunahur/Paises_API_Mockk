package ar.edu.unahur.obj2.impostoresPaises

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldHave
import io.mockk.every
import io.mockk.mockk
import java.util.*

class ObservatorioTest : DescribeSpec({
    val argentina = Pais("Argentina","ARG",45000000,"America", listOf<String>("UNASUR","MERCOSUR"), listOf("Español"))
    val chile = Pais("Chile","CHL",18191900,"America", listOf("ALCA","MERCOSUR"), listOf("Español"))
    val mexico = Pais("Mexico","MEX",122273473,"America", listOf("NAFTA","Pacific Alliance"), listOf("Español"))
    val eeuu = Pais("EEUU", "USA",323947000,"America", listOf("NAFTA", "OTAN"), listOf("Ingles"))
    val brasil = Pais("Brasil", "BRA",523947000,"America", listOf("MERCOSUR"), listOf("Portugues"))
    val potugal = Pais("Portugal", "POR",32394,"Europa", listOf("OTAN"), listOf("Portugues"))


    Observatorio.agregarPais(argentina)
    Observatorio.agregarPais(chile)
    Observatorio.agregarPais(mexico)
    Observatorio.agregarPais(eeuu)
    Observatorio.agregarPais(brasil)
    Observatorio.agregarPais(potugal)

    argentina.agregarPaisesLimitrofes(chile)
    chile.agregarPaisesLimitrofes(argentina)
    mexico.agregarPaisesLimitrofes(eeuu)
    brasil.agregarPaisesLimitrofes(argentina)

    describe("Requerimiento :1 - indicar si los dos paises son limitrofes"){
        val api = mockk<RestCountriesAPI>()
        val espaniol = Language("Espaniol")
        val alca = RegionalBloc("A","ALCA")
        val mercosur = RegionalBloc("M","MERCOSUR")

        it("los paises son limitrofes"){
            every { api.buscarPaisesPorNombre("Chile") } returns listOf(
                Country(
                        "Chile",
                        "CHL",
                        "Santiago",
                        "America",
                        18191900,
                        listOf(""),
                        listOf(espaniol),
                        listOf(alca,mercosur)
                )
            )

            Observatorio.sonLimitrofes("Argentina","Chile").shouldBeTrue()
        }
        it("los paises no son limitrofes"){
            every { api.buscarPaisesPorNombre("Chile") } returns emptyList()
            Observatorio.sonLimitrofes("Mexico","Argentina").shouldBeFalse()
        }
    }
    describe("Requrimiento 2 : indica si los paises necesitan traduccion"){

        it("los paises no nesecitan traduccion, tienen algun idoma oficial igual"){
         Observatorio.necesitanTraduccion("Argentina","Mexico")?.shouldBeFalse()
        }

        it( "los paises necesitan tradiccion, no comparten idioma oficial"){
           Observatorio.necesitanTraduccion("Chile","EEUU")?.shouldBeTrue()
        }
    }
    describe("Requerimiento 3: conocer si son potenciales aliados"){
        it ("los paises no son aliados, no comparte el mismo bloque"){
            Observatorio.sonPotencialesAliados("Argentina","Mexico")?.shouldBeFalse()
        }
        it("los paises comparte un bloque regional, puede ser potenciales aliados"){
           Observatorio.sonPotencialesAliados("Argentina","Chile")?.shouldBeTrue()
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
})
