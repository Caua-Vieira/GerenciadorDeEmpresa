package Modelos

class FuncionarioComissionado(
    nome: String,
    codigo: Int,
    idade: Int,
    tipoDeBeneficio: TipoBeneficio,
    val valorVendasMensal: Double
) : Funcionarios(
    nome = nome,
    codigo = codigo,
    idade = idade,
    tipoDeBeneficio = tipoDeBeneficio
) {

    companion object {
        const val valorComissao = 0.02
        const val salarioFixo = 1600.0
    }

    override fun calcularSalario(): Double {
        return salarioFixo + calcularBeneficio() + (valorVendasMensal * valorComissao)
    }
}