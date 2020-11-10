package ar.edu.unahur.obj2.impostoresPaises

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class ObservatorioTest : DescribeSpec({
    val argentina = Pais("Argentina","ARG",45000000,"America", listOf<String>("UNASUR","MERCOSUR"), listOf(" Español"))
    val chile = Pais("Chile","CHL",18191900,"America", listOf("ALCA"), listOf("Español"))
    val mexico = Pais("Mexico","MEX",122273473,"America", listOf("Pacific Alliance","NAFTA"), listOf("Español"))
    val eeuu = Pais("EEUU", "USA",323947000,"America", listOf("NAFTA", "OTAN"), listOf("Ingles"))

    Observatorio.agregarPais(
            listOf(argentina,chile,mexico,eeuu))

    describe("Requerimiento :1 - indicar si los dos paises son limitrofes"){

        argentina.agregarPaisesLimitrofes(chile)
        chile.agregarPaisesLimitrofes(argentina)
        mexico.agregarPaisesLimitrofes(eeuu)

        it("los paises son limitrofes"){
            Observatorio.sonLimitrofes("Chile","Argentina")?.shouldBeTrue()
        }
        it("los paises no son limitrofes"){
            Observatorio.sonLimitrofes("Mexico","Argentina")?.shouldBeFalse()
        }
    }
    describe("Requerimiento: 2 - _si los paises necesitan traduccion"){

        it("los paises no necesitan traduccion comparte un idoma oficial"){
            //Observatorio.necesitanTraduccion("Argentina","Chile").shouldBeFalse()
        }
        it("los paises necesitan traduccion, no comparte un idioma oficial"){
            //Observatorio.necesitanTraduccion("Mexico","EEUU").shouldBeTrue()
        }
    }

    describe("si los paises son aliados o no "){
        it("los paises son aliados"){
            //Observatorio.potencialAliados(mexico, eeuu).shouldBeTrue()
        }
        it("buscar pais nombre"){
            Observatorio.buscarNombre("Argentina")
        }
    }


})