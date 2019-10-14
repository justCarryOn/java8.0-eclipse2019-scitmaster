package vo;

public class Ingredient {

	private String ingredientSeq;
	private String ingredientName;
	private String ingredientComment;
	private int quantity;

	public Ingredient(String ingredientSeq, String ingredientName, String ingredientComment, int quantity) {
		super();
		this.ingredientSeq = ingredientSeq;
		this.ingredientName = ingredientName;
		this.ingredientComment = ingredientComment;
		this.quantity = quantity;
	}

	public Ingredient(String ingredientSeq, String ingredientName, String ingredientComment) {
		super();
		this.ingredientSeq = ingredientSeq;
		this.ingredientName = ingredientName;
		this.ingredientComment = ingredientComment;
	}

	public Ingredient(String ingredientName, String ingredientComment) {
		super();
		this.ingredientName = ingredientName;
		this.ingredientComment = ingredientComment;
	}

	public Ingredient() {
		super();
	}

	public String getIngredientSeq() {
		return ingredientSeq;
	}

	public void setIngredientSeq(String ingredientSeq) {
		this.ingredientSeq = ingredientSeq;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public String getIngredientComment() {
		return ingredientComment;
	}

	public void setIngredientComment(String ingredientComment) {
		this.ingredientComment = ingredientComment;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "원료일련번호=" + ingredientSeq + ", 원료명=" + ingredientName + ", 원료설명=" + ingredientComment;
	}

}
