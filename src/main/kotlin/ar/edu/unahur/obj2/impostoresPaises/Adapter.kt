package ar.edu.unahur.obj2.impostoresPaises

object paisAdapter {

    fun convertirAPais(country: Country) =
            Pais(
                 country.name,
                 country.alpha3Code,
                 country.population,
                 country.region,
                 listOf(),
                 listOf()
            )
}