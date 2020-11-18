import ar.edu.unahur.obj2.impostoresPaises.RestCountriesAPI
import ar.edu.unahur.obj2.impostoresPaises.paisAdapate

val api = RestCountriesAPI()

val country = api.paisConCodigo("ARG")

println(paisAdapate.convertir(country))