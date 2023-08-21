package Modelos

import Exceptions.FuncionarioInexistenteException

class Empresa(
    val funcionarios: MutableMap<Int, Funcionarios> = mutableMapOf(),
)  {
    fun adicionarFuncionario(funcionario: Funcionarios) {
        funcionarios[funcionario.codigo] = funcionario
    }

    fun removerFuncionario(codigo: Int) {
        funcionarios.remove(codigo)
    }

    fun buscarFuncionarioPorCodigo(codigo: Int): Funcionarios? {
        return funcionarios.getOrElse(codigo) {
            throw FuncionarioInexistenteException("Código: $codigo não encontrado")
        }
    }

    private fun calcularTotalSalario(): Double {
        return funcionarios.values.sumOf { it.calcularSalario() }
    }

    fun relatorioCompleto() {
        for ((codigo, funcionario) in funcionarios) {
            println("Nome: ${funcionario.nome}, Código: ${funcionario.codigo}, Salario: ${funcionario.calcularSalario()}")
            println("---------------------------------------\n")
        }
        println("O total de salários gasto pela empresa é de: ${calcularTotalSalario()}")
    }
}