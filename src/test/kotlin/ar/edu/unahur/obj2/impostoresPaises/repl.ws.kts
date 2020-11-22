import ar.edu.unahur.obj2.impostoresPaises.Observatorio
import ar.edu.unahur.obj2.impostoresPaises.Observatorio.api
import ar.edu.unahur.obj2.impostoresPaises.RestCountriesAPI
import ar.edu.unahur.obj2.impostoresPaises.adaptador


val pais = Observatorio.buscarPais("Argentina")
//Observatorio.buscarPais("EEUU").paisesLimitrofes

val argentina = adaptador.convertirAPais(api.paisConCodigo("ARG"))
val eeuu = adaptador.convertirAPais(api.paisConCodigo("USA"))
val chile = adaptador.convertirAPais(api.paisConCodigo("CHL"))
chile.nombre
eeuu.nombre
argentina.nombre

