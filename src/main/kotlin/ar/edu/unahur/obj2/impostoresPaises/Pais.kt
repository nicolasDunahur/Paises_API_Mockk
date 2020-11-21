package ar.edu.unahur.obj2.impostoresPaises

open class Pais(
        val nombre:String,
        val codigoISo3: String,
        val poblacion: Long,
        val continente: String,
        val bloqueRegional: List<String>,
        val idomasOficiales: List<String>,
        val capital: String,
        val paisesLimitrofes: List<String>
){
    fun esLimitrofeDe(paisLimitrofe: Pais) = paisesLimitrofes.contains(paisLimitrofe)

    fun comparteBloqueCon(otroPais: Pais) = bloqueRegional.intersect(otroPais.bloqueRegional).isNotEmpty()

    fun necesitaTraduccionPara(otroPais: Pais) = idomasOficiales.intersect(otroPais.idomasOficiales).size ==1
}