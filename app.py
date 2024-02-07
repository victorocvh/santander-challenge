from generate_fake_date import gera_dados_funcionario,gera_tipo_funcionario,gera_dados_cliente,gera_dados_produtos
from generate_tables import generate_tabela_preco, generate_tabela_vendas
from faturamento import calc_faturamento

def main():
    gera_dados_cliente()
    gera_dados_produtos()
    gera_tipo_funcionario()
    gera_dados_funcionario()
    generate_tabela_preco()
    generate_tabela_vendas()
    calc_faturamento()

if __name__ == '__main__':
    main()