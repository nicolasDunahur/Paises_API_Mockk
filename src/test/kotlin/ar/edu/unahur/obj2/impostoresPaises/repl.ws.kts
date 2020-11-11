import ar.edu.unahur.obj2.impostoresPaises.Observatorio
import ar.edu.unahur.obj2.impostoresPaises.Pais

// Algunos ejemplos para que jueguen un poco
// con lo que devuelve la API

val argentina = Pais("Argentina","ARG",45000000,"America", listOf<String>("UNASUR","MERCOSUR"), listOf(" Español"))

fun traerPaisPorNombre(nombre: String) = Observatorio.paises.find { it.nombre == nombre }
Observatorio.buscarPais("Argentina")