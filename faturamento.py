
import pandas as pd 

def calc_faturamento():
    df_vendas = pd.read_csv('dados/vendas.csv')
    df_vendas['data_venda'] = pd.to_datetime(df_vendas['data_venda'], errors='coerce')
    faturamento = df_vendas.groupby('mes_venda')['valor_total'].sum()
    print(f"Faturamento por mês {faturamento}")



# engine = create_engine('postgresql://postgres:example@localhost:5432/postgres')
# df_vendas.to_sql('vendas', engine, index=False, if_exists='replace')