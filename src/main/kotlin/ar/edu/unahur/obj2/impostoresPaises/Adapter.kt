package ar.edu.unahur.obj2.impostoresPaises

object paisAdapate  {

    fun convertir(country: Country) {
        val pais = Pais(
                country.name,
                country.alpha3Code,
                country.population,
                country.region,
                listOf(),
                listOf()
        )
    }
}