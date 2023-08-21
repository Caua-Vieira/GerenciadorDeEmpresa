package Modelos

class FuncionarioPorHora(
    nome: String,
    codigo: Int,
    idade: Int,
    tipoDeBeneficio: TipoBeneficio,
    val horasTrabalhadas: Int,
) : Funcionarios(
    nome = nome,
    codigo = codigo,
    idade = idade,
    tipoDeBeneficio = tipoDeBeneficio
) {
    companion object {
        const val valorHoraExtra = 2.0
        const val horasPadraoPorSemana = 40
        const val valorHora = 10.0
    }

    override fun calcularSalario(): Double {
        val salarioBase = horasTrabalhadas * valorHora
        val horaExtra = maxOf(horasTrabalhadas - horasPadraoPorSemana, 0)
        val salarioHoraExtra = horaExtra * valorHora * valorHoraExtra
        return salarioHoraExtra + salarioBase + calcularBeneficio()
    }

}

//953484213