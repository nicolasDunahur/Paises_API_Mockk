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
            Observatorio.sonLimitrofes("Argentina","Chile")?.shouldBeTrue()
        }
        it("Los paises NO son limitrofes"){
            //every { api.buscarPaisesPorNombre("Chile") } returns emptyList()

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
           Observatorio.paisesConMayorPoblacion().shouldContainAll("China", "India", "United States of America", "Indonesia", "Brazil")
        }
    }

    describe("Requerimiento 5: Indicar cuál es el continente más poblado."){
        it ("El continente mas poblado es Asia"){
            Observatorio.continenConMasPobla().shouldBe("Asia")
        }
    }
})

/*

Cuando se traigan a un país, pueden llegar a tener un problema de recursividad infinita al traer los países limítrofes.
 Una forma (no la única) de solucionarlo es no traer los "limítrofes de segundo nivel". Por ejemplo: si pidieron a Chile
 les vienen Argentina, Bolivia y Perú como limítrofes... si intentan traerlos de la misma forma que trajeron a Chile se
  vuelve infinito. Si, en cambio, a esos países limítrofes no les buscan sus limítrofes se corta la recursividad.

(1) En realidad es Asia, pero como yo puse al atributo population  lo puse como Int, la cuenta desborda y queda negativo.
Si cambian Int por Long les va a dar Asia.
 */