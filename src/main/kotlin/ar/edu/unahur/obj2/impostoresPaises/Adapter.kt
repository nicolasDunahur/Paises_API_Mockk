package ar.edu.unahur.obj2.impostoresPaises

// El adaptador funciona como nexo entre el tipo de dato "Pais" y la RestCountriesAPI "Country"
object Adaptador {

    var api = RestCountriesAPI()

    fun convertirAPais(country: Country) : Pais {
        val bloques = bloquesAString(country)
        val lenguajes = lenguajesAString(country)

        val adaptado = Pais(
                country.name,
                country.alpha3Code,
                country.population.toLong(),
                country.region,
                bloques,
                lenguajes,
                country.capital,
                country.borders
        )
        return adaptado
    }

    fun bloquesAString(unCountry: Country) =
            unCountry.regionalBlocs.map {it.toString()}

    fun lenguajesAString(unCountry: Country) =
            unCountry.languages.map {it.name}

}

