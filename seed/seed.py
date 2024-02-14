from sqlalchemy import create_engine,text, delete, Table, MetaData
from sqlalchemy.dialects import postgresql
import pandas as pd 
engine = create_engine('postgresql://postgres:example@db:5432/postgres')

tabelas = ['cliente', 'produto', 'tipo_funcionario', 'funcionario', 'hist_preco_produto', 'vendas']
tabela_del = ['vendas','hist_preco_produto','cliente','produto','funcionario','tipo_funcionario']
# Limpar tabelas

for tabela in tabela_del:
    with engine.connect() as connection:
        print('Excluindo registros da tabela:', tabela)
        connection.execute(text(f'DELETE FROM {tabela}'))
        connection.commit()

# Popular tabelas
for tabela in tabelas:
    try:
        with engine.connect() as conn:
            conn.begin()
            df = pd.read_csv(f'./dados/{tabela}.csv')
            df.to_sql(tabela, engine, index=False, if_exists='append')
            conn.commit()
            max_id = int(conn.execute(text(f"SELECT MAX(id) FROM {tabela}")).scalar())
            conn.execute(text(f"ALTER SEQUENCE {tabela}_seq INCREMENT BY 1;"))
            conn.execute(text(f"ALTER SEQUENCE {tabela}_seq RESTART WITH {max_id}"))
            conn.commit()
        print(f'{tabela} executada.')
    except Exception as e:
        print(f'{tabela} ñ executada. {e}')
