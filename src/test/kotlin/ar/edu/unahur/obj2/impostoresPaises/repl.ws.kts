import ar.edu.unahur.obj2.impostoresPaises.Observatorio
import ar.edu.unahur.obj2.impostoresPaises.Pais
import io.mockk.InternalPlatformDsl.toArray


// Algunos ejemplos para que jueguen un poco
// con lo que devuelve la API

/*
fun traerPaisPorNombre(nombre: String) = Observatorio.paises.find { it.nombre == nombre }
Observatorio.buscarPais("Argentina")

/////////


val argentina = Pais("Argentina","ARG",45000000,"America", listOf<String>("UNASUR","MERCOSUR"), listOf("Español"))
val chile = Pais("Chile","CHL",18191900,"America", listOf("ALCA","MERCOSUR"), listOf("Español"))
val mexico = Pais("Mexico","MEX",122273473,"America", listOf("NAFTA","Pacific Alliance"), listOf("Español"))
val eeuu = Pais("EEUU", "USA",323947000,"America", listOf("NAFTA", "OTAN"), listOf("Ingles"))
//val brasil = Pais("Brasil", "BRA",3239470000,"America", listOf("MERCOSUR"), listOf("Portugues"))
val potugal = Pais("Portugal", "POR",323947,"Europa", listOf("OTAN"), listOf("Portugues"))

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

Observatorio.paisesConMayorPoblacion()
*/