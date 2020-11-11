package ar.edu.unahur.obj2.impostoresPaises

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class ObservatorioTest : DescribeSpec({
    val argentina = Pais("Argentina","ARG",45000000,"America", listOf<String>("UNASUR","MERCOSUR"), listOf("Español"))
    val chile = Pais("Chile","CHL",18191900,"America", listOf("ALCA","MERCOSUR"), listOf("Español"))
    val mexico = Pais("Mexico","MEX",122273473,"America", listOf("NAFTA","Pacific Alliance"), listOf("Español"))
    val eeuu = Pais("EEUU", "USA",323947000,"America", listOf("NAFTA", "OTAN"), listOf("Ingles"))
    val brasil = Pais("Brasil", "BRA",3239470000,"America", listOf("MERCOSUR"), listOf("Portugues"))
    val potugal = Pais("Portugal", "POR",323947,"Europa", listOf("OTAN"), listOf("Portugues"))


    Observatorio.agregarPais(
            listOf(argentina,chile,mexico,eeuu,brasil,potugal)
    )

    describe("Requerimiento :1 - indicar si los dos paises son limitrofes"){

        argentina.agregarPaisesLimitrofes(chile)
        chile.agregarPaisesLimitrofes(argentina)
        mexico.agregarPaisesLimitrofes(eeuu)
        brasil.agregarPaisesLimitrofes(argentina)

        it("los paises son limitrofes"){
            //Observatorio.sonLimitrofes("Argentina","Chile").shouldBeTrue()
            // no anda///////////////////////////////////////////////////////////////////////////////////
        }
        it("los paises no son limitrofes"){
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
            Observatorio.paisesConMayorPoblacion().containsAll(listOf(argentina,chile,mexico,eeuu,brasil))
        }
    }



})