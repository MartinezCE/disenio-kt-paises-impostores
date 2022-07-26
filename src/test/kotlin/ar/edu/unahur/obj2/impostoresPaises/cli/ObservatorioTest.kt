package ar.edu.unahur.obj2.impostoresPaises.cli
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class ObservatorioTest : DescribeSpec({
    describe("Observatorio"){
        var brasil: Pais = Pais(
            "Brasil",
            "BRL",
            3500000,
            3000.0,
            "america",
            "BRL",
            3.75
        )
        var argentina: Pais = Pais(
            "Argentina",
            "ARS",
            2500000,
            2500.0,
            "america",
            "ARS",
            230.0
        )
        var uruguay: Pais = Pais(
            "Uruguay",
            "UYU",
            150000,
            1500.0,
            "america",
            "UYU",
            45.0
        )
        var chile: Pais = Pais(
            "Chile",
            "CLF",
            180000,
            2000.0,
            "america",
            "CLF",
            922.0
        )

        brasil.agregarPaisLimitrofes(argentina)
        brasil.agregarPaisLimitrofes(uruguay)
        brasil.agregarIdioma("portugues")
        brasil.agregarBloqueRegional("mercosur")

        argentina.agregarPaisLimitrofes(brasil)
        argentina.agregarPaisLimitrofes(uruguay)
        argentina.agregarIdioma("español")
        argentina.agregarBloqueRegional("mercosur")

        uruguay.agregarPaisLimitrofes(brasil)
        uruguay.agregarPaisLimitrofes(argentina)
        uruguay.agregarIdioma("español")
        uruguay.agregarBloqueRegional("mercosur")

        chile.agregarPaisLimitrofes(argentina)
        chile.agregarIdioma("español")


        var listadoDePaises : MutableList<Pais> = mutableListOf(brasil, argentina, uruguay);
       Observatorio.agreagarPaises(listadoDePaises)


        it("Son limitrofes") {
            var result = Observatorio.sonLimitrofes("Argentina", "Uruguay");
            result.shouldBeTrue();
        }

        it("Son necesitanTraduccion") {
            var result = Observatorio.necesitanTraduccion("Argentina", "Brasil");
            result.shouldBeTrue();
        }

        it("Son potencialesAliados") {
            var result = Observatorio.potencialesAliados("Argentina", "Uruguay");
            result.shouldBeTrue();
        }

        it("Son irDeCompras") {
            var result = Observatorio.irDeCompras("Argentina", "Chile")
            result.shouldBeFalse();
        }
    }


})