package Exceptions

class FuncionarioInexistenteException(
    mensagem: String = "Funcionário inexistente"
) : Exception(mensagem) {
}