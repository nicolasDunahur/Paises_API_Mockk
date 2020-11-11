package ar.edu.unahur.obj2.impostoresPaises

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class ObservatorioTest : DescribeSpec({
    val argentina = Pais("Argentina","ARG",45000000,"America", listOf<String>("UNASUR","MERCOSUR"), listOf(" Español"))
    val chile = Pais("Chile","CHL",18191900,"America", listOf("ALCA"), listOf("Español"))
    val mexico = Pais("Mexico","MEX",122273473,"America", listOf("NAFTA","Pacific Alliance"), listOf("Español"))
    val eeuu = Pais("EEUU", "USA",323947000,"America", listOf("NAFTA", "OTAN"), listOf("Ingles"))

    Observatorio.agregarPais(
            listOf(argentina,chile,mexico,eeuu))

    describe("Requerimiento :1 - indicar si los dos paises son limitrofes"){
        // se soluciona con gradlew test

        argentina.agregarPaisesLimitrofes(chile)
        chile.agregarPaisesLimitrofes(argentina)
        mexico.agregarPaisesLimitrofes(eeuu)

        it("los paises son limitrofes"){
            //Observatorio.sonLimitrofes("Argentina","Chile").shouldBeTrue()
        }
        it("los paises no son limitrofes"){
            Observatorio.sonLimitrofes("Mexico","Argentina").shouldBeFalse()
        }
    }
    describe("Requrimiento 2 : indica si los paises necesitan traduccion"){

        it("los paises no nesecitan traduccion, tienen algun idoma oficial igual"){
         //   Observatorio.necesitanTraduccion("Argentina","Mexico")?.shouldBeFalse()
        }
        it( "los paises necesitan tradiccion, no comparten idioma oficial"){
           // Observatorio.necesitanTraduccion("Chile","EEUU")?.shouldBeFalse()
        }
    }
    describe("Requerimiento 3: conocer si son potenciales aliados"){
        it ("los paises no son aliados, no comparte el mismo bloque"){
            Observatorio.sonPotencialesAliados("Argentina","Mexico")?.shouldBeFalse()
        }
        it("los paises comparte un bloque regional, puede ser potenciales aliados"){
            Observatorio.sonPotencialesAliados("Mexico","EEUU")?.shouldBeTrue()
        }
    }



})