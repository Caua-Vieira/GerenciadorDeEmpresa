package Modelos

class Relatorios(val empresa: Empresa) {

    fun gerarRelatorioPorDepartamento(tipoFuncionario: Class<out Funcionarios>): String {
        val funcionarios = empresa.funcionarios.toList().filterIsInstance(tipoFuncionario)
        val relatorio = StringBuilder()

        val tipoFuncionarioNome = when (tipoFuncionario) {
            FuncionarioPorHora::class.java -> "Funcionários por hora"
            FuncionarioComissionado::class.java -> "Funcionários comissionado"
            FuncionarioComum::class.java -> "Funcionários comum"
            else -> "Funcionário desconhecido"
        }

        relatorio.append("Relatório de $tipoFuncionarioNome")

        for (funcionario in funcionarios) {
            relatorio.append("Nome do funcionário: ${funcionario.nome}")
            relatorio.append("Código do funcionário: ${funcionario.codigo}")
            relatorio.append("Idade do funcionário: ${funcionario.idade}")
            relatorio.append("Tipo de benefício do funcionário: ${funcionario.tipoDeBeneficio}")
            relatorio.append("Salário do funcionário: ${funcionario.calcularSalario()}")
            when (funcionario) {
                is FuncionarioPorHora -> {
                    relatorio.append("Horas trabalhadas do funcionário: ${funcionario.horasTrabalhadas}")
                }

                is FuncionarioComissionado -> {
                    relatorio.append("Venda mensal do funcionário: ${funcionario.valorVendasMensal}")
                }
            }
            relatorio.append("-----------------------------\n")
        }
        return relatorio.toString()
    }

}
