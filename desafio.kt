enum class Nivel {Básico, Intermediário, Avançado}

data class Usuario(val nome: String, val email: String, val tipoUsuario: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun imprimirListaInscritos(){
        for(user in inscritos){
            println(user.nome)
        }
    }
    
    fun imprimirGradeFormacao(){
        for(cont in conteudos){
            println("${cont.nome} - ${cont.duracao}")
        }
    }
}

fun main() {
    
    val cursoAndroid = ConteudoEducacional("Curso Android", 100, Nivel.Intermediário)
    val cursoWeb = ConteudoEducacional("Curso Web", 90, Nivel.Básico)
    val cursoIos = ConteudoEducacional("Curso IOS", 120, Nivel.Avançado)
    
    val listConteudos = mutableListOf<ConteudoEducacional>()
    listConteudos.add(cursoAndroid)
    listConteudos.add(cursoWeb)
    listConteudos.add(cursoIos)
    
    val formacaoAndroid = Formacao("Formação Completa", listConteudos, Nivel.Avançado)
    
    val Joao = Usuario("João", "joao@mail.com", "premium")
    val Maria = Usuario("Maria", "maria@mail.com", "premium")
    val Clovis = Usuario("Clovis", "clovis@mail.com", "free")
    
    formacaoAndroid.matricular(Joao)
    formacaoAndroid.matricular(Maria)
    
    print("Formação: ")
    println("${formacaoAndroid.nome} - ${formacaoAndroid.nivel}")
    println("Syllabus: ")
    println(formacaoAndroid.imprimirGradeFormacao())
    println()
    println("Lista de inscritos aceitos: ")
    println(formacaoAndroid.imprimirListaInscritos())
}