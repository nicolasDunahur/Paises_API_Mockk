package ar.edu.unahur.obj2.impostoresPaises

class Pais(
        val nombre :String,
        val codigoISo3 : String,
        val poblacion : Long,
        val continente : String,
        val bloqueRegional : List<String>,
        val idomasOficiales : List<String>
){

    var paisesLimitrofes =  mutableListOf<Pais>()

    fun agregarPaisesLimitrofes(pais: Pais) = paisesLimitrofes.add(pais)

    fun esLimitrofeDelString(pais: Pais) =
            paisesLimitrofes.contains(pais)

    fun esPotencialAliadoDe(pais2: Pais) = bloqueRegional.intersect(pais2.bloqueRegional)




}