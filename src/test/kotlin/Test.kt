import ar.edu.unahur.obj2.impostoresPaises.Observatorio
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe

import io.mockk.every
import io.mockk.mockk

class Test : DescribeSpec({

    val api = mockk<Observatorio>()

    describe("Requerimiento 1 : si los paises son limitrofes "){

        it( "los paises son limitrofes"){
            every { api.sonLimitrofes("Argentina","Chile") } returns true

            api.sonLimitrofes("Argentina", "Chile").shouldBeTrue()
            Observatorio.sonLimitrofes("Argentina","Chile").shouldBeTrue()
        }
        it("los paises no son limitrofes"){
            every { api.sonLimitrofes("Mexico","Chile") } returns false

            api.sonLimitrofes("Mexico","Chile").shouldBeFalse()
            Observatorio.sonLimitrofes("Mexico","Chile").shouldBeFalse()
        }
    }

    describe("Requerimiento 2 : saber si los paises necesitan traduccion"){

        every { api.necesitanTraduccion("Argentina","Bolivia") } returns false
        it( "los paises no necesitan traduccion"){

            Observatorio.necesitanTraduccion("Argentina","Bolivia").shouldBeFalse()
            api.necesitanTraduccion("Argentina","Bolivia").shouldBeFalse()
        }

        it("los paises si necestitan traduccion"){
            every { api.necesitanTraduccion("Argentina","Brasil") } returns true

            api.necesitanTraduccion("Argentina","Brasil").shouldBeTrue()
            Observatorio.necesitanTraduccion("Brasil","Argentina").shouldBeTrue()
        }
    }

    describe("Requerimiento 3 : si los paises son potenciales aliados"){

        it("los paise son potenciales aliados"){
            every { api.sonPotencialesAliados("Argentina","Paraguay") } returns true

            Observatorio.sonPotencialesAliados("Argentina","Paraguay").shouldBeTrue()
            api.sonPotencialesAliados("Argentina","Paraguay").shouldBeTrue()
        }
        it("los paises no son potenciales aliados"){
            every { api.sonPotencialesAliados("Italia","Ecuador") } returns false

            api.sonPotencialesAliados("Italia","Ecuador").shouldBeFalse()
        }
    }

    describe("Requerimiento 4: obtener los paises con mayor poblacion"){
        it("5 paises con mayor poblacion"){
            every { api.paisesConMayorPoblacion() } returns listOf("China", "India","United States of America", "Indonesia", "Brazil")

            api.paisesConMayorPoblacion().shouldContainInOrder("China","India","United States of America", "Indonesia", "Brazil")
        }
    }

    describe("Requerimiento 5 : obtener el contienente con mayor poblacion"){
        every { api.continenteConMasPoblacion() } returns "Asia"

        api.continenteConMasPoblacion().shouldBe("Asia")
        Observatorio.continenteConMasPoblacion().shouldBe("Asia")
    }

})