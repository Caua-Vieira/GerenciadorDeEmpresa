package Modelos

class Gerente(
    nome: String,
    codigo: Int,
    idade: Int,
    tipoDeBeneficio: TipoBeneficio,
    val salarioMensal: Double
) : Funcionarios(
    nome = nome,
    codigo = codigo,
    idade = idade,
    tipoDeBeneficio = tipoDeBeneficio
) {
    override fun calcularSalario(): Double {
        return salarioMensal + calcularBeneficio()
    }

}