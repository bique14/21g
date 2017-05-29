import java.awt.Color;

public enum ColorName {
	RED(Color.RED, "red") {
		@Override
		public ColorName next() {
			// TODO Auto-generated method stub
			return WHITE;
		}
	}, WHITE(Color.WHITE, "white") {
		@Override
		public ColorName next() {
			// TODO Auto-generated method stub
			return BLUE;
		}
	}, BLUE(Color.BLUE, "blue") {
		@Override
		public ColorName next() {
			// TODO Auto-generated method stub
			return BLACK;
		}
	}, BLACK(Color.BLACK, "black") {
		@Override
		public ColorName next() {
			// TODO Auto-generated method stub
			return RED;
		}
	};

	Color color;
	String nameColor;

	private ColorName(Color color, String nameColor) {
		this.color = color;
		this.nameColor = nameColor;
	}
	
	public Color getColor() {
		return color;
	}

	public String getNameColor() {
		return nameColor;
	}
	
	public abstract ColorName next();
	
}
