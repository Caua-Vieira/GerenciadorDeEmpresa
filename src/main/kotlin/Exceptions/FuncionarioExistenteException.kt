package Exceptions

class FuncionarioExistenteException(
    mensagem: String = "Funcionário já adicionado"
) : Exception(mensagem) {

}
