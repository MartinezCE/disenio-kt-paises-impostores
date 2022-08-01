package ar.edu.unahur.obj2.impostoresPaises.cli
class Observatorio private constructor(){
    companion object{
        private var instance :Observatorio ? = null

        fun getInstance() = synchronized(this){
            if(instance == null)
                instance=Observatorio()
            instance
        }


    }
    var listadoPaises: MutableList<Pais> = mutableListOf<Pais>();


    fun sonLimitrofes(paisUno: String, paisDos: String): Boolean {
        var paisA: Pais? = listadoPaises.firstOrNull { it -> it.nombre == paisUno }
        var paisB: Pais? = listadoPaises.firstOrNull { it -> it.nombre == paisDos }
        if (paisA == null || paisB == null) {
            return false
        }
        return paisA.esLimitrofe(paisB)
    }

    fun necesitanTraduccion(paisUno: String, paisDos: String): Boolean {
        var paisA: Pais? = listadoPaises.firstOrNull { it -> it.nombre == paisUno }
        var paisB: Pais? = listadoPaises.firstOrNull { it -> it.nombre == paisDos }

        if (paisA == null || paisB == null) {
            return false
        }

        return paisA.necesitanTraduccion(paisB)
    }

    fun potencialesAliados(paisUno: String, paisDos: String): Boolean {
        var paisA: Pais? = listadoPaises.firstOrNull { it -> it.nombre == paisUno }
        var paisB: Pais? = listadoPaises.firstOrNull { it -> it.nombre == paisDos }
        if (paisA == null || paisB == null) {
            return false
        }
        return paisA.potencialesAliados(paisB)
    }

    fun irDeCompras(paisUno: String, paisDos: String): Boolean {
        var paisA : Pais? = listadoPaises.firstOrNull{it -> it.nombre == paisUno}
        var paisB : Pais? = listadoPaises.firstOrNull{it -> it.nombre == paisDos}
        if(paisA == null || paisB== null){
            return false
        }
        return paisA.irDeCompras(paisB)
    }

    fun cuantoEquivale(paisUno: String, paisDos: String, monto : Double): Double {
        var paisA: Pais? = listadoPaises.firstOrNull{it -> it.nombre == paisUno}
        var paisB: Pais? = listadoPaises.firstOrNull{it -> it.nombre == paisDos}
        if(paisA == null || paisB == null)
        {
            return 0.0
        }
        return  paisA.cuantoEquivale(paisB, monto)
    }
    fun agreagarPaises(paises: MutableList<Pais>) {
        listadoPaises.addAll(paises);
    }



}