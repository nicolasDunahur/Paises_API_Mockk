package ar.edu.unahur.obj2.impostoresPaises

object paisAdapter {

    var api = RestCountriesAPI()

    fun convertirAPais(country: Country) : Pais {
        val bloques = bloquesAString(country)
        val lenguajes = lenguajesAString(country)
        val limitrofes = limitrofesAString(country)

        val adaptado = Pais(
                country.name,
                country.alpha3Code,
                country.population.toLong(),
                country.region,
                bloques,
                lenguajes,
                country.capital,
                limitrofes
        )
        return adaptado
    }


    fun bloquesAString(unCountry: Country) =
            unCountry.regionalBlocs.map {it.toString()}

    fun lenguajesAString(unCountry: Country) =
            unCountry.languages.map {it.toString()}

    fun limitrofesAString(unCountry: Country) =
            unCountry.borders.map {it.toString()}

}

