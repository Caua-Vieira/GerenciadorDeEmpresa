package Main

import Exceptions.FuncionarioExistenteException
import Exceptions.FuncionarioInexistenteException
import Modelos.*

fun main() {
    val empresa = Empresa()
    val funcionario = FuncionarioComum(
        nome = "Marcos",
        codigo = 223120,
        idade = 20,
        tipoDeBeneficio = TipoBeneficio.PlanoDeSaude
    )

    val joao = FuncionarioPorHora(
        nome = "João",
        codigo = 6789,
        idade = 42,
        horasTrabalhadas = 50,
        tipoDeBeneficio = TipoBeneficio.PlanoDeSaude
    )

    val jonas = FuncionarioPorHora(
        nome = "Jonas",
        codigo = 4567,
        idade = 22,
        horasTrabalhadas = 45,
        tipoDeBeneficio = TipoBeneficio.Comum
    )

    val larissa = FuncionarioPorHora(
        nome = "Larissa",
        codigo = 1234,
        idade = 54,
        horasTrabalhadas = 48,
        tipoDeBeneficio = TipoBeneficio.Bonus
    )

    try {
        empresa.adicionarFuncionario(funcionario)
        empresa.adicionarFuncionario(jonas)
        empresa.adicionarFuncionario(larissa)
        empresa.adicionarFuncionario(joao)
        println("Funcionários adicionados com sucesso!")
    } catch (e: FuncionarioExistenteException) {
        println("Falha ao tentar adicionar funcionário")
        e.printStackTrace()
    }


    try {
        val funcionarioEncontrado = empresa.buscarFuncionarioPorCodigo(1234)
        println(
            """Funcionário encontrado:
            |Nome: ${funcionarioEncontrado?.nome}
            |Código: ${funcionarioEncontrado?.codigo}
            |Idade: ${funcionarioEncontrado?.idade}
            |Salário: ${funcionarioEncontrado?.calcularSalario()}
        """.trimMargin()
        )
    } catch (e: FuncionarioInexistenteException) {
        println(
            """Falha na busca
            |Funcionario não registrado ou inexistente
        """.trimMargin()
        )
        e.printStackTrace()
    } finally {
        println("O total de funcionários registrados na empresa é ${Funcionarios.totalDeFuncionarios}")
    }

    val relatorios = Relatorios(empresa)
    val relatorioPorHora = relatorios.gerarRelatorioPorDepartamento(FuncionarioPorHora::class.java)
    println(relatorioPorHora)

    try {
        empresa.removerFuncionario(14)
        println("Funcionário removido com sucesso!")
    } catch (e: FuncionarioInexistenteException) {
        println("Erro ao remover funcionário")
        e.printStackTrace()
    }

    println(empresa.relatorioCompleto())

}
