import TipoFuncionario from "./TipoFuncionario";

class Funcionario {
    id!: Number;
    nome!: String;
    email!: String;
    telefone!: String;
    dtContratacao!: Date;
    ativo!: Boolean;
    tipoFuncionario!: TipoFuncionario;
}

export default Funcionario;