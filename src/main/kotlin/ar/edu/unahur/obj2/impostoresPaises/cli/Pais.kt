package ar.edu.unahur.obj2.impostoresPaises.cli

import kotlin.math.roundToInt

class Pais(
    var nombre: String,
    var codigoIso3: String,
    var poblacion: Int,
    var superficie: Double,
    var continente: String,
    var codigoMoneda: String,
    var cotizacionDolar: Double,
    var paisesLimitrofes: MutableList<Pais>,
    var bloqueRegionales: MutableList<String>,
    var idiomasOficiales: MutableList<String>

) {


    fun esPlurinacional(): Boolean {
        try {
            return (idiomasOficiales.size > 0)
        }catch (e: Exception) {
            throw Exception(e.message)
        }
        
    }

    fun esUnaIsla(): Boolean {
        try {
            return (paisesLimitrofes.size == 0)
        }catch (e: Exception) {
            throw Exception(e.message)
        }

    }

    fun calcularDensidadPoblacional(): Int {
        try {
            if (superficie <= 0) {
                return 0
            }
            return (poblacion / superficie).roundToInt()
        }catch (e: Exception) {
            throw Exception(e.message)
        }

    }

    fun vecinoMasPoblado(): Pais? {
        try {
            return paisesLimitrofes.maxBy { it -> it.poblacion }
        }catch (e: Exception) {
            throw Exception(e.message)
        }
    }

    fun agregarPaisLimitrofes(pais: Pais) {
        paisesLimitrofes.add(pais);
    }

    fun agregarBloqueRegional(bloque: String) {
        bloqueRegionales.add(bloque);
    }

    fun agregarIdioma(idioma: String) {
        idiomasOficiales.add(idioma);
    }

    fun esLimitrofe(pais: Pais): Boolean {
        try {
            return paisesLimitrofes.contains(pais)
        }catch (e: Exception) {
            throw Exception(e.message)
        }

    }

    fun necesitanTraduccion(pais: Pais): Boolean {
        try {
            return pais.idiomasOficiales.any { it in idiomasOficiales }
        }catch (e: Exception) {
            throw Exception(e.message)
        }

    }

    fun potencialesAliados(pais: Pais): Boolean {
        try {
            return (necesitanTraduccion(pais) && pais.bloqueRegionales.any { it in bloqueRegionales })
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }

    fun irDeCompras(pais: Pais): Boolean {
        try {
            return (pais.cotizacionDolar > cotizacionDolar)
        } catch (e: Exception) {
            throw Exception(e.message)
        }

    }

    fun cuantoEquivale(destino: Pais, monto: Double): Double {
        try {
            var montoDolar: Double = monto / cotizacionDolar
            return montoDolar * destino.cotizacionDolar
        } catch (e: Exception) {
            throw Exception(e.message)
        }

    }


}