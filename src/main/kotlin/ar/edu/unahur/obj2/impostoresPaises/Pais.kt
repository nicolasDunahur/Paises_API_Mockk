package ar.edu.unahur.obj2.impostoresPaises

class Pais(
        val nombre :String,
        val codigoISo3 : String,
        val poblacion : Long,
        val continente : String,
        val bloqueRegional : List<String>,
        val idomasOficiales : List<String>
        )
{
    val paisesLimitrofes =  mutableListOf<Pais>()

    fun agregarPaisesLimitrofes(pais: Pais) = paisesLimitrofes.add(pais)
    fun esLimitrofe(pais: Pais) = paisesLimitrofes.contains(pais)
    fun compartenIdiomas(pais: Pais) = (idomasOficiales intersect pais.idomasOficiales).isNotEmpty()


}