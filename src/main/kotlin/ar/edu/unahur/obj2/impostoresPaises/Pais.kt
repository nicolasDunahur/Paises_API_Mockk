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
    // no busca el string
    fun esLimitrofeDe(paisLimitrofe: Pais) =  paisesLimitrofes.contains(paisLimitrofe.codigoISo3)

    fun comparteBloqueCon(otroPais: Pais) = bloqueRegional.intersect(otroPais.bloqueRegional).isNotEmpty()

    fun necesitaTraduccionPara(otroPais: Pais) = idomasOficiales.intersect(otroPais.idomasOficiales).isEmpty()
}
