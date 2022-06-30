package br.com.sevendaysofcode.myproject;

public enum Parameter {
	
	TITLE {
		@Override
		public String regex() {
			return "title\":\"";
		}
	},
	IMAGE {
		@Override
		public String regex() {
			return "image\":\"";
		}
	},
	YEAR {
		@Override
		public String regex() {
			return "year\":\"";
		}
	},
	RATING {
		@Override
		public String regex() {
			return "imDbRating\":\""; //alterado antigo: 
		}
	},
	RANK {
		@Override
		public String regex() {
			return "rank\":\"";
		}
	},
	IDS {
		@Override
		public String regex() {
			return "id\":\"";
		}
	};

	public abstract String regex();

}
