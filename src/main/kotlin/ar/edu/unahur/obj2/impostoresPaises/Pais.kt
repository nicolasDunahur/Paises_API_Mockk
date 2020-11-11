package ar.edu.unahur.obj2.impostoresPaises

class Pais(
        val nombre :String,
        val codigoISo3 : String,
        val poblacion : Long,
        val continente : String,
        val bloqueRegional : List<String>,
        val idomasOficiales : List<String>
){

    var paisesLimitrofes =  mutableListOf<String>()

    fun agregarPaisesLimitrofes(pais: Pais) = paisesLimitrofes.add(pais.nombre)

    fun esLimitrofeDe(elNombre: String) =
            paisesLimitrofes.contains(elNombre)

    fun comparteBloqueCon(otroPais: Pais) = bloqueRegional.intersect(otroPais.bloqueRegional).isNotEmpty()

    fun necesitaTraduccionPara(otroPais: Pais): Boolean = idomasOficiales.intersect(otroPais.idomasOficiales).isEmpty()




}