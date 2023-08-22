package Modelos

class Relatorios(private val empresa: Empresa) {

    fun gerarRelatorioPorDepartamento(tipoFuncionario: Class<out Funcionarios>): String {
        val funcionarios = empresa.funcionarios.values.filterIsInstance(tipoFuncionario)
        val relatorio = StringBuilder()

        val tipoFuncionarioNome = when (tipoFuncionario) {
            FuncionarioPorHora::class.java -> "Funcionários por hora"
            FuncionarioComissionado::class.java -> "Funcionários comissionado"
            FuncionarioComum::class.java -> "Funcionários comum"
            else -> "Funcionário desconhecido"
        }

        relatorio.append("Relatório de $tipoFuncionarioNome")

        for (funcionario in funcionarios) {
            relatorio.append(
                """ 
                Nome do funcionário: ${funcionario.nome}
                Código do funcionário: ${funcionario.codigo}
                Idade do funcionário: ${funcionario.idade}
                Tipo de benefício do funcionário: ${funcionario.tipoDeBeneficio}
                Salário do funcionário: ${funcionario.calcularSalario()}"""
            )
            when (funcionario) {
                is FuncionarioPorHora -> {
                    relatorio.append("Horas trabalhadas do funcionário: ${funcionario.horasTrabalhadas}")
                }

                is FuncionarioComissionado -> {
                    relatorio.append("Venda mensal do funcionário: ${funcionario.valorVendasMensal}")
                }
            }
            relatorio.append("\n---------------------------------------------------\n")
        }
        return relatorio.toString()
    }

}
