package br.com.caelum.comportamentais.strategy.withenum;

import br.com.caelum.comportamentais.strategy.withenum.Normal;
import br.com.caelum.comportamentais.strategy.withenum.Sedex;

public enum TipoFrete {

	NORMAL {
		@Override
		public Frete obterFrete() {
			return new Normal();
		}
	},
	SEDEX {
		@Override
		public Frete obterFrete() {
			return new Sedex();
		}
	};
	
	public abstract Frete obterFrete();
	
}
