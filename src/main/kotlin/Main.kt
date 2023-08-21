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
        codigo = 3456,
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

    empresa.adicionarFuncionario(funcionario)
    empresa.adicionarFuncionario(jonas)
    empresa.adicionarFuncionario(larissa)
//
//    empresa.relatorioCompleto()
//
//    try {
//        empresa.buscarFuncionarioPorCodigo(1234)
//        println(
//            """Funcionário encontrado:
//            |Nome: ${funcionario.nome}
//            |Código: ${funcionario.codigo}
//            |Idade: ${funcionario.idade}
//            |Salário: ${funcionario.calcularSalario()}
//        """.trimMargin()
//        )
//    } catch (e: FuncionarioInexistenteException) {
//        println(
//            """Falha na busca
//            |Funcionario não registrado ou inexistente
//        """.trimMargin()
//        )
//        e.printStackTrace()
//    } finally {
//        println("O total de funcionários registrados na empresa é ${Funcionarios.totalDeFuncionarios}")
//    }

    val relatorios = Relatorios(empresa)
    println(relatorios.gerarRelatorioPorDepartamento(FuncionarioPorHora::class.java))

}
