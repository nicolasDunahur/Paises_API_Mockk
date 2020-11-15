package ar.edu.unahur.obj2.impostoresPaises

class paisAdapate(val pais: Country){
    val nombre = pais.name,
    val codigoISo3 = pais.alpha3Code,
    val poblacion = pais.population,
    val continente = pais.region,
    val bloqueRegional = pais.regionalBlocs,
    val idomasOficiales= pais.languages
}