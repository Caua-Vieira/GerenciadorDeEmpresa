package Modelos

class FuncionarioComum(
    nome: String,
    codigo: Int,
    idade: Int,
    tipoDeBeneficio: TipoBeneficio,
) : Funcionarios(
    nome = nome,
    codigo =  codigo,
    idade = idade,
    tipoDeBeneficio = tipoDeBeneficio
) {

    companion object {
        const val salarioFixo = 1400.0
    }
    override fun calcularSalario(): Double {
        return salarioFixo + calcularBeneficio()
    }

}