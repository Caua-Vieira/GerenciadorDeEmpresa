package Modelos

abstract class Funcionarios (
    val nome: String,
    val codigo: Int,
    val idade: Int,
    val tipoDeBeneficio: TipoBeneficio
) : Calculavel {

    fun calcularBeneficio () : Double {
        val valorBeneficio = when (tipoDeBeneficio) {
            TipoBeneficio.PlanoDeSaude -> 125.0
            TipoBeneficio.Bonus -> 100.0
            TipoBeneficio.Comum -> 0.0
        }
        return valorBeneficio
    }

    companion object {
        var totalDeFuncionarios = 0
            private set
    }

    init {
        totalDeFuncionarios ++
    }



}