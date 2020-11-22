import ar.edu.unahur.obj2.impostoresPaises.Observatorio
import ar.edu.unahur.obj2.impostoresPaises.RestCountriesAPI
import ar.edu.unahur.obj2.impostoresPaises.adaptador


val app = RestCountriesAPI()

app.todosLosPaises()
        .groupBy { it.region }
        .map { it.value.sumBy{ continente -> continente.population.toInt() }}
        .first()