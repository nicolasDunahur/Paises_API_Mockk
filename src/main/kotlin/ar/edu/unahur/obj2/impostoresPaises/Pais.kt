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

    fun esLimitrofeDe(paisLimitrofe: Pais) =
            paisesLimitrofes.contains(paisLimitrofe)

    fun comparteBloqueCon(otroPais: Pais) = bloqueRegional.intersect(otroPais.bloqueRegional).isNotEmpty()

    fun necesitaTraduccionPara(otroPais: Pais): Boolean = idomasOficiales.intersect(otroPais.idomasOficiales).isEmpty()




}