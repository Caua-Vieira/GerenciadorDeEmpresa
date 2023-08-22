package Modelos

import Exceptions.FuncionarioExistenteException
import Exceptions.FuncionarioInexistenteException

class Empresa(
    val funcionarios: MutableMap<Int, Funcionarios> = mutableMapOf(),
) {
    fun adicionarFuncionario(funcionario: Funcionarios) {
        if (funcionarios.containsKey(funcionario.codigo)) {
            throw FuncionarioExistenteException("Código ${funcionario.codigo} já existente")
        }
        funcionarios[funcionario.codigo] = funcionario
    }

    fun removerFuncionario(codigo: Int) {
        if (!funcionarios.containsKey(codigo)) {
            throw FuncionarioInexistenteException("Código $codigo de funcionário inexistente na lista")
        }
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
        val relatorio = funcionarios.values.joinToString("\n") { funcionario ->
            "Nome: ${funcionario.nome}, Código: ${funcionario.codigo}, Salario: ${funcionario.calcularSalario()}\n" +
                    "---------------------------------------"
        }
        println(relatorio)
        println("O total de salários gasto pela empresa é de: ${calcularTotalSalario()}")
    }
}